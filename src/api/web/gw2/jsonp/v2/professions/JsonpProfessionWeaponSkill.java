/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.professions;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.v2.professions.ProfessionElementalistAttunement;
import api.web.gw2.mapping.v2.professions.ProfessionWeaponSkill;
import api.web.gw2.mapping.v2.professions.ProfessionWeaponSlot;
import api.web.gw2.mapping.v2.professions.ProfessionWeaponType;

import java.util.Optional;

/**
 * Default JSON-P implementation of a profession weapon skill.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpProfessionWeaponSkill implements ProfessionWeaponSkill {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private ProfessionWeaponSlot slot = ProfessionWeaponSlot.UNKNOWN;
    @OptionalValue
    @EnumValue
    private Optional<ProfessionWeaponType> offhand = Optional.empty();
    @OptionalValue
    @EnumValue
    private Optional<ProfessionElementalistAttunement> attunement = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpProfessionWeaponSkill() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public ProfessionWeaponSlot getSlot() {
        return slot;
    }

    @Override
    public Optional<ProfessionWeaponType> getOffhand() {
        return offhand;
    }

    @Override
    public Optional<ProfessionElementalistAttunement> getAttunement() {
        return attunement;
    }
}
