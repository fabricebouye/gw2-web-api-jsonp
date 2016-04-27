/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.colors;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;

/**
 * Default JSON-P implementation of a dye.
 * @author Fabrice Bouyé
 */
public final class JsonpColorDye implements ColorDye {
    @IdValue
    private int id = -1;
    @LocalizedResource
    private String name = ""; // NOI18N.
    private ColorRGB baseRGB = ColorRGB.EMPTY;
    private ColorMaterial cloth = ColorMaterial.EMPTY;
    private ColorMaterial leather = ColorMaterial.EMPTY;
    private ColorMaterial metal = ColorMaterial.EMPTY;

    /**
     * Creates a new empty instance.
     */
    public JsonpColorDye() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ColorRGB getBaseRGB() {
        return baseRGB;
    }

    @Override
    public ColorMaterial getCloth() {
        return cloth;
    }

    @Override
    public ColorMaterial getLeather() {
        return leather;
    }

    @Override
    public ColorMaterial getMetal() {
        return metal;
    }
}
