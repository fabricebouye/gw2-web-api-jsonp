/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.inventory;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.characters.inventory.InventoryBinding;

/**
 * Default JSON-P implementation of a shared inventory slot.
 * @author Fabrice Bouyé
 * @see InventoryBag
 */
public final class JsonpSharedInventory implements SharedInventory {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;
    @EnumValue
    private InventoryBinding binding = InventoryBinding.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpSharedInventory() {
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
