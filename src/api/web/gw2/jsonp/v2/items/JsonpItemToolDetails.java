/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.items;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.items.ItemToolDetails;
import api.web.gw2.mapping.v2.items.ItemToolType;
import api.web.gw2.mapping.v2.items.ItemType;

/**
 * Default JSON-P implementation of an tool details.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpItemToolDetails extends JsonpItemDetails implements ItemToolDetails {
    @EnumValue
    private ItemToolType type = ItemToolType.UNKNOWN;
    @QuantityValue
    private int charges = QuantityValue.DEFAULT;

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
