/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;

/**
 * JSR 353 JSON-P utility class.
 * <br>This class provides core utility methods that are used throughout this factory implementation.
 * @author Fabrice Bouyé
 */
public enum JsonpUtils {

    INSTANCE;

    /**
     * Converts a JSON key into a Java field name.
     * @param key The JSON key.
     * @return A {@code String}, never {@code null}.
     * @throws NullPointerException If {@code key} is {@code null}.
     */
    public final String jsonKeyToJavaFieldName(final String key) throws NullPointerException {
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

    /**
     * Convert an enum value to a proper Java class name (by removing '_' and setting the proper letter case). 
     * @param value The source enum value.
     * @return A {@code String} instance, never {@code null}.
     * @throws NullPointerException If {@code value} is {@code null}.
     */
    public final String javaEnumToJavaClassName(final Enum value) throws NullPointerException {
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
     * Converts JSON string into Java strings.
     */
    public static final Function<JsonString, String> STRING_CONVERTER = JsonString::getString;

    /**
     * Converts JSON number into Java integers.
     */
    public static final Function<JsonNumber, Integer> INTEGER_CONVERTER = JsonNumber::intValue;
    /**
     * Converts JSON number into Java longs.
     */
    public static final Function<JsonNumber, Long> LONG_CONVERTER = JsonNumber::longValue;

    /**
     * Converts a list of ids to a parameter string.
     * @param ids The source ids.
     * @return A {@code String} instance, never {@code null}.
     * <br>If no ids are provided, the value {@code "all"} is returned.
     */
    public String idsToParameter(final int... ids) {
        final String result = (ids.length == 0) ? "all" : Arrays.stream(ids) // NOI18N.
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")); // NOI18N.
        return result;
    }

    /**
     * Converts a list of ids to a parameter string.
     * @param ids The source ids.
     * @return A {@code String} instance, never {@code null}.
     * <br>If no ids are provided, the value {@code "all"} is returned.
     */
    public String idsToParameter(final String... ids) {
        final String result = (ids.length == 0) ? "all" : Arrays.stream(ids) // NOI18N.
                .collect(Collectors.joining(",")); // NOI18N.
        return result;
    }

    /**
     * Gets a JSON array from the provided URL.
     * @param basecode The source URL.
     * @return A {@code JSonArray} instance, never {@code null}.
     * @throws NullPointerException If {@code basecode} is {@code null}.    
     * @throws IOException In case of IO error.
     */
    public static JsonArray asJsonArray(final String basecode) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        final URL url = new URL(basecode);
        try (final InputStream input = url.openStream(); final JsonReader reader = Json.createReader(input)) {
            return reader.readArray();
        }
    }

    /**
     * Gets a JSON object from the provided URL.
     * @param basecode The source URL.
     * @return A {@code JsonObject} instance, never {@code null}.
     * @throws NullPointerException If {@code basecode} is {@code null}.    
     * @throws IOException In case of IO error.
     */
    public static JsonObject asJsonObject(final String basecode) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        final URL url = new URL(basecode);
        try (final InputStream input = url.openStream(); final JsonReader reader = Json.createReader(input)) {
            return reader.readObject();
        }
    }

    /**
     * Converts a JSON object into Java object.
     * @param <V> The output type.
     * @param basecode The source URL.
     * @param converter Converts a value of type {@code JsonObject} &rarr; a value of type {@code V}.
     * @return A {@code V} instance, never {@code null}.
     * @throws NullPointerException If either (@code basecode} or (@code converter} is {@code null}.
     * @throws IOException In case of IO error.
     */
    public static <V> V fromJsonObject(final String basecode, final Function<JsonObject, V> converter) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        Objects.requireNonNull(converter);
        final JsonObject jsonObject = asJsonObject(basecode);
        return converter.apply(jsonObject);
    }

    /**
     * Converts a JSON array into a list of Java objects.
     * @param <S> The type of the values within the JSON array.
     * @param <V> The output type.
     * @param basecode The source URL.
     * @param sourceClass The type of the values within the JSON array.    
     * @param converter Converts a value of type {@code JsonObject} &rarr; a value of type {@code V}.
     * @return A non-modifiable {@code List<V>} instance, never {@code null}.
     * @throws NullPointerException If either {@code basecode}, {@code sourceClass} or {@code converter} is {@code null}.
     * @throws IOException In case of IO error.
     */
    public static <S extends JsonValue, V> List<V> listFromJsonArray(final String basecode, final Class<S> sourceClass, final Function<S, V> converter) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        Objects.requireNonNull(sourceClass);
        Objects.requireNonNull(converter);
        final JsonArray jsonArray = asJsonArray(basecode);
        final List<V> result = (jsonArray == null || jsonArray.isEmpty()) ? Collections.EMPTY_LIST : jsonArrayToCollection(jsonArray, sourceClass, converter, Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    /**
     * Converts a JSON array into a list of Java objects.
     * @param <S> The type of the values within the JSON array.
     * @param <V> The output type.
     * @param jsonArray The source array, may be {@code null}.
     * @param sourceClass The type of the values within the JSON array.    
     * @param converter Converts a value of type {@code JsonString} &rarr; a value of type {@code V}.
     * @return A non-modifiable {@code List<V>} instance, never {@code null}.
     * @throws NullPointerException If either {@code sourceClass} or {@code converter} is {@code null}.
     */
    public static <S extends JsonValue, V> List<V> listFromJsonArray(final JsonArray jsonArray, final Class<S> sourceClass, final Function<S, V> converter) throws NullPointerException {
        Objects.requireNonNull(sourceClass);
        Objects.requireNonNull(converter);
        final List<V> result = (jsonArray == null || jsonArray.isEmpty()) ? Collections.EMPTY_LIST : jsonArrayToCollection(jsonArray, sourceClass, converter, Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    /**
     * Converts a JSON array into a set of Java objects.
     * @param <S> The type of the values within the JSON array.
     * @param <V> The output type.
     * @param basecode The source URL.
     * @param sourceClass The type of the values within the JSON array.    
     * @param converter Converts a value of type {@code JsonObject} &rarr; a value of type {@code V}.
     * @return A non-modifiable {@code Set<V>} instance, never {@code null}.
     * @throws NullPointerException If either {@code basecode}, {@code sourceClass} or {@code converter} is {@code null}.
     * @throws IOException In case of IO error.
     */
    public static <S extends JsonValue, V> Set<V> setFromJsonArray(final String basecode, final Class<S> sourceClass, final Function<S, V> converter) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        Objects.requireNonNull(sourceClass);
        Objects.requireNonNull(converter);
        final JsonArray jsonArray = asJsonArray(basecode);
        final Set<V> result = (jsonArray == null || jsonArray.isEmpty()) ? Collections.EMPTY_SET : jsonArrayToCollection(jsonArray, sourceClass, converter, Collectors.toSet());
        return Collections.unmodifiableSet(result);
    }

    /**
     * Converts a JSON array into a set of Java objects.
     * @param <S> The type of the values within the JSON array.
     * @param <V> The output type.
     * @param jsonArray The source array, may be {@code null}.
     * @param sourceClass The type of the values within the JSON array.    
     * @param converter Converts a value of type {@code JsonString} &rarr; a value of type {@code V}.
     * @return A non-modifiable {@code Set<V>} instance, never {@code null}.
     * @throws NullPointerException If either {@code sourceClass} or {@code converter} is {@code null}.
     */
    public static <S extends JsonValue, V> Set<V> setFromJsonArray(final JsonArray jsonArray, final Class<S> sourceClass, final Function<S, V> converter) throws NullPointerException {
        Objects.requireNonNull(sourceClass);
        Objects.requireNonNull(converter);
        final Set<V> result = (jsonArray == null || jsonArray.isEmpty()) ? Collections.EMPTY_SET : jsonArrayToCollection(jsonArray, sourceClass, converter, Collectors.toSet());
        return Collections.unmodifiableSet(result);
    }

    /**
     * Converts the content of a JSON array in a collection.
     * @param <S> The type of the values within the JSON array.
     * @param <T> The expected output type.
     * @param <U> The desired collection output type.
     * @param jsonArray The source JSON array.
     * @param sourceClass The type of the values within the JSON array.
     * @param converter Converts a value of type {@code S} -> a value of type {@code T}.
     * @param collector Collects a stream of type {@code T} into a collection of type {@code U}.
     * @return An {@code U} instance, never {@code null}. The returned collection is modifiable.
     * @throws NullPointerException If either (@code jsonArray}, (@code sourceClass}, (@code converter} or (@code collector} is {@code null}.
     */
    private static <S extends JsonValue, T, U extends Collection<T>> U jsonArrayToCollection(final JsonArray jsonArray, final Class<S> sourceClass, final Function<S, T> converter, final Collector<T, ?, U> collector) throws NullPointerException {
        Objects.requireNonNull(jsonArray);
        Objects.requireNonNull(sourceClass);
        Objects.requireNonNull(converter);
        Objects.requireNonNull(collector);
        final U result = jsonArray.getValuesAs(sourceClass)
                .stream()
                .map(converter)
                .collect(collector);
        return result;
    }

    /**
     * Gets a Java integer from a key that may be missing or {@code null}.
     * @param source The source JSON object.
     * @param key The key.
     * @param defaultValue The default value.
     * @return An {@code int} instance, may be {@code defaultValue} if {@code key} is {@code null} or absent from {@code source}.
     * @throws NullPointerException If either {@code source} or {@code key} is {@code null}.
     */
    public static int nullOrMissingInt(final JsonObject source, final String key, final int defaultValue) throws NullPointerException {
        Objects.requireNonNull(source);
        Objects.requireNonNull(key);
        return nullOrMissingValue(source, source::getInt, key, defaultValue);
    }

    /**
     * Gets a Java {@code String} from a key that may be missing or {@code null}.
     * @param source The source JSON object.
     * @param key The key.
     * @return A {@code String} instance, may be {@code null} if {@code key} is {@code null} or absent from {@code source}.
     * @throws NullPointerException If either {@code source} or {@code key} is {@code null}.
     */
    public static String nullOrMissingString(final JsonObject source, final String key) throws NullPointerException {
        Objects.requireNonNull(source);
        Objects.requireNonNull(key);
        return nullOrMissingValue(source, source::getString, key, null);
    }

    /**
     * Gets a JSON string from a key that may be missing or {@code null}.
     * @param source The source JSON object.
     * @param key The key.
     * @return A {@code JsonString} instance, may be {@code null} if {@code key} is {@code null} or absent from {@code source}.
     * @throws NullPointerException If either {@code source} or {@code key} is {@code null}.
     */
    public static JsonString nullOrMissingJsonString(final JsonObject source, final String key) throws NullPointerException {
        Objects.requireNonNull(source);
        Objects.requireNonNull(key);
        return nullOrMissingValue(source, source::getJsonString, key, null);
    }

    /**
     * Gets a JSON object from a key that may be missing or {@code null}.
     * @param source The source JSON object.
     * @param key The key.
     * @return A {@code JsonObject} instance, may be {@code null} if {@code key} is {@code null} or absent from {@code source}.
     * @throws NullPointerException If either {@code source} or {@code key} is {@code null}.
     */
    public static JsonObject nullOrMissingJsonObject(final JsonObject source, final String key) throws NullPointerException {
        Objects.requireNonNull(source);
        Objects.requireNonNull(key);
        return nullOrMissingValue(source, source::getJsonObject, key, null);
    }

    /**
     * Gets a JSON array from a key that may be missing or {@code null}.
     * @param source The source JSON object.
     * @param key The key.
     * @return A {@code JsonArray} instance, may be {@code null} if {@code key} is {@code null} or absent from {@code source}.
     * @throws NullPointerException If either {@code source} or {@code key} is {@code null}.
     */
    public static JsonArray nullOrMissingJsonArray(final JsonObject source, final String key) throws NullPointerException {
        Objects.requireNonNull(source);
        Objects.requireNonNull(key);
        return nullOrMissingValue(source, source::getJsonArray, key, null);
    }

    /**
     * Gets a JSON number from a key that may be missing or {@code null}.
     * @param source The source JSON object.
     * @param key The key.
     * @return A {@code JsonNumber} instance, may be {@code null} if {@code key} is {@code null} or absent from {@code source}.
     * @throws NullPointerException If either {@code source} or {@code key} is {@code null}.
     */
    public static JsonNumber nullOrMissingJsonNumber(final JsonObject source, final String key) throws NullPointerException {
        Objects.requireNonNull(source);
        Objects.requireNonNull(key);
        return nullOrMissingValue(source, source::getJsonNumber, key, null);
    }

    /**
     * Gets a value from a key that may be missing or {@code null}.
     * @param <T> The type to use.
     * @param source The source JSON object.
     * @param supplier The supplier function.
     * @param key The key.
     * @param defaultValue The default value.
     * @return A {@code T} instance, may be {@code defaultValue} if {@code key} is {@code null} or absent from {@code source}.
     * @throws NullPointerException If either {@code source}, {@code supplier} or {@code key} is {@code null}.
     */
    private static <T> T nullOrMissingValue(final JsonObject source, final Function<String, T> supplier, final String key, final T defaultValue) throws NullPointerException {
        Objects.requireNonNull(source);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(key);
        return (!source.containsKey(key) || source.isNull(key)) ? defaultValue : supplier.apply(key);
    }
}
