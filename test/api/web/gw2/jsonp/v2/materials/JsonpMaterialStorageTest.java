/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.materials;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpMaterialStorageTest {

    public JsonpMaterialStorageTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpMaterialStorage instance;

    @BeforeEach
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
        itemsField.set(instance, Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(1, 2, 3, 4, 5))));
    }

    @AfterEach
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
