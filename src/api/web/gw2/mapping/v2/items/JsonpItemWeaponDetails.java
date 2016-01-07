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
 * Default JSON-P implementation of an item weapon detail.
 * @author Fabrice Bouyé
 */
public final class JsonpItemWeaponDetails extends JsonpItemDetails implements ItemWeaponDetails {

    private ItemWeaponType type = ItemWeaponType.UNKNOWN;
    private ItemWeaponDamageType damageType = ItemWeaponDamageType.UNKNOWN;
    private int minPower = 0;
    private int maxPower = 0;
    private int defense = 0;
    private List<ItemInfusionSlot> infusionSlots = Collections.EMPTY_LIST;
    private Optional<ItemInfixUpgrade> infixUpgrade = Optional.empty();
    private int suffixItemId = -1;
    private String secondarySuffixItemId = "";

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
