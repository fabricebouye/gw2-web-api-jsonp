/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.commerce.prices;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.v2.commerce.prices.Price;
import api.web.gw2.mapping.v2.commerce.prices.PriceOrder;

/**
 * Default JSON-P implementation of a price.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPrice implements Price {
    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    private PriceOrder buys = PriceOrder.EMPTY;
    private PriceOrder sells = PriceOrder.EMPTY;
    private boolean whitelisted = false;

    /**
     * Creates a new empty instance.
     */
    public JsonpPrice() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public PriceOrder getBuys() {
        return buys;
    }

    @Override
    public PriceOrder getSells() {
        return sells;
    }

    @Override
    public boolean isWhitelisted() {
        return whitelisted;
    }
}
