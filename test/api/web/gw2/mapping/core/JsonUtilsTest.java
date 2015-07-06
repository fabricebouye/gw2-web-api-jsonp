/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
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
public class JsonUtilsTest {

    public JsonUtilsTest() {
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
     * Test of asJsonArray method, of class JsonUtils.
     */
    @Test
    public void testAsJsonArray() throws Exception {
        System.out.println("asJsonArray"); // NOI18N.
        final URL url = getClass().getResource("jsonarray1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonArray expResult = Json.createArrayBuilder()
                .add(0)
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .add(6)
                .build();
        final JsonArray result = JsonUtils.asJsonArray(basecode);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult, result);
    }

    /**
     * Test of asJsonObject method, of class JsonUtils.
     */
    @Test
    public void testAsJsonObject() throws Exception {
        System.out.println("asJsonObject"); // NOI18N.
        final URL url = getClass().getResource("jsonobject1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonObject expResult = Json.createObjectBuilder()
                .add("id", 1) // NOI18N.
                .add("name", "FabriceB") // NOI18N.
                .build();
        final JsonObject result = JsonUtils.asJsonObject(basecode);
        assertEquals(expResult, result);
    }

    /**
     * Class to construct during the test.
     * @author Fabrice Bouyé
     */
    private static class Foo {

        int id;
        String name;

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            if (obj instanceof Foo) {
                Foo r = (Foo) obj;
                result = (id == r.id) && (name.equals(r.name));
            }
            return result;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 73 * hash + this.id;
            hash = 73 * hash + Objects.hashCode(this.name);
            return hash;
        }
    }

    /**
    * Factory method for class Foo.
    */
    private static final Function<JsonObject, Foo> JSON_FOO_FACTORY = jsonObject -> {
        final Foo result = new Foo();
        result.id = jsonObject.getInt("id"); // NOI18N.
        result.name = jsonObject.getString("name"); // NOI18N.
        return result;
    };

    /**
     * Test of fromJsonObject method, of class JsonUtils.
     */
    @Test
    public void testFromJsonObject() throws Exception {
        System.out.println("fromJsonObject"); // NOI18N.
        final URL url = getClass().getResource("jsonobject1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final Foo expResult = new Foo();
        expResult.id = 1;
        expResult.name = "FabriceB"; // NOI18N.
        final Foo result = JsonUtils.fromJsonObject(basecode, JSON_FOO_FACTORY);
        assertEquals(expResult, result);
    }

    /**
     * Test of listFromJsonObjectArray method, of class JsonUtils.
     */
    @Test
    public void testListFromJsonObjectArray() throws Exception {
        System.out.println("listFromJsonObjectArray"); // NOI18N.
        final URL url = getClass().getResource("jsonobject2.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final List<Foo> expValues = Arrays.asList(new Foo(), new Foo());
        expValues.get(0).id = 1;
        expValues.get(0).name = "FabriceB"; // NOI18N.
        expValues.get(1).id = 2;
        expValues.get(1).name = "Toto"; // NOI18N.
        final List<Foo> resultValues = JsonUtils.listFromJsonObjectArray(basecode, JSON_FOO_FACTORY);
        assertEquals(expValues.size(), resultValues.size());
        IntStream.range(0, expValues.size())
                .forEach(index -> {
                    final Foo expResult = expValues.get(index);
                    final Foo result = resultValues.get(index);
                    assertEquals(expResult, result);
                });
    }

    /**
     * Test of listFromJsonStringArray method, of class JsonUtils.
     */
    @Test
    public void testListFromJsonStringArray() throws Exception {
        System.out.println("listFromJsonStringArray"); // NOI18N.
        final URL url = getClass().getResource("jsonarray2.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final List<String> expValues = Arrays.asList("0", "1", "2", "3", "4", "5", "6"); // NOI18N.
        final List<String> values = JsonUtils.listFromJsonStringArray(basecode, JsonString::getString);
        assertEquals(expValues.size(), values.size());
        IntStream.range(0, expValues.size())
                .forEach(index -> {
                    final String expResult = expValues.get(index);
                    final String result = values.get(index);
                    assertEquals(expResult, result);
                });
    }

    /**
     * Test of setFromJsonOpjectArray method, of class JsonUtils.
     */
    @Test
    public void testSetFromJsonOpjectArray() throws Exception {
        System.out.println("setFromJsonOpjectArray"); // NOI18N.
        final URL url = getClass().getResource("jsonobject2.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final List<Foo> expValues = Arrays.asList(new Foo(), new Foo());
        expValues.get(0).id = 1;
        expValues.get(0).name = "FabriceB"; // NOI18N
        expValues.get(1).id = 2;
        expValues.get(1).name = "Toto"; // NOI18N
        final Set<Foo> resultValues = JsonUtils.setFromJsonOpjectArray(basecode, JSON_FOO_FACTORY);
        assertEquals(expValues.size(), resultValues.size());
        IntStream.range(0, expValues.size())
                .forEach(index -> {
                    final Foo value = expValues.get(index);
                    final boolean expResult = true;
                    final boolean result = resultValues.contains(value);
                    assertEquals(expResult, result);
                });
    }

    /**
     * Test of setFromJsonStringArray method, of class JsonUtils.
     */
    @Test
    public void testSetFromJsonStringArray() throws Exception {
        System.out.println("setFromJsonStringArray"); // NOI18N.
        final URL url = getClass().getResource("jsonarray2.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final List<String> expValues = Arrays.asList("0", "1", "2", "3", "4", "5", "6"); // NOI18N.
        final Set<String> resultValues = JsonUtils.setFromJsonStringArray(basecode, JsonString::getString);
        assertEquals(expValues.size(), resultValues.size());
        IntStream.range(0, expValues.size())
                .forEach(index -> {
                    final String value = expValues.get(index);
                    final boolean expResult = true;
                    final boolean result = resultValues.contains(value);
                    assertEquals(expResult, result);
                });
    }
}
