/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

/**
 * Default JSON-P implementation of an item infix upgrade attribute value.
 * @author Fabrice Bouyé
 */
public final class JsonpItemInfixUpgradeAttributeValue implements ItemInfixUpgradeAttributeValue {

    private ItemInfixUpgradeAttribute attribute = ItemInfixUpgradeAttribute.UNKNOWN;
    private int modifier = 0;

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
