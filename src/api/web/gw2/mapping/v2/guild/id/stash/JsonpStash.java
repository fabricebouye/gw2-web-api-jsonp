/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.stash;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.QuantityValue;
import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of an guild stash.
 * @author Fabrice Bouyé
 */
public final class JsonpStash implements Stash {

    @IdValue
    private int upgradeId = -1;
    @QuantityValue
    private int size = 0;
    @CoinValue
    private CoinAmount coins = CoinAmount.ZERO;
    private String notes = "";
    @ListValue
    private List<StashInventory> inventory = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpStash() {
    }

    @Override
    public int getUpgradeId() {
        return upgradeId;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public CoinAmount getCoins() {
        return coins;
    }

    @Override
    public String getNote() {
        return notes;
    }

    @Override
    public List<StashInventory> getInventory() {
        return inventory;
    }
}
