/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters;

import api.web.gw2.mapping.v2.recipes.RecipeCraftingDiscipline;

/**
 * Default JSON-P implementation of a character's crafting info.
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterCrafting implements CharacterCrafting {

    private RecipeCraftingDiscipline discipline = RecipeCraftingDiscipline.UNKNOWN;
    private int level = 0;
    private boolean active = false;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterCrafting() {
    }

    @Override
    public RecipeCraftingDiscipline getDiscipline() {
        return discipline;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public boolean isActive() {
        return active;
    }
}
