/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.recipes;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.recipes.RecipeIngredient;

/**
 * Default JSON-P implementation of a recipe ingredient.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpRecipeIngredient implements RecipeIngredient {
    @IdValue
    private int itemId = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpRecipeIngredient() {
    }

    @Override
    public int getItemId() {
        return itemId;
    }

    @Override
    public int getCount() {
        return count;
    }
}
