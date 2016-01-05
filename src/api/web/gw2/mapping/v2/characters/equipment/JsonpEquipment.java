/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters.equipment;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import java.util.List;
import java.util.Optional;

/**
 * Default JSON-P implementation of the equipment.
 * @author Fabrice Bouyé
 */
public final class JsonpEquipment implements Equipment {

    @IdValue
    private int id = -1;
    @EnumValue
    private EquipmentSlot slot = EquipmentSlot.UNKNOWN;
    @OptionalValue
    @ListValue
    @IdValue
    private Optional<List<Integer>> upgrades = Optional.empty();
    @OptionalValue
    @ListValue
    @IdValue
    private Optional<List<Integer>> infusions = Optional.empty();
    @IdValue
    private int skin = -1;

    /**
     * Creates a new empty instance.
     */
    public JsonpEquipment() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public EquipmentSlot getSlot() {
        return slot;
    }

    @Override
    public Optional<List<Integer>> getUpgrades() {
        return upgrades;
    }

    @Override
    public Optional<List<Integer>> getInfusions() {
        return infusions;
    }

    @Override
    public int getSkin() {
        return skin;
    }
}
