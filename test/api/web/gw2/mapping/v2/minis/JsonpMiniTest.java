/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.minis;

import api.web.gw2.mapping.core.URLReference;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
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
public final class JsonpMiniTest {

    public JsonpMiniTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpMini instance;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, MalformedURLException {
        instance = new JsonpMini();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 1);
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        nameField.set(instance, "Foo"); // NOI18N.
        final Field unlockField = instance.getClass().getDeclaredField("unlock"); // NOI18N.
        unlockField.setAccessible(true);
        unlockField.set(instance, Optional.of("Fuu")); // NOI18N.
        final Field iconField = instance.getClass().getDeclaredField("icon"); // NOI18N.
        iconField.setAccessible(true);
        iconField.set(instance, URLReference.of("http://foo.foo/foo.png")); // NOI18N.
        final Field orderField = instance.getClass().getDeclaredField("order"); // NOI18N.
        orderField.setAccessible(true);
        orderField.setInt(instance, 10);
        final Field itemIdField = instance.getClass().getDeclaredField("itemId"); // NOI18N.
        itemIdField.setAccessible(true);
        itemIdField.setInt(instance, 1984);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JsonpMini.
     */
    @Test
    public void testGetId() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getId");
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        final int expResult = idField.getInt(instance);
        final int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class JsonpMini.
     */
    @Test
    public void testGetName() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getName");
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        final String expResult = (String) nameField.get(instance);
        final String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnlock method, of class JsonpMini.
     */
    @Test
    public void testGetUnlock() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getUnlock");
        final Field unlockField = instance.getClass().getDeclaredField("unlock"); // NOI18N.
        unlockField.setAccessible(true);
        final Optional<String> expResult = (Optional<String>) unlockField.get(instance);
        final Optional<String> result = instance.getUnlock();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIcon method, of class JsonpMini.
     */
    @Test
    public void testGetIcon() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getIcon");
        final Field iconField = instance.getClass().getDeclaredField("icon"); // NOI18N.
        iconField.setAccessible(true);
        final URLReference expResult = (URLReference) iconField.get(instance);
        final URLReference result = instance.getIcon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrder method, of class JsonpMini.
     */
    @Test
    public void testGetOrder() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getOrder");
        final Field orderField = instance.getClass().getDeclaredField("order"); // NOI18N.
        orderField.setAccessible(true);
        final int expResult = orderField.getInt(instance);
        final int result = instance.getOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of getItemId method, of class JsonpMini.
     */
    @Test
    public void testGetItemId() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getItemId");
        final Field itemIdField = instance.getClass().getDeclaredField("itemId"); // NOI18N.
        itemIdField.setAccessible(true);
        final int expResult = itemIdField.getInt(instance);
        final int result = instance.getItemId();
        assertEquals(expResult, result);
    }
}
