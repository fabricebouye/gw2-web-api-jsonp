/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.recipes;

import api.web.gw2.mapping.core.CraftingLevelValue;
import api.web.gw2.mapping.core.DurationValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.recipes.Recipe;
import api.web.gw2.mapping.v2.recipes.RecipeCraftingDiscipline;
import api.web.gw2.mapping.v2.recipes.RecipeFlag;
import api.web.gw2.mapping.v2.recipes.RecipeIngredient;
import api.web.gw2.mapping.v2.recipes.RecipeType;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a recipe.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpRecipe implements Recipe {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private RecipeType type = RecipeType.UNKNOWN;
    @IdValue
    private int outputItemId = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int outputItemCount = QuantityValue.DEFAULT;
    @DurationValue(flavor = DurationValue.Flavor.MILLIS)
    private Duration timeToCraftMs = DurationValue.DEFAULT;
    @SetValue
    @EnumValue
    private Set<RecipeCraftingDiscipline> disciplines = Collections.EMPTY_SET;
    @CraftingLevelValue
    private int minRating = CraftingLevelValue.MIN_LEVEL;
    @SetValue
    @EnumValue
    private Set<RecipeFlag> flags = Collections.EMPTY_SET;
    @SetValue
    private Set<RecipeIngredient> ingredients = Collections.EMPTY_SET;
    private String chatLink = LocalizedResource.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpRecipe() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public RecipeType getType() {
        return type;
    }

    @Override
    public int getOutputItemId() {
        return outputItemId;
    }

    @Override
    public int getOutputItemCount() {
        return outputItemCount;
    }

    @Override
    public Duration getTimeToCraftMs() {
        return timeToCraftMs;
    }

    @Override
    public Set<RecipeCraftingDiscipline> getDisciplines() {
        return disciplines;
    }

    @Override
    public int getMinRating() {
        return minRating;
    }

    @Override
    public Set<RecipeFlag> getFlags() {
        return flags;
    }

    @Override
    public Set<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getChatLink() {
        return chatLink;
    }
}
