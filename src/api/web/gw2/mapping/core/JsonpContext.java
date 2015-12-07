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
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.stream.JsonParser;

/**
 *
 * @author Fabrice
 */
public enum JsonpContext {

    INSTANCE;

    /**
     * Loads a page from given URL
     * @param <T> The type to use.
     * @param targetClass The target class.
     * @param url The url to query.
     * @return A {@code T} instance, may be {@code null}.
     * @throws NullPointerException If either {@code targetClass} or {@code url} is {@code null}.
     * @throws IOException In case of IO errors.
     */
    public <T> T loadObject(final Class<T> targetClass, final URL url) throws NullPointerException, IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(url);
        try (final InputStream input = url.openStream()) {
            return JsonpContext.this.loadObject(targetClass, input);
        }
    }

    /**
     * Loads a page from given paginated URL
     * @param <T> The type to use.
     * @param targetClass The target class.
     * @param url The url to query.
     * @return A {@code PageResult<T>} instance, never {@code null}.
     * @throws NullPointerException If either {@code targetClass} or {@code url} is {@code null}.
     * @throws IOException In case of IO errors.
     */
    public <T> PageResult<T> loadPage(final Class<T> targetClass, final URL url) throws NullPointerException, IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(url);
        final URLConnection connection = url.openConnection();
        connection.connect();
        // Exception handling here allows to load local JSON files as remote URLs.
        int pageSize = -1;
        try {
            pageSize = Integer.parseInt(connection.getHeaderField("X-Page-Size")); // NOI18N.
        } catch (NumberFormatException nfe) {
            // @todo Log.
        }
        int pageTotal = 1;
        try {
            pageTotal = Integer.parseInt(connection.getHeaderField("X-Page-Total")); // NOI18N.
        } catch (NumberFormatException nfe) {
            // @todo Log.
        }
        int resultCount = 0;
        try {
            resultCount = Integer.parseInt(connection.getHeaderField("X-Result-Count")); // NOI18N.
        } catch (NumberFormatException nfe) {
            // @todo Log.
        }
        int resultTotal = -1;
        try {
            resultTotal = Integer.parseInt(connection.getHeaderField("X-Result-Total")); // NOI18N.
        } catch (NumberFormatException nfe) {
            // @todo Log.
        }
        // Finally try to load page content.
        try (final InputStream input = connection.getInputStream()) {
            final Collection<T> collection = loadObjectArray(targetClass, input);
            // If local JSON file, need to hack those values.
            pageSize = (pageSize == -1) ? collection.size() : pageSize;
            resultTotal = (resultTotal == -1) ? collection.size() : resultTotal;
            final PageResult<T> result = new PageResult<>(collection, pageSize, pageTotal, resultTotal);
            return result;
        }
    }

    private <T> Collection<T> loadObjectArray(final Class<T> targetClass, final InputStream input) throws IOException {
        // Parse JSON using event parser.
        try (final JsonParser parser = Json.createParser(input)) {
            while (parser.hasNext()) {
                final JsonParser.Event event = parser.next();
                switch (event) {
                    // Start array marshalling.
                    case START_ARRAY: {
                        final Collection<T> result = marshallArray(parser, targetClass);
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

    private <T> T loadObject(final Class<T> targetClass, final InputStream input) throws IOException {
        // Parse JSON using event parser.
        try (final JsonParser parser = Json.createParser(input)) {
            while (parser.hasNext()) {
                final JsonParser.Event event = parser.next();
                switch (event) {
                    // Start object marshalling.
                    case START_OBJECT: {
                        final T result = marshallObject(parser, targetClass);
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

    /**
     * Marshall an object of the desired type from the parser's current location.
     * @param <T> The type to use.
     * @param parser The parser instance.
     * @param targetClass The target class.
     * @return A {@code T} instance, may be {@code null}.
     * @throws IOException In case of IO errors.
     */
    private <T> T marshallObject(final JsonParser parser, final Class<T> targetClass) throws IOException {
        // Initialize concrete empty instance.
        final T result = createConcreteEmptyInstance(targetClass);
        if (result == null) {
            // @todo Throw exception.
            return null;
        }
        // Get concrete class for concrete instance.
        final Class concreteClass = result.getClass();
        try {
            Field field = null;
            while (parser.hasNext()) {
                final JsonParser.Event event = parser.next();
                switch (event) {
                    case KEY_NAME: {
                        String key = parser.getString();
                        final String fieldName = jsonKeyToJavaFieldName(key);
                        try {
                            field = concreteClass.getDeclaredField(fieldName);
                        } catch (NoSuchFieldException nsfe) {
                            final String message = String.format("No matching field \"%s\" found for JSON key \"%s\" in class %s.", fieldName, key, targetClass.getName());
                            Logger.getLogger(getClass().getName()).warning(message);
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
                        if (field == null) {
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
                                valueFromJSON = defaultValueForField(field);
                            }
                            break;
                            case START_OBJECT: {
                                // @todo Find interface class.
                                // @todo Check this.
                                final Type fieldType = field.getType();
                                Class aClass = Class.forName(fieldType.getTypeName());
                                valueFromJSON = marshallObject(parser, aClass);
                            }
                            break;
                            case START_ARRAY: {
                                // @todo Find interface class.
                                valueFromJSON = marshallArray(parser, null);
                            }
                            break;
                        }
                        final Object value = valueForField(field, valueFromJSON);
                        final boolean wasAcessible = field.isAccessible();
                        field.setAccessible(true);
                        field.set(result, value);
                        field.setAccessible(wasAcessible);
                        field = null;
                    }
                    break;
                    case END_OBJECT: {
                        return result;
                    }
                }
            }
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException | NullPointerException | MalformedURLException | NoSuchMethodException | InvocationTargetException ex) {
            Logger.getLogger(JsonpContext.class.getName()).log(Level.SEVERE, null, ex);
            final IOException exception = new IOException(ex);
            throw exception;
        }
        return result;
    }

    private <T> List<T> marshallArray(final JsonParser parser, final Class<T> targetClass) throws IOException {
        // @todo We need to take care of those map values in most recent endpoints.
        final List result = new LinkedList();
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            Object valueFromJSON = null;
            switch (event) {
                case START_ARRAY: {
                    // @todo Find interface class.
                    valueFromJSON = marshallArray(parser, null);
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
                    valueFromJSON = marshallObject(parser, targetClass);
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

    /**
     * Creates a concrete instance of the desired interface using the {@code ServiceManager}.
     * @param <T> The target type.
     * @param targetClass The target class.
     * @return A {@code T} instance, may be {@code null}.
     */
    private <T> T createConcreteEmptyInstance(final Class<T> targetClass) {
        // Get service loader for target class.
        final ServiceLoader serviceLoader = ServiceLoader.load(targetClass);
        // Get concrete instance for target class.
        final Iterator<T> iterator = serviceLoader.iterator();
        T result = null;
        while (iterator.hasNext()) {
            if (result == null) {
                result = (T) iterator.next();
            }
        }
        return result;
    }

    /**
     * Converts the number value within the JSON parser to either {@code Integer} or {@code Double}
     * @param parser The JSON parser.
     * @return A {@code Number}, never {@code null}.
     */
    private Number jsonNumberToJavaNumber(final JsonParser parser) {
        Logger.getGlobal().log(Level.FINEST, "{0} {1}", new Object[]{parser.isIntegralNumber(), parser.getString()}); // NOI18N.
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
     * Converts a JSON key into a Java field name.
     * @param key The JSON key.
     * @return A {@code String}, never {@code null}.
     * @throws NullPointerException If {@code key} is {@code null}.
     */
    private String jsonKeyToJavaFieldName(final String key) throws NullPointerException {
        Objects.requireNonNull(key);
        final String[] tokens = key.split("_"); // NOI18N.
        final StringBuilder buffer = new StringBuilder(key.length());
        buffer.append(tokens[0]);
        Arrays.stream(tokens, 1, tokens.length)
                .forEach(token -> {
                    String head = token.substring(0, 1).toUpperCase();
                    String tail = token.substring(1, token.length());
                    buffer.append(head);
                    buffer.append(tail);
                });
        return buffer.toString();
    }

    /**
     * Convert a value obtained from JSON to value that can suit the target field.
     * <br/>This method is called before setting a value into a field.
     * @param field The target field.
     * @param value The value obtained from JSON.
     * @return An {@code Object}, may be [@code null}.
     * <br/>The value to return will be determined from the annotations and the class of the target field.
     * @throws NullPointerException If {@code field} is {@code null}.
     * @throws MalformedURLException If URL cannot be parsed from input object.
     */
    private Object valueForField(final Field field, final Object value) throws NullPointerException, MalformedURLException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Objects.requireNonNull(field);
        // @todo Not all types used yet.
        boolean isOptional = field.getAnnotation(OptionalValue.class) != null;
        boolean isId = field.getAnnotation(IdValue.class) != null;
        boolean isLevel = field.getAnnotation(LevelValue.class) != null;
        boolean isCurrency = field.getAnnotation(CoinValue.class) != null;
//        boolean isDistance = field.getAnnotation(DistanceValue.class) != null;
        boolean isLocalizedResource = field.getAnnotation(LocalizedResource.class) != null;
        boolean isQuantity = field.getAnnotation(QuantityValue.class) != null;
        boolean isDate = field.getAnnotation(DateValue.class) != null;
        boolean isDuration = field.getAnnotation(DurationValue.class) != null;
        boolean isURL = field.getAnnotation(URLValue.class) != null;
        boolean isPercent = field.getAnnotation(PercentValue.class) != null;
        boolean isList = field.getAnnotation(ListValue.class) != null;
        boolean isSet = field.getAnnotation(SetValue.class) != null;
        boolean isMap = field.getAnnotation(MapValue.class) != null;
        boolean isEnum = field.getAnnotation(EnumValue.class) != null;
        Object result = value;
        // Base types.
        if (isURL) {
            result = new URL((String) value);
        } else if (isDate) {
            result = ZonedDateTime.parse((String) value);
        } else if (isList) {
            result = Collections.unmodifiableList((List) value);
        } else if (isSet) {
            result = Collections.unmodifiableSet(new HashSet((List) value));
        } else if (isMap) {
            result = Collections.unmodifiableMap((Map) value);
        } else if (isLocalizedResource) {
            result = (String)value;
        }
        // As we rely heavily on enums, we need to convert base types obtained from JSON into valid enum values.
        if (isEnum) {
            // Do a second pass on the collection to marshall its content into enum values.
            if (isSet || isList) {
                final Collection<?> source = (Collection) result;
                final List destination = new ArrayList(source.size());
                // Cannot use stream because of exceptions raised in marshallEnumValue().
                for (final Object v : source) {
                    final Object target = marshallEnumValue(field, v);
                    destination.add(target);
                }
                result = (isList) ? Collections.unmodifiableList(destination) : Collections.unmodifiableSet(new HashSet(destination));
            } // @todo What about maps?
            // Single value.
            else {
                result = marshallEnumValue(field, value);
            }
        }
        // Wrap the result into an Optional instance.
        if (isOptional) {
            if (isId || isQuantity || isLevel || isCurrency) {
                result = OptionalInt.of((Integer) result);
            } else if (isPercent) {
                result = OptionalDouble.of((Double) result);
            } else {
                result = Optional.ofNullable(result);
            }
        }
        Logger.getGlobal().log(Level.INFO, "{0} declaring class: {1}", new Object[]{field.getName(), field.getDeclaringClass()});
        Logger.getGlobal().log(Level.INFO, "{0} type: {1}", new Object[]{field.getName(), field.getType()});
        Logger.getGlobal().log(Level.INFO, "{0} annotated type: {1}", new Object[]{field.getName(), field.getAnnotatedType()});
        Logger.getGlobal().log(Level.INFO, "{0} value returned as: {1} ({2})", new Object[]{field.getName(), result, result.getClass()});
        return result;
    }

    /**
     * Marshall a single value obtained from the JSON to a value from an enum class.
     * @param field The target field.
     * @param value The value marshaled from the JSON.
     * @return An instance of an enum class, never {@code null}.
     * @throws ClassNotFoundException The target factory class cannot be resolved.
     * @throws NoSuchMethodException The target factory method cannot be resolved.
     * @throws IllegalAccessException The factory method cannot be accessed.
     * @throws IllegalArgumentException The argument provided to the factory method is invalid.
     * @throws InvocationTargetException If the factory method threw an exception.
     */
    private Object marshallEnumValue(final Field field, final Object value) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        final EnumValue annotation = (EnumValue) field.getAnnotation(EnumValue.class);
        final String factory = annotation.factory();
        Class factoryClass = field.getType();
        String factoryMethodName = "valueOf"; // NOI18N.
        if (factory != null && !factory.trim().isEmpty()) {
            final int index = factory.indexOf(EnumValue.METHOD_SEPARATOR);
            final String factoryClassName = factory.substring(0, index);
            factoryClass = Class.forName(factoryClassName);
            factoryMethodName = factory.substring(index + EnumValue.METHOD_SEPARATOR.length(), factory.length());
        }
        final Method factoryMethod = factoryClass.getMethod(factoryMethodName, value.getClass());
        final Object result = factoryMethod.invoke(null, value);
        return result;
    }

    /**
     * Gets the default value for given field.
     * <br/>This method is usually called when encountering a {@code null} value.
     * @param field The field on which the value will be set.
     * @return An {@code Object} instance, may be {@code null}.
     * <br/>The value to return will be determined from the annotations and the class of the target field.
     * @throws NullPointerException If {@code field} is {@code null}.
     */
    private Object defaultValueForField(final Field field) throws NullPointerException {
        Objects.requireNonNull(field);
        final Type fieldType = field.getType();
        boolean isOptional = field.getAnnotation(OptionalValue.class) != null;
        boolean isId = field.getAnnotation(IdValue.class) != null;
        boolean isLevel = field.getAnnotation(LevelValue.class) != null;
        boolean isCurrency = field.getAnnotation(CoinValue.class) != null;
//        boolean isDistance = field.getAnnotation(DistanceValue.class) != null;
        boolean isLocalizedResource = field.getAnnotation(LocalizedResource.class) != null;
        boolean isQuantity = field.getAnnotation(QuantityValue.class) != null;
        boolean isDate = field.getAnnotation(DateValue.class) != null;
        boolean isDuration = field.getAnnotation(DurationValue.class) != null;
        boolean isURL = field.getAnnotation(URLValue.class) != null;
        boolean isPercent = field.getAnnotation(PercentValue.class) != null;
        boolean isList = field.getAnnotation(ListValue.class) != null;
        boolean isSet = field.getAnnotation(SetValue.class) != null;
        boolean isMap = field.getAnnotation(MapValue.class) != null;
        //
        Object result = null;
        // Use the annotation of the field.
        if (isOptional) {
            if (isId || isQuantity || isLevel || isCurrency) {
                result = OptionalInt.empty();
            } else if (isPercent) {
                result = OptionalDouble.empty();
            } else {
                result = Optional.empty();
            }
        } else if (isLevel) {
            result = LevelValue.MIN_LEVEL;
        } else if (isCurrency) {
            result = CoinAmount.ZERO;
//        } else if (isDistance) {
//            result = QuantityAmount.ZERO;
        } else if (isQuantity) {
            result = 0;
//            result = DistanceAmount.ZERO;
        } else if (isDate) {
            result = ZonedDateTime.parse("1970-01-01T00:00:00Z"); // NOI18N.
        } else if (isDuration) {
            result = Duration.ZERO;
        } // Now use the class of the field.
        else if (isLocalizedResource || fieldType == String.class) {
            result = ""; // NOI8N.
        } else if (fieldType == Integer.TYPE) {
            result = 0;
        } else if (fieldType == Long.TYPE) {
            result = 0L;
        } else if (fieldType == Float.TYPE) {
            result = 0F;
        } else if (fieldType == Double.TYPE) {
            result = 0D;
        } else if (fieldType == Boolean.TYPE) {
            result = Boolean.FALSE;
        } else if (isSet || fieldType == Set.class) {
            result = Collections.EMPTY_SET;
        } else if (isList || fieldType == List.class) {
            result = Collections.EMPTY_LIST;
        } else if (isMap || fieldType == Map.class) {
            result = Collections.EMPTY_MAP;
        }
        return result;
    }
}
