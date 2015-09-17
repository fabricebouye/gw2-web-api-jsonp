/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.quaggans;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
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
public class JsonpQuagganTest {

    public JsonpQuagganTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpQuaggan instance;

    @Before
    public void setUp() throws Exception {
        instance = new JsonpQuaggan();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.set(instance, "testId"); // NOI18N.
        final Field urlField = instance.getClass().getDeclaredField("url"); // NOI18N.
        urlField.setAccessible(true);
        urlField.set(instance, Optional.of(new URL("http://testUrl"))); // NOI18N.
    }

    @After
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
        final Optional<URL> expResult = (Optional<URL>) urlField.get(instance);
        final Optional<URL> result = instance.getUrl();
        assertEquals(expResult, result);
    }

}
