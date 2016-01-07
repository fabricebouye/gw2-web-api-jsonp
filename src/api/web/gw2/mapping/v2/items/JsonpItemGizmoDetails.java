/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

/**
 * Default JSON-P implementation for an item gizmo details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemGizmoDetails extends JsonpItemDetails implements ItemGizmoDetails {

    private ItemGizmoType type = ItemGizmoType.UNKNOWN;

    public JsonpItemGizmoDetails() {
        super(ItemType.GIZMO);
    }

    @Override
    public ItemGizmoType getType() {
        return type;
    }
}
