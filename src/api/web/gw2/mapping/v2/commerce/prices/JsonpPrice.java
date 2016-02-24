/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.commerce.prices;

import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a price.
 * @author Fabrice Bouyé
 */
public final class JsonpPrice implements Price {
    @IdValue
    private int id = -1;    
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
