/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.wvw.abilities;

import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.wvw.abilities.WvwAbilityRank;

/**
 * Default JSON-P implementation of an ability rank.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpWvwAbilityRank implements WvwAbilityRank {

    @QuantityValue
    private int cost = QuantityValue.DEFAULT;
    @LocalizedResource
    private String effect = LocalizedResource.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpWvwAbilityRank() {
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getEffect() {
        return effect;
    }
}
