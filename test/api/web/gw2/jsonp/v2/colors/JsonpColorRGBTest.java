/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.colors;

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
public class JsonpColorRGBTest {

    public JsonpColorRGBTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpColorRGB instance;

    @BeforeEach
    public void setUp() throws Exception {
        instance = new JsonpColorRGB();
        final Field rgbField = instance.getClass().getDeclaredField("rgb"); // NI18N.
        rgbField.setAccessible(true);
        final int[] rgb = (int[]) rgbField.get(instance);
        rgb[0] = 88;
        rgb[1] = 97;
        rgb[2] = 200;
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getRed method, of class JsonpColorRGB.
     */
    @Test
    public void testGetRed() throws Exception {
        System.out.println("getRed");
        final Field rgbField = instance.getClass().getDeclaredField("rgb"); // NI18N.
        rgbField.setAccessible(true);
        final int[] rgb = (int[]) rgbField.get(instance);
        final int expResult = rgb[0];
        final int result = instance.getRed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGreen method, of class JsonpColorRGB.
     */
    @Test
    public void testGetGreen() throws Exception {
        System.out.println("getGreen");
        final Field rgbField = instance.getClass().getDeclaredField("rgb"); // NI18N.
        rgbField.setAccessible(true);
        final int[] rgb = (int[]) rgbField.get(instance);
        final int expResult = rgb[1];
        final int result = instance.getGreen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBlue method, of class JsonpColorRGB.
     */
    @Test
    public void testGetBlue() throws Exception {
        System.out.println("getBlue");
        final Field rgbField = instance.getClass().getDeclaredField("rgb"); // NI18N.
        rgbField.setAccessible(true);
        final int[] rgb = (int[]) rgbField.get(instance);
        final int expResult = rgb[2];
        final int result = instance.getBlue();
        assertEquals(expResult, result);
    }

}
