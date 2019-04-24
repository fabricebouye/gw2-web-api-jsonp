/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.equipment_pvp;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.v2.characters.id.equipment_pvp.CharacterEquipmentPvP;

import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of a character's PvP equipment.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterEquipmentPvP implements CharacterEquipmentPvP {

    @IdValue
    private int amulet = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    private int rune = IdValue.DEFAULT_INTEGER_ID;
    @ListValue
    @IdValue
    private List<Integer> sigils = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterEquipmentPvP() {
    }

    @Override
    public int getAmulet() {
        return amulet;
    }

    @Override
    public int getRune() {
        return rune;
    }

    @Override
    public List<Integer> getSigils() {
        return sigils;
    }
}
