/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.commerce.delivery;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.ListValue;
import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of a BLTC delivery.
 * @author Fabrice Bouyé
 */
public final class JsonpDelivery implements Delivery {

    @CoinValue
    private CoinAmount coins = CoinAmount.ZERO;
    @ListValue
    private List<DeliveryItem> items = Collections.EMPTY_LIST;

    /**
    * Creates a new empty instance.
    */
    public JsonpDelivery() {
    }        
    
    @Override
    public CoinAmount getCoins() {
        return coins;
    }

    @Override
    public List<DeliveryItem> getItems() {
        return items;
    }
    
}
