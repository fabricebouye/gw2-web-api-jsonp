/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.maps;

import api.web.gw2.mapping.core.JsonUtils;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import javax.json.JsonArray;
import javax.json.JsonNumber;
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
public class JsonMapsUtilsTest {

    public JsonMapsUtilsTest() {
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

    private void testMap(final JsonObject jsonObject, final Map result) {
        assertNotNull(jsonObject);
        assertNotNull(result);
        assertEquals(jsonObject.getInt("id"), result.getId());
        assertEquals(jsonObject.getString("name"), result.getName());
        assertEquals(jsonObject.getInt("min_level"), result.getMinLevel());
        assertEquals(jsonObject.getInt("max_level"), result.getMaxLevel());
        assertEquals(jsonObject.getInt("default_floor"), result.getDefaultFloor());
        assertEquals(jsonObject.getInt("region_id"), result.getRegionId());
        assertEquals(jsonObject.getString("region_name"), result.getRegionName());
        assertEquals(jsonObject.getInt("continent_id"), result.getContinentId());
        assertEquals(jsonObject.getString("continent_name"), result.getContinentName());
        final JsonArray jsonFloors = jsonObject.getJsonArray("floors");
        final Set<Integer> floors = JsonUtils.setFromJsonArray(jsonFloors, JsonNumber.class, JsonUtils.INTEGER_CONVERTER);
        assertEquals(floors, result.getFloors());
    }

    /**
     * Test of jsonObjectToMap method, of class JsonMapsUtils.
     */
    @Test
    public void testJsonObjectToMap() throws IOException {
        System.out.println("jsonObjectToMap"); // NOI18N.
        final URL url = getClass().getResource("map1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonObject jsonObject = JsonUtils.asJsonObject(basecode);
        final Map result = JsonMapsUtils.INSTANCE.jsonObjectToMap(jsonObject);
        testMap(jsonObject, result);
    }

}
