/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.professions;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.professions.ProfessionWeaponSkill;
import api.web.gw2.mapping.v2.professions.ProfessionWeaponSkillSet;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of a profession weapon skill set.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpProfessionWeaponSkillSet implements ProfessionWeaponSkillSet {

    @SetValue
    private Set<ProfessionWeaponSkill> skills = Collections.EMPTY_SET;
    @OptionalValue
    @IdValue
    private OptionalInt specialization = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpProfessionWeaponSkillSet() {
    }

    @Override
    public Set<ProfessionWeaponSkill> getSkills() {
        return skills;
    }

    @Override
    public OptionalInt getSpecialization() {
        return specialization;
    }
}
