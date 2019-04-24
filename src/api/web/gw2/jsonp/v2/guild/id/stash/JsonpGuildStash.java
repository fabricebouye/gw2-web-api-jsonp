/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.guild.id.stash;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.guild.id.stash.GuildStash;
import api.web.gw2.mapping.v2.guild.id.stash.GuildStashInventory;

import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of an guild stash.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildStash implements GuildStash {

    @IdValue
    private int upgradeId = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int size = QuantityValue.DEFAULT;
    @CoinValue
    private CoinAmount coins = CoinAmount.ZERO;
    private String note = LocalizedResource.DEFAULT;
    @ListValue
    private List<GuildStashInventory> inventory = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuildStash() {
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
        return note;
    }

    @Override
    public List<GuildStashInventory> getInventory() {
        return inventory;
    }
}
