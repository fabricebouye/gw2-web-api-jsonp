/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.bank;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.characters.inventory.InventoryBinding;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of an bank slot.
 * @author Fabrice Bouyé
 */
public final class JsonpBankSlot implements BankSlot {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;
    @IdValue
    @OptionalValue
    private OptionalInt skin = OptionalInt.empty();
    @ListValue
    private List<Integer> upgrades = Collections.emptyList();
    @ListValue
    private List<Integer> infusions = Collections.emptyList();
    @OptionalValue
    @EnumValue
    private Optional<InventoryBinding> binding = Optional.empty();
    @IdValue(flavor = IdValue.Flavor.STRING)
    @OptionalValue
    private Optional<String> boundTo = Optional.empty();
    @QuantityValue
    @OptionalValue
    private OptionalInt charges = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpBankSlot() {
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
    public Optional<InventoryBinding> getBinding() {
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
