/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.equipment;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.characters.id.equipment.CharacterEquipment;
import api.web.gw2.mapping.v2.characters.id.equipment.CharacterEquipmentBinding;
import api.web.gw2.mapping.v2.characters.id.equipment.CharacterEquipmentSlot;
import api.web.gw2.mapping.v2.characters.id.equipment.CharacterEquipmentStats;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of the equipment.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterEquipment implements CharacterEquipment {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private CharacterEquipmentSlot slot = CharacterEquipmentSlot.UNKNOWN;
    @ListValue
    @IdValue
    private List<Integer> upgrades = Collections.EMPTY_LIST;
    @ListValue
    @IdValue
    private List<Integer> infusions = Collections.EMPTY_LIST;
    @IdValue
    private int skin = IdValue.DEFAULT_INTEGER_ID;
    @OptionalValue
    private Optional<CharacterEquipmentStats> stats = Optional.empty();
    @OptionalValue
    @EnumValue
    private Optional<CharacterEquipmentBinding> binding = Optional.empty();
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> boundTo = Optional.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt charges = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterEquipment() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public CharacterEquipmentSlot getSlot() {
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
    public Optional<CharacterEquipmentStats> getStats() {
        return stats;
    }

    @Override
    public Optional<CharacterEquipmentBinding> getBinding() {
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
