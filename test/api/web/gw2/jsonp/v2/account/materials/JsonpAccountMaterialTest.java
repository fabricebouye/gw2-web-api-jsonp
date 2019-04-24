/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.account.materials;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpAccountMaterialTest {

    public JsonpAccountMaterialTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpAccountMaterial instance;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        instance = new JsonpAccountMaterial();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 1);
        final Field categoryField = instance.getClass().getDeclaredField("category"); // NOI18N.
        categoryField.setAccessible(true);
        categoryField.setInt(instance, 5);
        final Field countField = instance.getClass().getDeclaredField("count"); // NOI18N.
        countField.setAccessible(true);
        countField.setInt(instance, 250);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JsonpAccountMaterial.
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
     * Test of getCategory method, of class JsonpAccountMaterial.
     */
    @Test
    public void testGetCategory() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getCategory");
        final Field categoryField = instance.getClass().getDeclaredField("category"); // NOI18N.
        categoryField.setAccessible(true);
        final int expResult = categoryField.getInt(instance);
        final int result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCount method, of class JsonpAccountMaterial.
     */
    @Test
    public void testGetCount() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getCount");
        final Field countField = instance.getClass().getDeclaredField("count"); // NOI18N.
        countField.setAccessible(true);
        final int expResult = countField.getInt(instance);
        final int result = instance.getCount();
        assertEquals(expResult, result);
    }
}
