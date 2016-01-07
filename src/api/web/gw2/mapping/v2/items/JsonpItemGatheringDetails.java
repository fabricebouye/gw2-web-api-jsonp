/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.EnumValue;

/**
 * Default JSON-P implementation of a gathering tool details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemGatheringDetails extends JsonpItemDetails implements ItemGatheringDetails {

    @EnumValue
    private ItemGatheringType type = ItemGatheringType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpItemGatheringDetails() {
        super(ItemType.GATHERING);
    }

    @Override
    public ItemGatheringType getType() {
        return type;
    }
}
