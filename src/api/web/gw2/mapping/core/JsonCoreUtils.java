/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import java.util.Objects;
import java.util.function.Function;
import javax.json.JsonArray;

/**
 * A factory that uses JSON-P to produce a core objects.
 * @author Fabrice Bouyé
 */
public enum JsonCoreUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    public MapDimension jsonArrayToMapDimension(final JsonArray jsonArray) throws NullPointerException, IllegalArgumentException {
        testArraySize(jsonArray, 2);
        final Point2D p1 = jsonArrayToPoint2D(jsonArray.getJsonArray(0));
        final Point2D p2 = jsonArrayToPoint2D(jsonArray.getJsonArray(1));
        final MapDimension result = new MapDimension(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        return result;
    }

    public ContinentDimension jsonArrayToContinentDimension(final JsonArray jsonArray) throws NullPointerException, IllegalArgumentException {
        testArraySize(jsonArray, 2);
        final Point2D p1 = jsonArrayToPoint2D(jsonArray.getJsonArray(0));
        final Point2D p2 = jsonArrayToPoint2D(jsonArray.getJsonArray(1));
        final ContinentDimension result = new ContinentDimension(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        return result;
    }

    public Point2D jsonArrayToPoint2D(final JsonArray jsonArray) throws NullPointerException, IllegalArgumentException {
        testArraySize(jsonArray, 2);
        return from2Value(index -> jsonArray.getJsonNumber(index).doubleValue(), Point2D::new);
    }

    public Point3D jsonArrayToPoint3D(final JsonArray jsonArray) throws NullPointerException, IllegalArgumentException {
        testArraySize(jsonArray, 3);
        return from3Value(index -> jsonArray.getJsonNumber(index).doubleValue(), Point3D::new);
    }

    public NumericRange<Integer> jsonArrayToNumericRangeInt(final JsonArray jsonArray) throws NullPointerException, IllegalArgumentException {
        testArraySize(jsonArray, 2);
        return from2Value(jsonArray::getInt, NumericRange::new);
    }

    public NumericRange<Double> jsonArrayToNumericRangeDouble(final JsonArray jsonArray) throws NullPointerException, IllegalArgumentException {
        testArraySize(jsonArray, 2);
        return from2Value(index -> jsonArray.getJsonNumber(index).doubleValue(), NumericRange::new);
    }

    private void testArraySize(JsonArray jsonArray, int minSize) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(jsonArray);
        if (jsonArray.size() < minSize) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Extracts values from a 2 value array and convert it to an object of type {@code V}.
     * @param <T> The type of the values within the array.
     * @param <V> The return type.
     * @param extractor Extracts values from the array.
     * @param allocator Allocate the result with 2 extracted values.
     * @return A {@code V} instance, never {@code null}.
     * @throws NullPointerException If either {@code extractor} or {@code allocator} is {@code null}.
     */
    private <T extends Number, V> V from2Value(final Function<Integer, T> extractor, Allocator2Arguments<T, V> allocator) throws NullPointerException {
        Objects.requireNonNull(extractor);
        Objects.requireNonNull(allocator);
        final T v1 = extractor.apply(0);
        final T v2 = extractor.apply(1);
        return allocator.allocate(v1, v2);
    }

    /**
     * Extracts values from a 3 value array and convert it to an object of type {@code V}.
     * @param <T> The type of the values within the array.
     * @param <V> The return type.
     * @param extractor Extracts values from the array.
     * @param allocator Allocate the result with 3 extracted values.
     * @return A {@code V} instance, never {@code null}.
     * @throws NullPointerException If either {@code extractor} or {@code allocator} is {@code null}.
     */
    private <T extends Number, V> V from3Value(final Function<Integer, T> extractor, Allocator3Arguments<T, V> allocator) throws NullPointerException {
        Objects.requireNonNull(extractor);
        Objects.requireNonNull(allocator);
        final T v1 = extractor.apply(0);
        final T v2 = extractor.apply(1);
        final T v3 = extractor.apply(1);
        return allocator.allocate(v1, v2, v3);
    }

    /**
     * Defines a factory method that takes 2 arguments.
     * @param <T> The input type.
     * @param <V> The output type.
     * @author Fabrice Bouyé
     */
    @FunctionalInterface
    private interface Allocator2Arguments<T, V> {

        /**
         * Allocate a new instance.
         * @param t1 Parameter 1.
         * @param t2 Parameter 2.
         * @return A {@code V} instance, never {@code null}.
         */
        public V allocate(final T t1, final T t2);
    }

    /**
     * Defines a factory method that takes 3 arguments.
     * @param <T> The input type.
     * @param <V> The output type.
     * @author Fabrice Bouyé
     */
    @FunctionalInterface
    private interface Allocator3Arguments<T, V> {

        /**
         * Allocate a new instance.
         * @param t1 Parameter 1.
         * @param t2 Parameter 2.
         * @param t3 Parameter 3.
         * @return A {@code V} instance, never {@code null}.
         */
        public V allocate(final T t1, final T t2, final T t3);
    }
}
