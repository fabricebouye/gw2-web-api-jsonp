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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 * A DOM (structure in memory) implementation of the JSON-P marshaller.
 * @author Fabrice Bouyé
 */
final class JsonpDOMMarshaller extends JsonpAbstractMarshaller {

    /**
     * Creates a new empty instance.
     */
    public JsonpDOMMarshaller() {
    }

    @Override
    public <T> T loadObject(Class<T> targetClass, InputStream input) throws NullPointerException, IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(input);
        try (final JsonReader jsonReader = Json.createReader(input)) {
            final JsonObject jsonObject = jsonReader.readObject();
            return marshallObject(jsonObject, null, targetClass);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException | MalformedURLException | NoSuchMethodException | InvocationTargetException ex) {
            logger.log(Level.SEVERE, null, ex);
            final IOException exception = new IOException(ex);
            throw exception;
        }
    }

    @Override
    public <T> Collection<T> loadObjectArray(Class<T> targetClass, InputStream input) throws IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(input);
        try (final JsonReader jsonReader = Json.createReader(input)) {
            final JsonArray jsonArray = jsonReader.readArray();
            return marshallArray(jsonArray, null, targetClass);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            final IOException exception = new IOException(ex);
            throw exception;
        }
    }

    @Override
    public <T> T loadRuntimeObject(final String selector, final String pattern, final InputStream input) throws IOException {
        Objects.requireNonNull(selector);
        Objects.requireNonNull(pattern);
        Objects.requireNonNull(input);
        try (final JsonReader jsonReader = Json.createReader(input)) {
            final JsonObject jsonObject = jsonReader.readObject();
            final String type = jsonObject.getString(selector);
            final String targetClassName = String.format(pattern, type);
            final Class<T> targetClass = (Class<T>) Class.forName(targetClassName);
            return marshallObject(jsonObject, null, targetClass);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException | MalformedURLException | NoSuchMethodException | InvocationTargetException ex) {
            logger.log(Level.SEVERE, null, ex);
            final IOException exception = new IOException(ex);
            throw exception;
        }
    }

    private <T> T marshallObject(final JsonObject jsonObject, final Field field, final Class<T> targetClass) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, NullPointerException, MalformedURLException, NoSuchMethodException, InvocationTargetException {
        final T result = createConcreteEmptyInstance(targetClass);
        final Class<T> concreteClass = (Class<T>) result.getClass();
        for (final String key : jsonObject.keySet()) {
            final String childFieldName = jsonKeyToJavaFieldName(key);
            final Field childField = lookupField(childFieldName, concreteClass);
            // If field does not exist, skip key.
            if (childField == null) {
                logWarningMissingField(key, childFieldName, targetClass);
                continue;
            }
            Object valueFromJSON = defaultValueForField(childField);
            final JsonValue jsonValue = jsonObject.get(key);
            final JsonValue.ValueType valueType = jsonValue.getValueType();
            switch (valueType) {
                case TRUE: {
                    valueFromJSON = Boolean.TRUE;
                }
                break;
                case FALSE: {
                    valueFromJSON = Boolean.FALSE;
                }
                break;
                case NUMBER: {
                    final JsonNumber jsonNumber = jsonObject.getJsonNumber(key);
                    valueFromJSON = jsonNumberToJavaNumber(jsonNumber);
                }
                break;
                case STRING: {
                    valueFromJSON = jsonObject.getString(key);
                }
                break;
                case ARRAY:
                case OBJECT: {
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
                    switch (valueType) {
                        case ARRAY: {
                            final JsonArray jsonArray = jsonObject.getJsonArray(key);
                            valueFromJSON = marshallArray(jsonArray, childField, subTargetClasses[0]);
                        }
                        break;
                        case OBJECT:
                        default: {
                            final JsonObject childJsonObject = jsonObject.getJsonObject(key);
                            if (isMap) {
                                valueFromJSON = marshallMap(childJsonObject, childField, subTargetClasses[0], subTargetClasses[1]);
                            } else {
                                valueFromJSON = marshallObject(childJsonObject, childField, subTargetClasses[0]);
                            }
                        }
                    }
                }
                break;
                case NULL:
                default:
            }
            final Object value = valueForField(childField, valueFromJSON);
            childField.setAccessible(true);
            childField.set(result, value);
        }
        return result;
    }

    private <T> List<T> marshallArray(final JsonArray jsonArray, final Field field, final Class<T> targetClass) {
        return null;
    }

    private <T, V> Map<T, V> marshallMap(final JsonObject jsonObject, final Field field, final Class<T> keyClass, final Class<V> valueClass) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, NullPointerException, MalformedURLException {
        final HashMap result = new HashMap();
        for (String key : jsonObject.keySet()) {
            final JsonValue value = jsonObject.get(key);
            final Object keyFromJSON = marshallEnumValue(field, key);
            Object valueFromJSON = null;
            switch (value.getValueType()) {
                case ARRAY: {
                    final JsonArray jsonArray = jsonObject.getJsonArray(key);
                    valueFromJSON = marshallArray(jsonArray, null, valueClass);
                }
                break;
                case OBJECT: {
                    final JsonObject childJsonObject = jsonObject.getJsonObject(key);
                    valueFromJSON = marshallObject(childJsonObject, null, valueClass);
                }
                break;
                case TRUE:
                case FALSE: {
                    valueFromJSON = jsonObject.getBoolean(key);
                }
                break;
                case NUMBER: {
                    final JsonNumber jsonNumber = jsonObject.getJsonNumber(key);
                    valueFromJSON = jsonNumberToJavaNumber(jsonNumber);
                }
                break;
                case STRING: {
                    valueFromJSON = jsonObject.getString(key);
                }
                break;
                case NULL:
                default:
            }
            result.put(keyFromJSON, valueFromJSON);
        }
        return Collections.unmodifiableMap(result);
    }

    /**
     * Converts the number value returned by the JSON to either {@code Integer} or {@code Double}
     * @param jsonNumber The JSON number.
     * @return A {@code Number}, never {@code null}.
     */
    private Number jsonNumberToJavaNumber(final JsonNumber jsonNumber) {
        Number result = null;
        if (jsonNumber.isIntegral()) {
            result = jsonNumber.intValue();
        } else {
            result = jsonNumber.doubleValue();
        }
        return result;
    }
}
