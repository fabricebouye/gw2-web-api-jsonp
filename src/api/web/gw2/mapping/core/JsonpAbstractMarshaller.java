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
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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

/**
 * Base class for an object marshaller built on top of JSON-P.
 * @author Fabrice Bouyé
 */
abstract class JsonpAbstractMarshaller {

    /**
     * The logger instance.
     */
    protected final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Creates a new empty instance.
     */
    public JsonpAbstractMarshaller() {
    }

    public abstract <T> T loadObject(final Class<T> targetClass, final InputStream input) throws NullPointerException, IOException;

    public abstract <T> Collection<T> loadObjectArray(final Class<T> targetClass, final InputStream input) throws IOException;

    public abstract <T> T loadRuntimeObject(final String selector, final String pattern, final InputStream input) throws IOException;

    /**
     * Creates a concrete instance of the desired interface using the {@code ServiceManager}.
     * @param <T> The target type.
     * @param targetClass The target class.
     * @return A {@code T} instance, may be {@code null}.
     */
    protected final <T> T createConcreteEmptyInstance(final Class<T> targetClass) {
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
     * Tries to locate given field in selected class or it's ancestor classes.
     * @param fieldName The field name.
     * @param targetClass The target class.
     * @return A {@code Field} instance, may be {@code null} if field was not found.
     */
    protected final Field lookupField(final String fieldName, final Class targetClass) {
        Field field = null;
        for (Class aClass = targetClass; aClass != null && field == null; aClass = aClass.getSuperclass()) {
            try {
                field = aClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException ex) {
                logger.log(Level.FINEST, "Could not find field \"{0}\" in class {1}, attenpting to use class hierachy.", new Object[]{fieldName, targetClass});
            }
        }
        return field;
    }

    /**
     * Converts a JSON key into a Java field name.
     * @param key The JSON key.
     * @return A {@code String}, never {@code null}.
     * @throws NullPointerException If {@code key} is {@code null}.
     */
    protected final String jsonKeyToJavaFieldName(final String key) throws NullPointerException {
        Objects.requireNonNull(key);
        final String[] tokens = key.split("_"); // NOI18N.
        final StringBuilder buffer = new StringBuilder(key.length());
        buffer.append(tokens[0]);
        Arrays.stream(tokens, 1, tokens.length)
                .forEach(token -> {
                    final String head = token.substring(0, 1).toUpperCase();
                    final String tail = token.substring(1, token.length());
                    buffer.append(head);
                    buffer.append(tail);
                });
        return buffer.toString();
    }

    protected final String javaEnumToJavaClassName(final Enum value) throws NullPointerException {
        Objects.requireNonNull(value);
        final String name = value.name().toLowerCase();
        final String[] tokens = name.split("_"); // NOI18N.
        final StringBuilder buffer = new StringBuilder(name.length());
        Arrays.stream(tokens)
                .forEach(token -> {
                    String head = token.substring(0, 1).toUpperCase();
                    String tail = token.substring(1, token.length());
                    buffer.append(head);
                    buffer.append(tail);
                });
        return buffer.toString();
    }

    /**
     * Gets the default value for given field.
     * <br/>This method is usually called when encountering a {@code null} value.
     * @param field The field on which the value will be set.
     * @return An {@code Object} instance, may be {@code null}.
     * <br/>The value to return will be determined from the annotations and the class of the target field.
     * @throws NullPointerException If {@code field} is {@code null}.
     */
    protected final Object defaultValueForField(final Field field) throws NullPointerException {
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
            if (isList || isSet || isMap) {
                result = Optional.empty();
            } else if (isQuantity || isLevel || isCurrency) {
                result = OptionalInt.empty();
            } else if (isPercent) {
                result = OptionalDouble.empty();
            } else if (isId) {
                final boolean isIntegerId = field.getAnnotation(IdValue.class).flavor() == IdValue.Flavor.INTEGER;
                result = isIntegerId ? OptionalInt.empty() : Optional.empty();
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
            result = DateValue.DEFAULT;
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
    protected final Object valueForField(final Field field, final Object value) throws NullPointerException, MalformedURLException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
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
        // Provided default values may already be wrapped into Optional instances.
        if (isOptional && !(result instanceof Optional || result instanceof OptionalInt)) {
            if (isList || isSet || isMap) {
                result = Optional.ofNullable(result);
            } else if (isQuantity || isLevel || isCurrency) {
                result = OptionalInt.of((Integer) result);
            } else if (isPercent) {
                result = OptionalDouble.of((Double) result);
            } else if (isId) {
                final boolean isIntegerId = field.getAnnotation(IdValue.class).flavor() == IdValue.Flavor.INTEGER;
                result = isIntegerId ? OptionalInt.of((Integer) result) : Optional.ofNullable(result);
            } else {
                result = Optional.ofNullable(result);
            }
        }
//        LOGGER.log(Level.INFO, "{0} declaring class: {1}", new Object[]{field.getName(), field.getDeclaringClass()});
//        LOGGER.log(Level.INFO, "{0} type: {1}", new Object[]{field.getName(), field.getType()});
//        LOGGER.log(Level.INFO, "{0} annotated type: {1}", new Object[]{field.getName(), field.getAnnotatedType()});
//        LOGGER.log(Level.INFO, "{0} value returned as: {1} ({2})", new Object[]{field.getName(), result, result.getClass()});
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
     * @throws NullPointerException If {@code field} or {@code value} is {@code null}.
     */
    protected final Object marshallEnumValue(final Field field, final Object value) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Objects.requireNonNull(field);
        Objects.requireNonNull(value);
        final EnumValue enumAnnotation = (EnumValue) field.getAnnotation(EnumValue.class);
        final MapValue mapAnnotation = (MapValue) field.getAnnotation(MapValue.class);
        String factory = null;
        if (enumAnnotation != null) {
            factory = enumAnnotation.factory();
        } else if (mapAnnotation != null) {
            factory = mapAnnotation.keyFactory();
        }
        Objects.requireNonNull(factory);
        // For simple field this should be the enum type.
        // The class obtained here is not good when the field holds an optional or a collection.
        Class factoryClass = field.getType();
        String factoryMethodName = "valueOf"; // NOI18N.
        // We use the provided factory method instead of the enum type's valueOf method.
        if (factory != null && !factory.trim().isEmpty()) {
            final int index = factory.indexOf(EnumValue.METHOD_SEPARATOR);
            final String factoryClassName = factory.substring(0, index);
            factoryClass = Class.forName(factoryClassName);
            factoryMethodName = factory.substring(index + EnumValue.METHOD_SEPARATOR.length(), factory.length());
        }
        // Will not work if value is not of the proper type (usually String).
        final Method factoryMethod = factoryClass.getMethod(factoryMethodName, value.getClass());
        final Object result = factoryMethod.invoke(null, value);
        Objects.requireNonNull(result);
        // Issue a warning if the value returned is the unkown value.
        if ("UNKOWN".equals(((Enum) result).name())) { // NOI18N.
            logger.log(Level.WARNING, "Field \"{0}\": unable to marshall enum value \"{1}\", defaulting to value \"{2}\" instead.", new Object[]{field.getName(), value, result}); // NOI18N.
        }
        logger.log(Level.FINEST, "Field \"{0}\": marshalled enum value \"{1}\" into value \"{2}\".", new Object[]{field.getName(), value, result}); // NOI18N.
        return result;
    }

    protected final void logWarningMissingField(final String key, final String fieldName, final Class targetClass) {
        final String message = String.format("No matching field \"%s\" found for JSON key \"%s\" in class %s.", fieldName, key, targetClass.getName()); // NOI18N.
        logger.warning(message);
    }
}
