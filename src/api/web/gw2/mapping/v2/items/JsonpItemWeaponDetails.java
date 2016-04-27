/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Default JSON-P implementation of an item weapon detail.
 * @author Fabrice Bouyé
 */
public final class JsonpItemWeaponDetails extends JsonpItemDetails implements ItemWeaponDetails {

    @EnumValue
    private ItemWeaponType type = ItemWeaponType.UNKNOWN;
    @EnumValue
    private ItemWeaponDamageType damageType = ItemWeaponDamageType.UNKNOWN;
    @QuantityValue
    private int minPower = QuantityValue.DEFAULT;
    @QuantityValue
    private int maxPower = QuantityValue.DEFAULT;
    @QuantityValue
    private int defense = QuantityValue.DEFAULT;
    @ListValue
    private List<ItemInfusionSlot> infusionSlots = Collections.EMPTY_LIST;
    @OptionalValue
    private Optional<ItemInfixUpgrade> infixUpgrade = Optional.empty();
    @IdValue
    private int suffixItemId = IdValue.DEFAULT_INTEGER_ID;
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String secondarySuffixItemId = IdValue.DEFAULT_STRING_ID;

    /**
     * Creates a new empty instance.
     */
    public JsonpItemWeaponDetails() {
        super(ItemType.WEAPON);
    }

    @Override
    public ItemWeaponType getType() {
        return type;
    }

    @Override
    public ItemWeaponDamageType getDamageType() {
        return damageType;
    }

    @Override
    public int getMinPower() {
        return minPower;
    }

    @Override
    public int getMaxPower() {
        return maxPower;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public List<ItemInfusionSlot> getInfusionSlots() {
        return infusionSlots;
    }

    @Override
    public Optional<ItemInfixUpgrade> getInfixUpgrade() {
        return infixUpgrade;
    }

    @Override
    public int getSuffixItemId() {
        return suffixItemId;
    }

    @Override
    public String getSecondarySuffixItemId() {
        return secondarySuffixItemId;
    }
}
