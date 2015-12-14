/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import javax.json.Json;
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
     * @param <T> The type to use.
     * @param parser The parser instance.
     * @param targetClass The target class.
     * @return A {@code T} instance, may be {@code null}.
     * @throws IOException In case of IO errors.
     */
    private <T> T marshallObject(final JsonParser parser, final Field field, final Class<T> targetClass) throws IOException {
        final boolean isRuntimeType = (field != null) && (field.getAnnotation(RuntimeType.class) != null);
        // For some special objects (ie: v2/traits, v2/items), the real type depends of the response content.
        if (isRuntimeType) {
            try {
                final T result = marshallRuntimeObject(parser, field, targetClass);
                return result;
            } catch (ClassNotFoundException ex) {
                logger.log(Level.SEVERE, null, ex);
                final IOException exception = new IOException(ex);
                throw exception;
            }
        }
        // Regular objects, use simple injection.
        // Initialize concrete empty instance.
        final T result = createConcreteEmptyInstance(targetClass);
        if (result == null) {
            // @todo Throw exception.
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
                        final String fieldName = jsonKeyToJavaFieldName(key);
                        try {
                            childField = concreteClass.getDeclaredField(fieldName);
                        } catch (NoSuchFieldException nsfe) {
                            final String message = String.format("No matching field \"%s\" found for JSON key \"%s\" in class %s.", fieldName, key, targetClass.getName());
                            logger.warning(message);
                        }
                    }
                    break;
                    case VALUE_STRING:
                    case VALUE_NUMBER:
                    case VALUE_TRUE:
                    case VALUE_FALSE:
                    case VALUE_NULL:
                    case START_OBJECT:
                    case START_ARRAY: {
                        if (childField == null) {
                            continue;
                        }
                        Object valueFromJSON = null;
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
                            case VALUE_NULL: {
                                valueFromJSON = defaultValueForField(childField);
                            }
                            break;
                            case START_OBJECT:
                            case START_ARRAY: {
//                                final Type fieldType = field.getType();
//                                Class aClass = Class.forName(fieldType.getTypeName());
                                // @todo Find interface class.
                                // @todo Check this.
                                String typename = childField.getGenericType().getTypeName();
                                final boolean isOptional = childField.getAnnotation(OptionalValue.class) != null;
                                final boolean isSet = childField.getAnnotation(SetValue.class) != null;
                                final boolean isList = childField.getAnnotation(ListValue.class) != null;
                                final boolean isMap = childField.getAnnotation(MapValue.class) != null;
                                if (isOptional) {
                                    typename = typename.replaceAll("java\\.util\\.Optional<", ""); // NOI18N.
                                }
                                if (isSet) {
                                    typename = typename.replaceAll("java\\.util\\.Set<", ""); // NOI18N.
                                }
                                if (isList) {
                                    typename = typename.replaceAll("java\\.util\\.List<", ""); // NOI18N.
                                }
                                if (isMap) {
                                    typename = typename.replaceAll("java\\.util\\.Map<", ""); // NOI18N.
                                }
                                // Remove trailing >.
                                typename = typename.replaceAll(">+", ""); // NOI18N.
                                final String[] subTargetClassNames = typename.split(",\\s*");
                                final Class[] subTargetClasses = new Class[subTargetClassNames.length];
                                for (int index = 0; index < subTargetClassNames.length; index++) {
                                    subTargetClasses[index] = Class.forName(subTargetClassNames[index]);
                                }
                                switch (event) {
                                    case START_ARRAY: {
                                        valueFromJSON = marshallArray(parser, childField, subTargetClasses[0]);
                                    }
                                    break;
                                    case START_OBJECT:
                                    default: {
                                        if (isMap) {
                                            valueFromJSON = marshallMap(parser, childField, subTargetClasses[0], subTargetClasses[1]);
                                        } else {
                                            valueFromJSON = marshallObject(parser, childField, subTargetClasses[0]);
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        final Object value = valueForField(childField, valueFromJSON);
                        final boolean wasAcessible = childField.isAccessible();
                        childField.setAccessible(true);
                        childField.set(result, value);
                        childField.setAccessible(wasAcessible);
                        childField = null;
                    }
                    break;
                    case END_OBJECT: {
                        return result;
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
                case START_ARRAY: {
                    valueFromJSON = marshallArray(parser, field, valueClass);
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
                case VALUE_NULL: {
                    valueFromJSON = null;
                }
                break;
                case START_OBJECT: {
                    valueFromJSON = marshallObject(parser, field, valueClass);
                }
                break;
                case END_OBJECT: {
                    return result;
                }
            }
            result.put(keyFromJSON, valueFromJSON);
        }
        return null;
    }

    private <T> List<T> marshallArray(final JsonParser parser, final Field field, final Class<T> targetClass) throws IOException {
        // @todo We need to take care of those map values in most recent endpoints.
        final List result = new LinkedList();
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            Object valueFromJSON = null;
            switch (event) {
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
                case VALUE_NULL: {
                    valueFromJSON = null;
                }
                break;
                case START_OBJECT: {
                    valueFromJSON = marshallObject(parser, field, targetClass);
                }
                break;
                case END_ARRAY: {
                    return result;
                }
            }
            result.add(valueFromJSON);
        }
        return null;
    }

    private <T> T marshallRuntimeObject(final JsonParser parser, final Field field, Class<T> targetClass) throws IOException, ClassNotFoundException {
        Objects.requireNonNull(parser);
        Objects.requireNonNull(field);
        final RuntimeType runtimeTypeAnnotation = field.getAnnotation(RuntimeType.class);
        final Map<String, Object> buffer = new HashMap<>();
        String key = null;
        while (parser.hasNext()) {
            Object valueFromJSON = null;
            final JsonParser.Event event = parser.next();
            switch (event) {
                case END_OBJECT: {
                    final String selector = runtimeTypeAnnotation.selector();
                    final String pattern = runtimeTypeAnnotation.pattern();
                    final String type = (String) buffer.get(selector);
                    final String shortClassName = String.format(pattern, type);
                    final String fullClassName = targetClass.getPackage().getName() + "." + shortClassName;
                    final Class<T> newTargetClass = (Class<T>) Class.forName(fullClassName);
                    final T result = createConcreteEmptyInstance(newTargetClass);
                    // Load object from buffer.
                    return result;
                }
                case KEY_NAME: {
                    key = parser.getString();
                    buffer.put(key, null);
                }
                continue;
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
                case VALUE_NULL: {
                    valueFromJSON = null;
                }
                break;
            }
            buffer.put(key, valueFromJSON);
        }
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
}
