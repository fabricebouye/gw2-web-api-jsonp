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
 * Default JSON-P implementation of a container details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemContainerDetails extends JsonpItemDetails implements ItemContainerDetails {

    @EnumValue
    private ItemContainerType type = ItemContainerType.UNKNOWN;

    public JsonpItemContainerDetails() {
        super(ItemType.CONTAINER);
    }

    @Override
    public ItemContainerType getType() {
        return type;
    }
}
