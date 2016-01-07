/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.recipes;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a recipe ingredient.
 * @author Fabrice Bouyé
 */
public final class JsonpRecipeIngredient implements RecipeIngredient {
    @IdValue
    private int itemId = -1;
    @QuantityValue
    private int count = 0;

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
