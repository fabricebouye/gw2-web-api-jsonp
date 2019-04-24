/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.commerce.prices;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.commerce.prices.PriceOrder;

/**
 * Default JSON-P implementation of an order.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPriceOrder implements PriceOrder {

    @CoinValue
    private CoinAmount unitPrice = CoinAmount.ZERO;
    @QuantityValue
    private int quantity = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpPriceOrder() {
    }

    @Override
    public CoinAmount getUnitPrice() {
        return unitPrice;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
