/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
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
import api.web.gw2.mapping.core.QuantityValue;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of the equipment.
 * @author Fabrice Bouyé
 */
public final class JsonpEquipment implements Equipment {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private EquipmentSlot slot = EquipmentSlot.UNKNOWN;
    @ListValue
    @IdValue
    private List<Integer> upgrades = Collections.emptyList();
    @ListValue
    @IdValue
    private List<Integer> infusions = Collections.emptyList();
    @IdValue
    private int skin = IdValue.DEFAULT_INTEGER_ID;
    @OptionalValue
    private Optional<EquipmentStats> stats = Optional.empty();
    @OptionalValue
    @EnumValue
    private Optional<EquipmentBinding> binding = Optional.empty();
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> boundTo = Optional.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt charges = OptionalInt.empty();

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
    public List<Integer> getUpgrades() {
        return upgrades;
    }

    @Override
    public List<Integer> getInfusions() {
        return infusions;
    }

    @Override
    public int getSkin() {
        return skin;
    }

    @Override
    public Optional<EquipmentStats> getStats() {
        return stats;
    }

    @Override
    public Optional<EquipmentBinding> getBinding() {
        return binding;
    }

    @Override
    public Optional<String> getBoundTo() {
        return boundTo;
    }

    @Override
    public OptionalInt getCharges() {
        return charges;
    }
}
