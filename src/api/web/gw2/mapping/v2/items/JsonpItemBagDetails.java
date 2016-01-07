/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a bag details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemBagDetails extends JsonpItemDetails implements ItemBagDetails {

    @QuantityValue
    private int size = 0;
    private boolean noSellOrSort = false;

    public JsonpItemBagDetails() {
        super(ItemType.BAG);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isNoSellOrSort() {
        return noSellOrSort;
    }
}
