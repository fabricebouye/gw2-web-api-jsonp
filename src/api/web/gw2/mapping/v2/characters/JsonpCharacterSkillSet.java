/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a character's skill set.
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterSkillSet implements CharacterSkillSet {

    @IdValue
    private int heal = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    private int elite = IdValue.DEFAULT_INTEGER_ID;
    @SetValue
    @IdValue
    private Set<Integer> utilities = Collections.EMPTY_SET;
    @SetValue
    @IdValue
    private Set<Integer> legends = Collections.EMPTY_SET;
    @OptionalValue
    private Optional<CharacterPets> pets = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterSkillSet() {
    }

    @Override
    public int getHeal() {
        return heal;
    }

    @Override
    public int getElite() {
        return elite;
    }

    @Override
    public Set<Integer> getUtilities() {
        return utilities;
    }

    @Override
    public Set<Integer> getLegends() {
        return legends;
    }

    @Override
    public Optional<CharacterPets> getPets() {
        return pets;
    }
}
