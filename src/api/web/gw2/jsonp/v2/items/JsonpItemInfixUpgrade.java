/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.items;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.v2.items.ItemBuff;
import api.web.gw2.mapping.v2.items.ItemInfixUpgrade;
import api.web.gw2.mapping.v2.items.ItemInfixUpgradeAttributeValue;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Default JSON-P implementation of an item infix upgrade.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpItemInfixUpgrade implements ItemInfixUpgrade {
    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @ListValue
    private List<ItemInfixUpgradeAttributeValue> attributes = Collections.EMPTY_LIST;
    @OptionalValue
    private Optional<ItemBuff> buff = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpItemInfixUpgrade() {
    }

    @Override
    public int getId() {
        return id;
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
