/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.materials;

import java.lang.reflect.Field;
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
public final class JsonpMaterialTest {

    public JsonpMaterialTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpMaterial instance;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        instance = new JsonpMaterial();
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

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JsonpMaterial.
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
     * Test of getCategory method, of class JsonpMaterial.
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
     * Test of getCount method, of class JsonpMaterial.
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
