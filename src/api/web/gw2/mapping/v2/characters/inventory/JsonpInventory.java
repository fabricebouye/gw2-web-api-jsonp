/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters.inventory;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of an inventory item.
 * @author Fabrice Bouyé
 */
public final class JsonpInventory implements Inventory {

    @IdValue
    private int id = -1;
    @QuantityValue
    private int count = 0;

    /**
     * Creates a new empty instance.
     */
    public JsonpInventory() {
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
