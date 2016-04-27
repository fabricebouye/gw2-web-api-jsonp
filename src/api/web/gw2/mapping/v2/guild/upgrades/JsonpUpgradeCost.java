/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.upgrades;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a guild upgrade cost.
 * @author Fabrice Bouyé
 */
public final class JsonpUpgradeCost implements UpgradeCost {

    @EnumValue
    private UpgradeCostType type = UpgradeCostType.UNKNOWN;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;
    @IdValue
    @OptionalValue
    private OptionalInt itemId = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpUpgradeCost() {
    }

    @Override
    public UpgradeCostType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public OptionalInt getItemId() {
        return itemId;
    }
}
