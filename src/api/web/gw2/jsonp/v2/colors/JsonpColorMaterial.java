/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.colors;

import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.colors.ColorMaterial;
import api.web.gw2.mapping.v2.colors.ColorRGB;

/**
 * Default JSON-P implementation of a color material.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpColorMaterial implements ColorMaterial {

    private ColorRGB rgb = ColorRGB.EMPTY;
    private int brightness = QuantityValue.DEFAULT;
    private double contrast = QuantityValue.DEFAULT;
    private int hue = QuantityValue.DEFAULT;
    private double saturation = QuantityValue.DEFAULT;
    private double lightness = QuantityValue.DEFAULT;

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
