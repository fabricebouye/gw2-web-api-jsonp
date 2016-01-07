/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

/**
 * Default JSON-P implementation of an tool details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemToolDetails extends JsonpItemDetails implements ItemToolDetails {

    private ItemToolType type = ItemToolType.UNKNOWN;
    private int charges = -1;

    public JsonpItemToolDetails() {
        super(ItemType.TOOL);
    }

    @Override
    public ItemToolType getType() {
        return type;
    }

    @Override
    public int getCharges() {
        return charges;
    }
}
