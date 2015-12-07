/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.materials;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
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
public final class JsonpMaterialStorageTest {

    public JsonpMaterialStorageTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpMaterialStorage instance;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        instance = new JsonpMaterialStorage();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 1);
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        nameField.set(instance, "Foo"); // NOI18N.
        final Field itemsField = instance.getClass().getDeclaredField("items"); // NOI18N.
        itemsField.setAccessible(true);
        itemsField.set(instance, Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 3, 4, 5))));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JsonpMaterialStorage.
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
     * Test of getName method, of class JsonpMaterialStorage.
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
     * Test of getItems method, of class JsonpMaterialStorage.
     */
    @Test
    public void testGetItems() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getItems");
        final Field itemsField = instance.getClass().getDeclaredField("items"); // NOI18N.
        itemsField.setAccessible(true);
        final Set<Integer> expResult = (Set<Integer>) itemsField.get(instance);
        final Set<Integer> result = instance.getItems();
        assertEquals(expResult, result);
    }

}
