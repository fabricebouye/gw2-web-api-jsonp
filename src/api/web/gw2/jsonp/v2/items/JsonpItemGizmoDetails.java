/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.items;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.v2.items.ItemGizmoDetails;
import api.web.gw2.mapping.v2.items.ItemGizmoType;
import api.web.gw2.mapping.v2.items.ItemType;

/**
 * Default JSON-P implementation for an item gizmo details.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpItemGizmoDetails extends JsonpItemDetails implements ItemGizmoDetails {

    @EnumValue
    private ItemGizmoType type = ItemGizmoType.UNKNOWN;

    public JsonpItemGizmoDetails() {
        super(ItemType.GIZMO);
    }

    @Override
    public ItemGizmoType getType() {
        return type;
    }
}
