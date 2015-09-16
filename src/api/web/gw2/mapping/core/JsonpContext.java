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
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.Set;
import javax.json.Json;
import javax.json.stream.JsonParser;

/**
 *
 * @author Fabrice
 */
public enum JsonpContext {

    INSTANCE;

    public <T> T loadObject(final Class<T> targetClass, final URL url) throws IOException {
        try (final InputStream input = url.openStream()) {
            return JsonpContext.this.loadObject(targetClass, input);
        }
    }

    public <T> PageResult<T> loadPage(final Class<T> targetClass, final URL url) throws IOException {
        final URLConnection connection = url.openConnection();
        connection.connect();
        final int pageSize = Integer.parseInt(connection.getHeaderField("X-Page-Size")); // NOI18N.
        final int pageTotal = Integer.parseInt(connection.getHeaderField("X-Page-Total")); // NOI18N.
        final int resultCount = Integer.parseInt(connection.getHeaderField("X-Result-Count")); // NOI18N.
        final int resultTotal = Integer.parseInt(connection.getHeaderField("X-Result-Total")); // NOI18N.
        try (final InputStream input = connection.getInputStream()) {
            final Collection<T> collection = loadObjectArray(targetClass, input);
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
                        System.out.println("KEY_NAME");
                        String key = parser.getString();
                        final String fieldName = keyToFieldName(key);
                        field = concreteClass.getDeclaredField(fieldName);
                        System.out.println(field.getName() + " - " + field.getType() + " - " + field.getGenericType());
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
                        Object value = null;
                        switch (event) {
                            case VALUE_STRING: {
                                value = parser.getString();
                            }
                            break;
                            case VALUE_NUMBER: {
                                value = (parser.isIntegralNumber()) ? (Number) parser.getInt() : (Number) parser.getBigDecimal().doubleValue();
                            }
                            break;
                            case VALUE_TRUE: {
                                value = Boolean.TRUE;
                            }
                            break;
                            case VALUE_FALSE: {
                                value = Boolean.FALSE;
                            }
                            break;
                            case VALUE_NULL: {
                                value = defaultValueForField(field);
                            }
                            break;
                            case START_OBJECT: {
                                // @todo Find interface class.
                                // @todo Check this.
                                final Type fieldType = field.getType();
                                Class aClass = Class.forName(fieldType.getTypeName());
                                value = marshallObject(parser, aClass);
                            }
                            break;
                            case START_ARRAY: {
                                // @todo Find interface class.
                                final List list = marshallArray(parser, null);
                                final boolean isList = field.isAnnotationPresent(ListValue.class);
                                final boolean isSet = field.isAnnotationPresent(SetValue.class);
                                if (isList) {
                                    value = Collections.unmodifiableList(list);
                                } else if (isSet) {
                                    value = Collections.unmodifiableSet(new HashSet(list));
                                }
                            }
                            break;
                        }
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
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException ex) {
            final IOException exception = new IOException(ex);
            throw exception;
        }
        return result;
    }

    private <T> List<T> marshallArray(final JsonParser parser, final Class<T> targetClass) throws IOException {
        final List result = new LinkedList();
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            Object value = null;
            switch (event) {
                case START_ARRAY: {
                    // @todo Find interface class.
                    value = marshallArray(parser, null);
                }
                break;
                case VALUE_STRING: {
                    value = parser.getString();
                }
                break;
                case VALUE_NUMBER: {
                    value = (parser.isIntegralNumber()) ? (Number) parser.getInt() : (Number) parser.getBigDecimal().doubleValue();
                }
                break;
                case VALUE_TRUE: {
                    value = Boolean.TRUE;
                }
                break;
                case VALUE_FALSE: {
                    value = Boolean.FALSE;
                }
                break;
                case VALUE_NULL: {
                    value = null;
                }
                break;
                case START_OBJECT: {
                    value = marshallObject(parser, targetClass);
                }
                break;
                case END_ARRAY: {
                    return result;
                }
            }
            result.add(value);
        }
        return null;
    }

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

    private String keyToFieldName(final String key) {
        // @todo need to escape id into field name.
        return key;
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
        boolean isQuantity = field.getAnnotation(QuantityValue.class) != null;
//        boolean isDate = field.getAnnotation(DateValue.class) != null;
        boolean isDuration = field.getAnnotation(DurationValue.class) != null;
        boolean isURL = field.getAnnotation(URLValue.class) != null;
        boolean isPercent = field.getAnnotation(PercentValue.class) != null;
        boolean isList = field.getAnnotation(ListValue.class) != null;
        boolean isSet = field.getAnnotation(SetValue.class) != null;
        //
        Object result = null;
        // Use the annotation of the field.
        if (isOptional) {
            result = Optional.empty();
        } else if (isLevel) {
            result = 0;
//            result = LevelAmount.MIN;
        } else if (isCurrency) {
            result = CoinAmount.ZERO;
//        } else if (isDistance) {
//            result = QuantityAmount.ZERO;
        } else if (isQuantity) {
            result = 0;
//            result = DistanceAmount.ZERO;
//        } else if (isDate) {
//            result = LocalDateTime.MIN;
        } else if (isDuration) {
            result = Duration.ZERO;
        } // Now use the class of the field.
        else if (fieldType == String.class) {
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
        } else if (fieldType == Set.class) {
            result = Collections.EMPTY_SET;
        } else if (fieldType == List.class) {
            result = Collections.EMPTY_LIST;
        }
        return result;
    }
}
