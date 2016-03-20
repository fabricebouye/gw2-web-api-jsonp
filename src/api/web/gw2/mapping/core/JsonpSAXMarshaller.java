/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;

/**
 * A SAX (event-based) implementation of the JSON-P marshaller.
 * @author Fabrice Bouyé
 */
final class JsonpSAXMarshaller extends JsonpAbstractMarshaller {

    /**
     * Creates a new empty instance.
     */
    public JsonpSAXMarshaller() {
    }

    @Override
    public <T> T loadObject(final Class<T> targetClass, final InputStream input) throws IOException {
        // Parse JSON using event parser.
        try (final JsonParser parser = Json.createParser(input)) {
            while (parser.hasNext()) {
                final JsonParser.Event event = parser.next();
                switch (event) {
                    // Start object marshalling.
                    case START_OBJECT: {
                        final T result = marshallObject(parser, null, targetClass);
                        return result;
                    }
                    // Ignoge all other events.
                    default: {
                    }
                }
            }
        }
        return null;
    }

    @Override
    public <T> Collection<T> loadObjectArray(final Class<T> targetClass, final InputStream input) throws IOException {
        // Parse JSON using event parser.
        try (final JsonParser parser = Json.createParser(input)) {
            while (parser.hasNext()) {
                final JsonParser.Event event = parser.next();
                switch (event) {
                    // Start array marshalling.
                    case START_ARRAY: {
                        final Collection<T> result = marshallArray(parser, null, targetClass);
                        return result;
                    }
                    // Ignoge all other events.
                    default: {
                    }
                }
            }
        }
        return null;
    }

    @Override
    public <T> T loadRuntimeObject(final String selector, final String pattern, final InputStream input) throws IOException {
        final JsonpDOMMarshaller delegated = new JsonpDOMMarshaller();
        final T result = delegated.loadRuntimeObject(selector, pattern, input);
        return result;
    }

    /**
     * Marshall an object of the desired type from the parser's current location.
     * <br>Regular objects, use simple injection.
     * @param <T> The type to use.
     * @param parser The parser instance.
     * @param targetClass The target class.
     * @return A {@code T} instance, may be {@code null}.
     * @throws IOException In case of IO errors.
     */
    private <T> T marshallObject(final JsonParser parser, final Field field, final Class<T> targetClass) throws IOException {
        // Initialize concrete empty instance.
        final T result = createConcreteEmptyInstance(targetClass);
        if (result == null) {
            // @todo We need to skip what's remaining in the parser.
            // skipContent(parser, Starter.OBJECT);
            return null;
        }
        // Get concrete class for concrete instance.
        final Class<T> concreteClass = (Class<T>) result.getClass();
        try {
            Field childField = null;
            while (parser.hasNext()) {
                final JsonParser.Event event = parser.next();
                switch (event) {
                    case KEY_NAME: {
                        final String key = parser.getString();
                        final String fieldName = JsonpUtils.INSTANCE.jsonKeyToJavaFieldName(key);
                        childField = lookupField(fieldName, concreteClass);
                        if (childField == null) {
                            logWarningMissingField(key, fieldName, targetClass);
                        }
                    }
                    break;
                    case END_OBJECT: {
                        return result;
                    }
                    default: {
                        if (childField == null) {
                            // @todo Should skip instead.
                            continue;
                        }
                        Object valueFromJSON = defaultValueForField(childField);
                        switch (event) {
                            case VALUE_STRING: {
                                valueFromJSON = parser.getString();
                            }
                            break;
                            case VALUE_NUMBER: {
                                valueFromJSON = jsonNumberToJavaNumber(parser);
                            }
                            break;
                            case VALUE_TRUE: {
                                valueFromJSON = Boolean.TRUE;
                            }
                            break;
                            case VALUE_FALSE: {
                                valueFromJSON = Boolean.FALSE;
                            }
                            break;
                            case START_OBJECT:
                            case START_ARRAY: {
                                final boolean isMap = childField.getAnnotation(MapValue.class) != null;
                                final Class[] childFieldClasses = findClassesForField(childField);
                                switch (event) {
                                    case START_ARRAY: {
                                        valueFromJSON = marshallArray(parser, childField, childFieldClasses[0]);
                                    }
                                    break;
                                    case START_OBJECT:
                                    default: {
                                        if (isMap) {
                                            valueFromJSON = marshallMap(parser, childField, childFieldClasses[0], childFieldClasses[1]);
                                        } else {
                                            final boolean isRuntimeType = (childField.getAnnotation(RuntimeType.class) != null);
                                            // For some special objects (ie: v2/traits, v2/items, v2/skins), the real type depends of the response content.
                                            if (isRuntimeType) {
                                                valueFromJSON = marshallRuntimeObject(parser, childField, childFieldClasses[0], result);
                                            } else {
                                                valueFromJSON = marshallObject(parser, childField, childFieldClasses[0]);
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                            case VALUE_NULL: {
                                valueFromJSON = null;
                                break;
                            }
                            default: {
                            }
                        }
                        final Object value = valueForField(childField, valueFromJSON);
                        final boolean wasAcessible = childField.isAccessible();
                        childField.setAccessible(true);
                        childField.set(result, value);
                        childField.setAccessible(wasAcessible);
                        childField = null;
                    }
                }
            }
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException | NullPointerException | MalformedURLException | NoSuchMethodException | InvocationTargetException ex) {
            logger.log(Level.SEVERE, null, ex);
            final IOException exception = new IOException(ex);
            throw exception;
        }
        return result;
    }

    /**
     * Marshall the content of the parser into a map.
     * @param <T> Class for the map's keys.
     * @param <V> Class for the map's values.
     * @param parser The parser.
     * @param field The selected field.
     * @param keyClass Class for the map's keys.
     * @param valueClass Class for the map's values.
     * @return A non-modifiable {@code Map<T, V>} instance, never {@code null}.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException 
     */
    private <T, V> Map<T, V> marshallMap(final JsonParser parser, final Field field, final Class<T> keyClass, final Class<V> valueClass) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        final Map result = new HashMap();
        Object keyFromJSON = null;
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            Object valueFromJSON = null;
            switch (event) {
                case KEY_NAME: {
                    final String key = parser.getString();
                    keyFromJSON = marshallEnumValue(field, key);
                }
                continue;
                case END_OBJECT: {
                    return Collections.unmodifiableMap(result);
                }
                case START_ARRAY: {
                    valueFromJSON = marshallArray(parser, field, valueClass);
                    // 2016-03-21 FB: hack to return proper type when dealing with Map<Enum, Set>.                    
                    final boolean isSet = field.getAnnotation(SetValue.class) != null;
                    if (isSet) {
                        valueFromJSON = new HashSet((List) valueFromJSON);                        
                    }
                }
                break;
                case VALUE_STRING: {
                    valueFromJSON = parser.getString();
                }
                break;
                case VALUE_NUMBER: {
                    valueFromJSON = jsonNumberToJavaNumber(parser);
                }
                break;
                case VALUE_TRUE: {
                    valueFromJSON = Boolean.TRUE;
                }
                break;
                case VALUE_FALSE: {
                    valueFromJSON = Boolean.FALSE;
                }
                break;
                case START_OBJECT: {
                    valueFromJSON = marshallObject(parser, field, valueClass);
                }
                break;
                case VALUE_NULL: {
                    valueFromJSON = null;
                    break;
                }
                default: {
                }
            }
            result.put(keyFromJSON, valueFromJSON);
        }
        errorEndOfJsonReached(parser);
        return null;
    }

    /**
     * Marshall a JSON array into a list.
     * @param <T> The type of the list's values.
     * @param parser The Json parser.
     * @param field The target fiedl.
     * @param targetClass The type of the list's values.
     * @return A non-modifiable {@code List<T>} instance, never {@code null}.
     * @throws IOException 
     */
    private <T> List<T> marshallArray(final JsonParser parser, final Field field, final Class<T> targetClass) throws IOException {
        // @todo We need to take care of those map values in most recent endpoints.
        final List result = new LinkedList();
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            Object valueFromJSON = null;
            switch (event) {
                case END_ARRAY: {
                    return Collections.unmodifiableList(result);
                }
                case START_ARRAY: {
                    // @todo Find interface class.
                    // Array-ception?
                    valueFromJSON = marshallArray(parser, field, null);
                }
                break;
                case VALUE_STRING: {
                    valueFromJSON = parser.getString();
                }
                break;
                case VALUE_NUMBER: {
                    valueFromJSON = jsonNumberToJavaNumber(parser);
                }
                break;
                case VALUE_TRUE: {
                    valueFromJSON = Boolean.TRUE;
                }
                break;
                case VALUE_FALSE: {
                    valueFromJSON = Boolean.FALSE;
                }
                break;
                case START_OBJECT: {
                    valueFromJSON = marshallObject(parser, field, targetClass);
                }
                break;
                case VALUE_NULL: {
                    valueFromJSON = null;
                    break;
                }
                default: {
                }
            }
            result.add(valueFromJSON);
        }
        errorEndOfJsonReached(parser);
        return null;
    }

    /**
     * Marshal a runtime object.
     * <br>This method converts the content of the parser back to a JSON formatter string and calls the DOM marshaller on it.
     * @param <T> The result type.
     * @param parser The parser.
     * @param field The target field.
     * @param targetClass The target class.
     * @return A {@code T} instance, may be {@code null}.
     * @throws IOException
     */
    private <T> T marshallRuntimeObject(final JsonParser parser, final Field field, Class<T> targetClass, final Object parent) throws IOException {
        Objects.requireNonNull(parser);
        Objects.requireNonNull(field);
        final RuntimeType runtimeTypeAnnotation = field.getAnnotation(RuntimeType.class);
        final String selector = runtimeTypeAnnotation.selector();
        final String pattern = runtimeTypeAnnotation.pattern();
        Objects.requireNonNull(selector);
        Objects.requireNonNull(pattern);
        final String packageName = targetClass.getPackage().getName();
        final String fullPattern = packageName + "." + pattern; // NOI18N.
        final RuntimeType.Source source = runtimeTypeAnnotation.source();
        if (source == RuntimeType.Source.PARENT) {
            Objects.requireNonNull(parent);
            try {
                final Field parentField = lookupField(selector, parent.getClass());
                parentField.setAccessible(true);
                final Object selectorValue = parentField.get(parent);
                final String selectorName = JsonpUtils.INSTANCE.javaEnumToJavaClassName((Enum) selectorValue);
                final String className = String.format(fullPattern, selectorName);
                final Class<T> newTargetClass = (Class<T>) Class.forName(className);
                return marshallObject(parser, field, newTargetClass);
            } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
                final IOException exception = new IOException(ex);
                throw exception;

            }
        } else {
            final String json = backToJson(parser, Starter.OBJECT);
            final JsonpDOMMarshaller delegated = new JsonpDOMMarshaller();
            try (final InputStream input = new ByteArrayInputStream(json.getBytes("UTF-8"))) { // NOI18N.
                final T result = delegated.loadRuntimeObject(selector, fullPattern, input);
                return result;
            }
        }
    }

    /**
     * When skipping or converting back to JSON the content of the parser, we need a description of the starter entity.
     * @author Fabrice Bouyé
     */
    private static enum Starter {
        /**
         * The starter entity is a JSON object.
         */
        OBJECT,
        /**
         * The starter entity is a JSON array.
         */
        ARRAY;
    }

    /**
     * Export the content of the parser back to a JSON formatter string.
     * @param parser The parser.
     * @param starter The starter entity.
     * @return A {@code String} instance, never {@code null}.
     * @throws IOException
     */
    private String backToJson(final JsonParser parser, final Starter starter) throws IOException {
        final StringBuilder buffer = new StringBuilder(starter == Starter.OBJECT ? "{" : "["); // NOI18N.
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            switch (event) {
                case KEY_NAME: {
                    final String key = parser.getString();
                    buffer.append('"'); // NOI18N.
                    buffer.append(key);
                    buffer.append('"'); // NOI18N.
                    buffer.append(':'); // NOI18N.
                }
                continue;
                case START_ARRAY: {
                    final String value = backToJson(parser, Starter.ARRAY);
                    buffer.append(value);
                }
                break;
                case START_OBJECT: {
                    final String value = backToJson(parser, Starter.OBJECT);
                    buffer.append(value);
                }
                break;
                case END_ARRAY: {
                    if (buffer.lastIndexOf(",") == buffer.length() - 1) { // NOI18N.
                        buffer.replace(buffer.length() - 1, buffer.length(), ""); // NOI18N.
                    }
                    buffer.append(']'); // NOI18N.
                    if (starter == Starter.ARRAY) {
                        return buffer.toString();
                    }
                }
                break;
                case END_OBJECT: {
                    if (buffer.lastIndexOf(",") == buffer.length() - 1) { // NOI18N.
                        buffer.replace(buffer.length() - 1, buffer.length(), ""); // NOI18N.
                    }
                    buffer.append('}'); // NOI18N.
                    if (starter == Starter.OBJECT) {
                        return buffer.toString();
                    }
                }
                break;
                case VALUE_TRUE: {
                    buffer.append(true);
                }
                break;
                case VALUE_FALSE: {
                    buffer.append(false);
                }
                break;
                case VALUE_NUMBER: {
                    final Number value = jsonNumberToJavaNumber(parser);
                    buffer.append(value);
                }
                break;
                case VALUE_STRING: {
                    final String value = parser.getString();
                    buffer.append('"'); // NOI18N.
                    buffer.append(value);
                    buffer.append('"'); // NOI18N.
                }
                break;
                case VALUE_NULL:
                default: {
                    buffer.append("null"); // NOI18N.
                }
            }
            // Append value separator.
            buffer.append(','); // NOI18N.
        }
        errorEndOfJsonReached(parser);
        return null;
    }

    /**
     * Converts the number value within the JSON parser to either {@code Integer} or {@code Double}
     * @param parser The JSON parser.
     * @return A {@code Number}, never {@code null}.
     */
    private Number jsonNumberToJavaNumber(final JsonParser parser) {
//        LOGGER.log(Level.FINEST, "{0} {1}", new Object[]{parser.isIntegralNumber(), parser.getString()}); // NOI18N.
//        return (parser.isIntegralNumber()) ? parser.getInt() : parser.getBigDecimal().doubleValue();
//        return (parser.isIntegralNumber()) ? (Integer)parser.getInt() : parser.getBigDecimal().doubleValue();
// As of JDK 8_66, binary promotion returns a Double instead of an Integer if the test is true.
        Number result = null;
        if (parser.isIntegralNumber()) {
            result = parser.getInt();
        } else {
            result = parser.getBigDecimal().doubleValue();
        }
        return result;
    }

    /**
     * Raises an IOException when reaching the end of the parser.
     * @param parser The parser instance.
     * @throws IOException Always.
     */
    private void errorEndOfJsonReached(final JsonParser parser) throws IOException {
        final JsonLocation jsonLocation = parser.getLocation();
        final String message = String.format("Unexpected end of JSON content at line %d, column %d.", jsonLocation.getLineNumber(), jsonLocation.getColumnNumber());
        throw new IOException(message);
    }
}
