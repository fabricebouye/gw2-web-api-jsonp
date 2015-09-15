/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.colors;

/**
 * Default implementation of a color material.
 * @author Fabrice Bouyé
 */
public final class JsonpColorMaterial implements ColorMaterial {

    private ColorRGB rgb = ColorRGB.EMPTY;
    private int brightness = 0;
    private double contrast = 0;
    private int hue = 0;
    private double saturation = 0;
    private double lightness = 0;

    /**
     * Creates a new empty instance.
     */
    public JsonpColorMaterial() {
    }

    @Override
    public int getBrightness() {
        return brightness;
    }

    @Override
    public double getContrast() {
        return contrast;
    }

    @Override
    public ColorRGB getRGB() {
        return rgb;
    }
    
    @Override
    public int getHue() {
        return hue;
    }

    @Override
    public double getSaturation() {
        return saturation;
    }

    @Override
    public double getLightness() {
        return lightness;
    }
}
