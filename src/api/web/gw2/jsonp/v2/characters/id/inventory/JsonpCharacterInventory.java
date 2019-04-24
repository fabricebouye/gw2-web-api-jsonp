/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.inventory;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.characters.id.equipment.CharacterEquipmentStats;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventory;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventoryBinding;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of an inventory item.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterInventory implements CharacterInventory {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;
    @OptionalValue
    @IdValue
    private OptionalInt skin = OptionalInt.empty();
    @ListValue
    @IdValue
    private List<Integer> upgrades = Collections.EMPTY_LIST;
    @ListValue
    @IdValue
    private List<Integer> infusions = Collections.EMPTY_LIST;
    @OptionalValue
    @EnumValue
    private Optional<CharacterInventoryBinding> binding = Optional.empty();
    @OptionalValue
    private Optional<String> boundTo = Optional.empty();
    @OptionalValue
    @IdValue
    private OptionalInt infixUpgradeId = OptionalInt.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt charges = OptionalInt.empty();
    @OptionalValue
    private Optional<CharacterEquipmentStats> stats = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterInventory() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public OptionalInt getSkin() {
        return skin;
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
    public Optional<CharacterInventoryBinding> getBinding() {
        return binding;
    }

    @Override
    public Optional<String> getBoundTo() {
        return boundTo;
    }

    @Override
    public OptionalInt getInfixUpgradeId() {
        return infixUpgradeId;
    }

    @Override
    public OptionalInt getCharges() {
        return charges;
    }

    @Override
    public Optional<CharacterEquipmentStats> getStats() {
        return stats;
    }
}
