/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.skills;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.characters.id.skills.CharacterSkillPets;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a Ranger's equipped pets.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterSkillPets implements CharacterSkillPets {

    @SetValue
    @IdValue
    private Set<Integer> terrestrial = Collections.EMPTY_SET;
    @SetValue
    @IdValue
    private Set<Integer> aquatic = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterSkillPets() {
    }

    @Override
    public Set<Integer> getTerrestrial() {
        return terrestrial;
    }

    @Override
    public Set<Integer> getAquatic() {
        return aquatic;
    }
}
