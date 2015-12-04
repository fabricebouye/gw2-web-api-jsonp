/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.bank;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of an bank slot.
 * @author Fabrice Bouyé
 */
public final class JsonpBankSlot implements BankSlot {

    @IdValue
    private int id = -1;
    @QuantityValue
    private int count = 0;
    @IdValue
    @OptionalValue
    private OptionalInt skin = OptionalInt.empty();
    @OptionalValue
    @ListValue
    private Optional<List<Integer>> upgrades = Optional.empty();
    @OptionalValue
    @ListValue
    private Optional<List<Integer>> infusions = Optional.empty();

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
    public Optional<List<Integer>> getUpgrades() {
        return upgrades;
    }

    @Override
    public Optional<List<Integer>> getInfusions() {
        return infusions;
    }
}
