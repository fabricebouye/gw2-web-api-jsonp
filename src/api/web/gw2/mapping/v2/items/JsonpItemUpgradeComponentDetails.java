/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of an item upgrade component details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemUpgradeComponentDetails extends JsonpItemDetails implements ItemUpgradeComponentDetails {

    @EnumValue
    private ItemUpgradeComponentType type = ItemUpgradeComponentType.UNKNOWN;
    @SetValue
    @EnumValue
    private Set<ItemUpgradeComponentFlag> flags = Collections.EMPTY_SET;
    @SetValue
    private Set<ItemInfusionSlotFlag> infusionUpgradeFlags = Collections.EMPTY_SET;
    @LocalizedResource
    private String suffix = "";
    private ItemInfixUpgrade infixUpgrade;
    @OptionalValue
    @ListValue
    @LocalizedResource
    private Optional<List<String>> bonuses = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpItemUpgradeComponentDetails() {
        super(ItemType.UPGRADE_COMPONENT);
    }

    @Override
    public ItemUpgradeComponentType getType() {
        return type;
    }

    @Override
    public Set<ItemUpgradeComponentFlag> getFlags() {
        return flags;
    }

    @Override
    public Set<ItemInfusionSlotFlag> getInfusionUpgradeFlags() {
        return infusionUpgradeFlags;
    }

    @Override
    public String getSuffix() {
        return suffix;
    }

    @Override
    public ItemInfixUpgrade getInfixUpgrade() {
        return infixUpgrade;
    }

    @Override
    public Optional<List<String>> getBonuses() {
        return bonuses;
    }
}
