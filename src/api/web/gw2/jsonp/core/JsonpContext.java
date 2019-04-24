/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.core;

import api.web.gw2.mapping.core.EnumValueFactory;
import api.web.gw2.mapping.core.PageResult;
import api.web.gw2.mapping.core.WebAPIError;
import api.web.gw2.mapping.core.WebAPIException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The public context that allows to parse results provided by the GW2 Web API.
 *
 * @author Fabrice Bouyé
 */
public enum JsonpContext {
    /**
     * This context will use an event driven marshaller whenever possible.
     */
    SAX(new JsonpSAXMarshaller()),
    /**
     * This context will use a marshaller that loads wholesome structures in memory whenever possible.
     */
    DOM(new JsonpDOMMarshaller());

    /**
     * The underlying marshaller used by this context.
     */
    private final JsonpAbstractMarshaller marshaller;

    /**
     * Creates a new instance.
     *
     * @param marshaller The underlying marshaller used by this context.
     */
    JsonpContext(final JsonpAbstractMarshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void checkConnectionError(final URLConnection connection) throws NullPointerException, IOException {
        Objects.requireNonNull(connection);
        final String encoding = connection.getContentEncoding();
        // Deal with error from the server
        if (connection instanceof HttpURLConnection) {
            final HttpURLConnection httpConnection = (HttpURLConnection) connection;
            final int code = httpConnection.getResponseCode();
            switch (code) {
                case HttpURLConnection.HTTP_OK:
                    break;
                default: {
                    //conn.getHeaderFields().entrySet().stream().forEach(System.out::println);                    
                    try (final InputStream input = httpConnection.getErrorStream()) {
                        try (final ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                            IOUtils.INSTANCE.copy(input, output);
                            final String errorText = new String(output.toByteArray(), (encoding == null) ? "utf-8" : encoding); // NOI18N.
                            // @todo Throw exception with error message.
                            switch (code) {
                                // 403 contains JSON.
                                case HttpURLConnection.HTTP_FORBIDDEN: {
                                    try (final InputStream jsonInput = new ByteArrayInputStream(errorText.getBytes(StandardCharsets.UTF_8))) { // NOI18N.
                                        final WebAPIError error = DOM.marshaller.loadObject(WebAPIError.class, jsonInput);
                                        throw WebAPIException.of403(error);
                                    }
                                }
                                // 404 contains HTML.
                                case HttpURLConnection.HTTP_NOT_FOUND: {
                                    throw WebAPIException.of404(errorText);
                                }
                                default: {
                                    throw new WebAPIException(code, errorText);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public URLConnection openConnection(final URL url) throws NullPointerException, IOException {
        Objects.requireNonNull(url);
        final URLConnection connection = url.openConnection();
        connection.connect();
        checkConnectionError(connection);
        return connection;
    }

    /**
     * Loads an object from given URL
     *
     * @param <T>         The type to use.
     * @param targetClass The target class.
     * @param url         The url to query.
     * @return A {@code T} instance, may be {@code null}.
     * @throws NullPointerException If either {@code targetClass} or {@code url} is {@code null}.
     * @throws WebAPIException      In case of GW2 API error.
     * @throws IOException          In case of IO errors.
     */
    public final <T> T loadObject(final Class<T> targetClass, final URL url) throws NullPointerException, WebAPIException, IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(url);
        try (final InputStream input = openConnection(url).getInputStream()) {
            return loadObject(targetClass, input);
        }
    }

    public final <T> T loadObject(final Class<T> targetClass, final InputStream input) throws NullPointerException, IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(input);
        return marshaller.loadObject(targetClass, input);
    }

    /**
     * Loads an object array from given URL
     *
     * @param <T>         The type to use.
     * @param targetClass The target class.
     * @param url         The url to query.
     * @return A {@code Collection<T>} instance, may be {@code null}.
     * @throws NullPointerException If either {@code targetClass} or {@code url} is {@code null}.
     * @throws WebAPIException      In case of GW2 API error.
     * @throws IOException          In case of IO errors.
     */
    public <T> Collection<T> loadObjectArray(final Class<T> targetClass, final URL url) throws NullPointerException, WebAPIException, IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(url);
        try (final InputStream input = openConnection(url).getInputStream()) {
            return loadObjectArray(targetClass, input);
        }
    }

    public <T> Collection<T> loadObjectArray(final Class<T> targetClass, final InputStream input) throws IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(input);
        return marshaller.loadObjectArray(targetClass, input);
    }

    /**
     * Loads an enum array from given URL
     *
     * @param <T>       The type to use.
     * @param enumClass The enum class.
     * @param url       The url to query.
     * @return A {@code Collection<T>} instance, may be {@code null}.
     * @throws NullPointerException If either {@code enumClass} or {@code url} is {@code null}.
     * @throws WebAPIException      In case of GW2 API error.
     * @throws IOException          In case of IO errors.
     */
    public <T extends Enum> Collection<T> loadEnumArray(final Class<T> enumClass, final URL url) throws NullPointerException, WebAPIException, IOException {
        Objects.requireNonNull(enumClass);
        Objects.requireNonNull(url);
        try (final InputStream input = openConnection(url).getInputStream()) {
            return loadEnumArray(enumClass, input);
        }
    }

    public <T extends Enum> Collection<T> loadEnumArray(final Class<T> enumClass, final InputStream input) throws IOException {
        Objects.requireNonNull(enumClass);
        Objects.requireNonNull(input);
        final Collection<String> values = marshaller.loadObjectArray(String.class, input);
        final List<T> result = values.stream()
                .map(value -> EnumValueFactory.INSTANCE.mapEnumValue(enumClass, value))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    /**
     * Loads a page from given paginated URL
     *
     * @param <T>         The type to use.
     * @param targetClass The target class.
     * @param url         The url to query.
     * @return A {@code PageResult<T>} instance, never {@code null}.
     * @throws NullPointerException If either {@code targetClass} or {@code url} is {@code null}.
     * @throws IOException          In case of IO errors.
     */
    public final <T> PageResult<T> loadPage(final Class<T> targetClass, final URL url) throws NullPointerException, IOException {
        Objects.requireNonNull(targetClass);
        Objects.requireNonNull(url);
        final URLConnection connection = openConnection(url);
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
            final Collection<T> collection = marshaller.loadObjectArray(targetClass, input);
            // If local JSON file, need to hack those values.
            pageSize = (pageSize == -1) ? collection.size() : pageSize;
            resultTotal = (resultTotal == -1) ? collection.size() : resultTotal;
            final PageResult<T> result = new PageResult<>(collection, pageSize, pageTotal, resultTotal);
            return result;
        }
    }

    public <T> T loadRuntimeObject(final String selector, final String pattern, final URL url) throws IOException {
        Objects.requireNonNull(selector);
        Objects.requireNonNull(pattern);
        Objects.requireNonNull(url);
        try (final InputStream input = openConnection(url).getInputStream()) {
            return marshaller.loadRuntimeObject(selector, pattern, input);
        }
    }
}
