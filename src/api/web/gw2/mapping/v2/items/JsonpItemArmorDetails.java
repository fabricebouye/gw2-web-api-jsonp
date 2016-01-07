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
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of an item armor details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemArmorDetails extends JsonpItemDetails implements ItemArmorDetails {

    private ItemArmorType type = ItemArmorType.UNKNOWN;
    private ItemArmorWeightClass weightClass = ItemArmorWeightClass.UNKNOWN;
    private int defense = -1;
    private List<ItemInfusionSlot> infusions = Collections.EMPTY_LIST;
    private Optional<ItemInfixUpgrade> infixUpgrade = Optional.empty();
    private OptionalInt suffixItemId = OptionalInt.empty();
    private String secondarySuffixItemId = "";

    /**
     * Create a new empty instance.
     */
    public JsonpItemArmorDetails() {
        super(ItemType.ARMOR);
    }

    @Override
    public ItemArmorType getType() {
        return type;
    }

    @Override
    public ItemArmorWeightClass getWeightClass() {
        return weightClass;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public List<ItemInfusionSlot> getInfusionSlots() {
        return infusions;
    }

    @Override
    public Optional<ItemInfixUpgrade> getInfixUpgrade() {
        return infixUpgrade;
    }

    @Override
    public OptionalInt getSuffixItemId() {
        return suffixItemId;
    }

    @Override
    public String getSecondarySuffixItemId() {
        return secondarySuffixItemId;
    }
}
