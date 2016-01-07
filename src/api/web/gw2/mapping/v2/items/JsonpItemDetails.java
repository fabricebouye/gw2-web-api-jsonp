/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.ImplementationSpecific;

/**
 * Base type for all item details implementations.
 * @author Fabrice Bouyé
 */
public abstract class JsonpItemDetails implements ItemDetails {

    @EnumValue
    @ImplementationSpecific
    private final ItemType itemType;

    /**
     * Creates a new instance.
     * @param itemType The item type.
     */
    public JsonpItemDetails(final ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public final ItemType getItemType() {
        return itemType;
    }
}
