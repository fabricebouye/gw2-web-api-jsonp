/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.colors;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.colors.ColorCategories;
import api.web.gw2.mapping.v2.colors.ColorDye;
import api.web.gw2.mapping.v2.colors.ColorMaterial;
import api.web.gw2.mapping.v2.colors.ColorRGB;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a dye.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpColorDye implements ColorDye {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    private ColorRGB baseRGB = ColorRGB.EMPTY;
    private ColorMaterial cloth = ColorMaterial.EMPTY;
    private ColorMaterial leather = ColorMaterial.EMPTY;
    private ColorMaterial metal = ColorMaterial.EMPTY;
    private ColorMaterial fur = ColorMaterial.EMPTY;
    @IdValue
    private int item = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    @SetValue
    private Set<ColorCategories> categories = Collections.EMPTY_SET;

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

    @Override
    public ColorMaterial getFur() {
        return fur;
    }

    @Override
    public int getItem() {
        return item;
    }

    @Override
    public Set<ColorCategories> getCategories() {
        return categories;
    }
}
