/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.quaggans;

import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.quaggans.Quaggan;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test.
 *
 * @author Fabrice Bouyé
 */
public class JsonQuaggansUtilsTest {

    public JsonQuaggansUtilsTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    private void testQuaggan(final JsonObject jsonObject, final Quaggan result) {
        assertNotNull(jsonObject);
        assertNotNull(result);
        assertEquals(jsonObject.getString("id"), result.getId()); // NOI18N.
        assertEquals(jsonObject.getString("url"), result.getUrl().get().toExternalForm()); // NOI18N.
    }

    @Test
    public void stream() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        final URL url = getClass().getResource("quaggan1.json"); // NOI18N.
        try (final InputStream source = url.openStream()) {
            final JsonParser parser = Json.createParser(source);
            Class aClass = api.web.gw2.jsonp.v2.quaggans.JsonpQuaggan.class;
            Object instance = aClass.newInstance();
            try {
                String lastId = null;
                while (parser.hasNext()) {
                    final Event event = parser.next();
                    switch (event) {
                        case START_ARRAY:
                            System.out.println("START_ARRAY");
                            break;
                        case START_OBJECT:
                            System.out.println("START_OBJECT");
                            break;
                        case KEY_NAME:
                            System.out.println("KEY_NAME");
                            lastId = parser.getString();
                            break;
                        case VALUE_STRING:
                            System.out.println("VALUE_STRING");
                            final String string = parser.getString();
                            final Field field = aClass.getDeclaredField(lastId);
                            boolean isOptional = field.getAnnotation(OptionalValue.class) != null;
                            boolean isURL = field.getAnnotation(URLValue.class) != null;
                            boolean wasAcessible = field.isAccessible();
                            field.setAccessible(true);
                            Object value = string;
                            if (isURL) {
                                value = URLReference.of(string);
                            }
                            if (isOptional) {
                                value = Optional.of(value);
                            }
                            field.set(instance, value);
                            field.setAccessible(wasAcessible);
                            break;
                        case VALUE_NUMBER:
                            System.out.println("VALUE_NUMBER");
                            break;
                        case VALUE_TRUE:
                            System.out.println("VALUE_TRUE");
                            break;
                        case VALUE_FALSE:
                            System.out.println("VALUE_FALSE");
                            break;
                        case VALUE_NULL:
                            System.out.println("VALUE_NULLz");
                            break;
                        case END_OBJECT:
                            System.out.println("END_OBJECT");
                            break;
                        case END_ARRAY:
                            System.out.println("END_ARRAY");
                            break;
                    }
                }
            } finally {
                parser.close();
            }
        }
    }
}
