/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.colors;

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
public class JsonpColorDyeTest {

    public JsonpColorDyeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpColorDye instance;

    @Before
    public void setUp() throws Exception {
        instance = new JsonpColorDye();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 18);
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        nameField.set(instance, "Test color"); // NOI18N.
        final Field baseRGBField = instance.getClass().getDeclaredField("baseRGB"); // NOI18N.
        baseRGBField.setAccessible(true);
        baseRGBField.set(instance, new ColorRGB() {

            @Override
            public int getRed() {
                return 20;
            }

            @Override
            public int getGreen() {
                return 79;
            }

            @Override
            public int getBlue() {
                return 118;
            }
        });
        final Field clothField = instance.getClass().getDeclaredField("cloth"); // NOI18N.
        clothField.setAccessible(true);
        final Field leatherField = instance.getClass().getDeclaredField("leather"); // NOI18N.
        leatherField.setAccessible(true);
        final Field metalField = instance.getClass().getDeclaredField("metal"); // NOI18N.
        metalField.setAccessible(true);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpColorDye.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId");
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        final int expResult = idField.getInt(instance);
        final int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class JsonpColorDye.
     */
    @Test
    public void testGetName() throws Exception {
        System.out.println("getName");
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        final String expResult = (String) nameField.get(instance);
        final String result = instance.getName();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBaseRGB method, of class JsonpColorDye.
     */
    @Test
    public void testGetBaseRGB() throws Exception {
        System.out.println("getBaseRGB");
        final Field baseRGBField = instance.getClass().getDeclaredField("baseRGB"); // NOI18N.
        baseRGBField.setAccessible(true);
        final ColorRGB expResult = (ColorRGB) baseRGBField.get(instance);
        final ColorRGB result = instance.getBaseRGB();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCloth method, of class JsonpColorDye.
     */
    @Test
    public void testGetCloth() throws Exception {
        System.out.println("getCloth");
        final Field clothField = instance.getClass().getDeclaredField("cloth"); // NOI18N.
        clothField.setAccessible(true);
        final ColorMaterial expResult = (ColorMaterial) clothField.get(instance);
        final ColorMaterial result = instance.getCloth();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLeather method, of class JsonpColorDye.
     */
    @Test
    public void testGetLeather() throws Exception {
        System.out.println("getLeather");
        final Field leatherField = instance.getClass().getDeclaredField("leather"); // NOI18N.
        leatherField.setAccessible(true);
        final ColorMaterial expResult = (ColorMaterial) leatherField.get(instance);
        final ColorMaterial result = instance.getLeather();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMetal method, of class JsonpColorDye.
     */
    @Test
    public void testGetMetal() throws Exception {
        System.out.println("getMetal");
        final Field metalField = instance.getClass().getDeclaredField("metal"); // NOI18N.
        metalField.setAccessible(true);
        final ColorMaterial expResult = (ColorMaterial) metalField.get(instance);
        final ColorMaterial result = instance.getMetal();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

}
