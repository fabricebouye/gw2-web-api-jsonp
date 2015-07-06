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
import java.net.URL;
import java.util.List;
import java.util.stream.IntStream;
import javax.json.JsonArray;
import javax.json.JsonObject;
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

    /**
     * Test of jsonObjectToQuaggan method, of class JsonQuaggansUtilsTest.
     */
    @Test
    public void testGetFactory() throws IOException {
        System.out.println("getFactory"); // NOI18N.
        final URL url = getClass().getResource("quaggan1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonObject jsonObject = JsonUtils.asJsonObject(basecode);
        final Quaggan result = JsonQuaggansUtils.getFactory().create(basecode);
        assertEquals(jsonObject.getString("id"), result.getId()); // NOI18N.
        assertEquals(jsonObject.getString("url"), result.getUrl()); // NOI18N.
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
        assertEquals(jsonObject.getString("id"), result.getId()); // NOI18N.
        assertEquals(jsonObject.getString("url"), result.getUrl()); // NOI18N.
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
        final List<Quaggan> results = JsonUtils.listFromJsonObjectArray(url.toExternalForm(), JsonQuaggansUtils.INSTANCE::jsonObjectToQuaggan);
        assertEquals(jsonArray.size(), results.size());
        IntStream.range(0, jsonArray.size())
                .forEach(index -> {
                    final JsonObject jsonObject = jsonArray.getJsonObject(index);
                    final Quaggan result = results.get(index);
                    assertEquals(jsonObject.getString("id"), result.getId()); // NOI18N.
                    assertEquals(jsonObject.getString("url"), result.getUrl()); // NOI18N.
                });
    }
}
