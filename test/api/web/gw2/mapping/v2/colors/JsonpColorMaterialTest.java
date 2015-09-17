/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author FabriceB
 */
public class JsonpColorMaterialTest {

    public JsonpColorMaterialTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpColorMaterial instance;

    @Before
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

    @After
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
