/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of an item infix upgrade attribute value.
 * @author Fabrice Bouyé
 */
public final class JsonpItemInfixUpgradeAttributeValue implements ItemInfixUpgradeAttributeValue {

    @EnumValue
    private ItemInfixUpgradeAttribute attribute = ItemInfixUpgradeAttribute.UNKNOWN;
    @QuantityValue
    private int modifier = QuantityValue.DEFAULT;

    public JsonpItemInfixUpgradeAttributeValue() {
    }

    @Override
    public ItemInfixUpgradeAttribute getAttribute() {
        return attribute;
    }

    @Override
    public int getModifier() {
        return modifier;
    }

}
