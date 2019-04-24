/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.quaggans;

import api.web.gw2.mapping.core.URLReference;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test.
 *
 * @author Fabrice Bouyé
 */
public class JsonpQuagganTest {

    public JsonpQuagganTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpQuaggan instance;

    @BeforeEach
    public void setUp() throws Exception {
        instance = new JsonpQuaggan();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.set(instance, "testId"); // NOI18N.
        final Field urlField = instance.getClass().getDeclaredField("url"); // NOI18N.
        urlField.setAccessible(true);
        urlField.set(instance, URLReference.of("http://testUrl")); // NOI18N.
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpQuaggan.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId"); // NOI18N.
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        final String expResult = (String) idField.get(instance);
        final String result = instance.getId();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUrl method, of class JsonpQuaggan.
     */
    @Test
    public void testGetUrl() throws Exception {
        System.out.println("getUrl"); // NOI18N.
        final Field urlField = instance.getClass().getDeclaredField("url"); // NOI18N.
        urlField.setAccessible(true);
        final URLReference expResult = (URLReference) urlField.get(instance);
        final URLReference result = instance.getUrl();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

}
