/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.commerce.listings;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a listing
 * @author Fabrice Bouyé
 */
public final class JsonptListing implements Listing {

    @QuantityValue
    private int listing = QuantityValue.DEFAULT;
    @CoinValue
    private CoinAmount unitPrice = CoinAmount.ZERO;
    @QuantityValue
    private int quantity = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonptListing() {
    }

    @Override
    public int getListings() {
        return listing;
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
