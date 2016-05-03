/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.professions;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a profession weapon skill.
 * @author Fabrice Bouyé
 */
public final class JsonpProfessionWeaponSkill implements ProfessionWeaponSkill {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private ProfessionWeaponSlot slot = ProfessionWeaponSlot.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpProfessionWeaponSkill() {
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public ProfessionWeaponSlot getSlot() {
        return slot;
    }
}
