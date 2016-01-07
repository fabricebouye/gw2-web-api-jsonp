/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Default JSON-P implementation of an item infix upgrade.
 * @author Fabrice Bouyé
 */
public final class JsonpItemInfixUpgrade implements ItemInfixUpgrade {

    private List<ItemInfixUpgradeAttributeValue> attributes = Collections.EMPTY_LIST;
    private Optional<ItemBuff> buff = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpItemInfixUpgrade() {
    }

    @Override
    public List<ItemInfixUpgradeAttributeValue> getAttributes() {
        return attributes;
    }

    @Override
    public Optional<ItemBuff> getBuff() {
        return buff;
    }
}
