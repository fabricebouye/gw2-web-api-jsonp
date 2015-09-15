/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.quaggans;

import api.web.gw2.mapping.core.JsonUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import java.util.stream.IntStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test.
 * @author Fabrice Bouyé
 */
public class JsonQuaggansUtilsTest {

    public JsonQuaggansUtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private void testQuaggan(final JsonObject jsonObject, final Quaggan result) {
        assertNotNull(jsonObject);
        assertNotNull(result);
        assertEquals(jsonObject.getString("id"), result.getId()); // NOI18N.
        assertEquals(jsonObject.getString("url"), result.getUrl()); // NOI18N.
    }

    /**
     * Test of getQuagganFactory method, of class JsonQuaggansUtilsTest.
     */
    @Test
    public void testGetQuagganFactory() throws IOException {
        System.out.println("getQuagganFactory"); // NOI18N.
        final QuagganFactory factory = JsonQuaggansUtils.getQuagganFactory();
        assertNotNull(factory);
        final URL url = getClass().getResource("quaggan1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonObject jsonObject = JsonUtils.asJsonObject(basecode);
        final Quaggan result = factory.create(basecode);
        testQuaggan(jsonObject, result);
    }

    /**
     * Test of jsonObjectToQuaggan method, of class JsonQuaggansUtilsTest.
     */
    @Test
    public void testJsonObjectToQuaggan_1() throws IOException {
        System.out.println("jsonObjectToQuaggan_1"); // NOI18N.
        final URL url = getClass().getResource("quaggan1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonObject jsonObject = JsonUtils.asJsonObject(basecode);
        final Quaggan result = JsonQuaggansUtils.INSTANCE.jsonObjectToQuaggan(jsonObject);
        testQuaggan(jsonObject, result);
    }

    /**
     * Test of jsonObjectToQuaggan method, of class JsonQuaggansUtilsTest.
     */
    @Test
    public void getJsonObjectToQuaggan_2() throws IOException {
        System.out.println("jsonObjectToQuaggan_2"); // NOI18N.
        final URL url = getClass().getResource("quaggan2.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonArray jsonArray = JsonUtils.asJsonArray(basecode);
        final List<Quaggan> results = JsonUtils.listFromJsonArray(url.toExternalForm(), JsonObject.class, JsonQuaggansUtils.INSTANCE::jsonObjectToQuaggan);
        assertEquals(jsonArray.size(), results.size());
        IntStream.range(0, jsonArray.size())
                .forEach(index -> {
                    final JsonObject jsonObject = jsonArray.getJsonObject(index);
                    final Quaggan result = results.get(index);
                    testQuaggan(jsonObject, result);
                });
    }

    @Test
    public void stream() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        final URL url = getClass().getResource("quaggan1.json"); // NOI18N.
        try (final InputStream source = url.openStream()) {
            final JsonParser parser = Json.createParser(source);
            Class aClass = api.web.gw2.mapping.v2.quaggans.JsonpQuaggan.class;
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
                            boolean wasAcessible = field.isAccessible();
                            field.setAccessible(true);
                            field.set(instance, string);
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
