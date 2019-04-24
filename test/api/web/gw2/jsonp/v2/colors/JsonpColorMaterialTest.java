/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.colors;

import api.web.gw2.mapping.v2.colors.ColorRGB;
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
public class JsonpColorMaterialTest {

    public JsonpColorMaterialTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpColorMaterial instance;

    @BeforeEach
    public void setUp() throws Exception {
        instance = new JsonpColorMaterial();
        final Field rgbField = instance.getClass().getDeclaredField("rgb"); // NOI18N.
        rgbField.setAccessible(true);
        rgbField.set(instance, new ColorRGB() {

            @Override
            public int getRed() {
                return 10;
            }

            @Override
            public int getGreen() {
                return 87;
            }

            @Override
            public int getBlue() {
                return 189;
            }
        });
        final Field brightnessField = instance.getClass().getDeclaredField("brightness"); // NOI18N.
        brightnessField.setAccessible(true);
        brightnessField.setInt(instance, 80);
        final Field contrastField = instance.getClass().getDeclaredField("contrast"); // NOI18N.
        contrastField.setAccessible(true);
        contrastField.setDouble(instance, 25.5);
        final Field hueField = instance.getClass().getDeclaredField("hue"); // NOI18N.
        hueField.setAccessible(true);
        hueField.setInt(instance, 126);
        final Field saturationField = instance.getClass().getDeclaredField("saturation"); // NOI18N.
        saturationField.setAccessible(true);
        saturationField.setDouble(instance, 78.48);
        final Field lightnessField = instance.getClass().getDeclaredField("lightness"); // NOI18N.
        lightnessField.setAccessible(true);
        lightnessField.setDouble(instance, 99.31);
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getBrightness method, of class JsonpColorMaterial.
     */
    @Test
    public void testGetBrightness() throws Exception {
        System.out.println("getBrightness");
        final Field brightnessField = instance.getClass().getDeclaredField("brightness"); // NOI18N.
        brightnessField.setAccessible(true);
        final int expResult = brightnessField.getInt(instance);
        final int result = instance.getBrightness();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContrast method, of class JsonpColorMaterial.
     */
    @Test
    public void testGetContrast() throws Exception {
        System.out.println("getContrast");
        final Field contrastField = instance.getClass().getDeclaredField("contrast"); // NOI18N.
        contrastField.setAccessible(true);
        final double expResult = contrastField.getDouble(instance);
        final double result = instance.getContrast();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getRGB method, of class JsonpColorMaterial.
     */
    @Test
    public void testGetRGB() throws Exception {
        System.out.println("getRGB");
        final Field rgbField = instance.getClass().getDeclaredField("rgb"); // NOI18N.
        rgbField.setAccessible(true);
        final ColorRGB expResult = (ColorRGB) rgbField.get(instance);
        final ColorRGB result = instance.getRGB();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHue method, of class JsonpColorMaterial.
     */
    @Test
    public void testGetHue() throws Exception {
        System.out.println("getHue");
        final Field hueField = instance.getClass().getDeclaredField("hue"); // NOI18N.
        hueField.setAccessible(true);
        final int expResult = hueField.getInt(instance);
        final int result = instance.getHue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSaturation method, of class JsonpColorMaterial.
     */
    @Test
    public void testGetSaturation() throws Exception {
        System.out.println("getSaturation");
        final Field saturationField = instance.getClass().getDeclaredField("saturation"); // NOI18N.
        saturationField.setAccessible(true);
        final double expResult = saturationField.getDouble(instance);
        final double result = instance.getSaturation();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLightness method, of class JsonpColorMaterial.
     */
    @Test
    public void testGetLightness() throws Exception {
        System.out.println("getLightness");
        final Field lightnessField = instance.getClass().getDeclaredField("lightness"); // NOI18N.
        lightnessField.setAccessible(true);
        final double expResult = lightnessField.getDouble(instance);
        final double result = instance.getLightness();
        assertEquals(expResult, result, 0.0);
    }

}
