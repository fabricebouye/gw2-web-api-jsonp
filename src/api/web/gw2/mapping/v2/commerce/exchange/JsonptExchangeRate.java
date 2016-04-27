/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.commerce.exchange;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of an exchange rate.
 * @author Fabrice Bouyé
 */
public final class JsonptExchangeRate implements ExchangeRate {

    @CoinValue
    private CoinAmount coinsPerGem = CoinAmount.ZERO;
    @QuantityValue
    private int quantity = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonptExchangeRate() {
    }

    @Override
    public CoinAmount getCoinsPerGem() {
        return coinsPerGem;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
