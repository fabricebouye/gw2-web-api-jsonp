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
import java.net.URL;
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
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;

/**
 * JSR 353 JSON-P utility class.
* <br>This class provides core utility methods that are used throughout this factory implementation.
 * @author Fabrice Bouyé
 */
public enum JsonUtils {

    INSTANCE;

    /**
     * Gets a JSON array from the provided URL.
     * @param basecode The source URL.
     * @return A {@code JSonArray} instance, never {@code null}.
     * @throws NullPointerException If (@code basecode} is {@code null}.    
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
     * @throws NullPointerException If (@code basecode} is {@code null}.    
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
     * @param converter Converts a value of type {@code JsonObject} -> a value of type {@code V}.
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
     * Converts an array of JSON objects into a list of Java objects.
     * @param <V> The output type.
     * @param basecode The source URL.
     * @param converter Converts a value of type {@code JsonObject} -> a value of type {@code V}.
     * @return A non-modifiable {@code List<V>} instance, never {@code null}.
     * @throws NullPointerException If either (@code basecode} or (@code converter} is {@code null}.
     * @throws IOException In case of IO error.
     */
    public static <V> List<V> listFromJsonObjectArray(final String basecode, final Function<JsonObject, V> converter) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        Objects.requireNonNull(converter);
        final JsonArray jsonArray = asJsonArray(basecode);
        final List<V> result = jsonArrayToCollection(jsonArray, JsonObject.class, converter, Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    /**
     * Converts an array of JSON strings into a list of Java objects.
     * @param <V> The output type.
     * @param basecode The source URL.
     * @param converter Converts a value of type {@code JsonString} -> a value of type {@code V}.
     * @return A non-modifiable {@code List<V>} instance, never {@code null}.
     * @throws NullPointerException If either (@code basecode} or (@code converter} is {@code null}.
     * @throws IOException In case of IO error.
     */
    public static <V> List<V> listFromJsonStringArray(final String basecode, final Function<JsonString, V> converter) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        Objects.requireNonNull(converter);
        final JsonArray jsonArray = asJsonArray(basecode);
        final List<V> result = jsonArrayToCollection(jsonArray, JsonString.class, converter, Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    /**
     * Converts an array of JSON objects into a set of Java objects.
     * @param <V> The output type.
     * @param basecode The source URL.
     * @param converter Converts a value of type {@code JsonObject} -> a value of type {@code V}.
     * @return A non-modifiable {@code Set<V>} instance, never {@code null}.
     * @throws NullPointerException If either (@code basecode} or (@code converter} is {@code null}.
     * @throws IOException In case of IO error.
     */
    public static <V> Set<V> setFromJsonOpjectArray(final String basecode, final Function<JsonObject, V> converter) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        Objects.requireNonNull(converter);
        final JsonArray jsonArray = asJsonArray(basecode);
        final Set<V> result = jsonArrayToCollection(jsonArray, JsonObject.class, converter, Collectors.toSet());
        return Collections.unmodifiableSet(result);
    }

    /**
     * Converts an array of JSON strings into a set of Java objects.
     * @param <V> The output type.
     * @param basecode The source URL.
     * @param converter Converts a value of type {@code JsonString} -> a value of type {@code V}.
     * @return A non-modifiable {@code Set<V>} instance, never {@code null}.
     * @throws NullPointerException If either (@code basecode} or (@code converter} is {@code null}.
     * @throws IOException In case of IO error.
     */
    public static <V> Set<V> setFromJsonStringArray(final String basecode, final Function<JsonString, V> converter) throws NullPointerException, IOException {
        Objects.requireNonNull(basecode);
        Objects.requireNonNull(converter);
        final JsonArray jsonArray = asJsonArray(basecode);
        final Set<V> result = jsonArrayToCollection(jsonArray, JsonString.class, converter, Collectors.toSet());
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
}
