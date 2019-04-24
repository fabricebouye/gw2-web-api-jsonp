/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.guild.id.stash;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.guild.id.stash.GuildStashInventory;

/**
 * Default JSON-P implementation of an guild stash's inventory.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildStashInventory implements GuildStashInventory {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;

    /**
     * Create a new empty instance.
     */
    public JsonpGuildStashInventory() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCount() {
        return count;
    }
}
