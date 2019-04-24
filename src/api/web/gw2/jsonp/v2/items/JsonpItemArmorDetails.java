/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.items;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.items.ItemArmorDetails;
import api.web.gw2.mapping.v2.items.ItemArmorType;
import api.web.gw2.mapping.v2.items.ItemArmorWeightClass;
import api.web.gw2.mapping.v2.items.ItemInfixUpgrade;
import api.web.gw2.mapping.v2.items.ItemInfusionSlot;
import api.web.gw2.mapping.v2.items.ItemType;

import java.util.*;

/**
 * Default JSON-P implementation of an item armor details.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpItemArmorDetails extends JsonpItemDetails implements ItemArmorDetails {

    @EnumValue
    private ItemArmorType type = ItemArmorType.UNKNOWN;
    @EnumValue
    private ItemArmorWeightClass weightClass = ItemArmorWeightClass.UNKNOWN;
    @QuantityValue
    private int defense = QuantityValue.DEFAULT;
    @ListValue
    private List<ItemInfusionSlot> infusionSlots = Collections.EMPTY_LIST;
    @OptionalValue
    private Optional<ItemInfixUpgrade> infixUpgrade = Optional.empty();
    @OptionalValue
    @IdValue
    private OptionalInt suffixItemId = OptionalInt.empty();
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String secondarySuffixItemId = IdValue.DEFAULT_STRING_ID;
    @SetValue
    @IdValue
    private Set<Integer> statChoices = Collections.EMPTY_SET;

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
        return infusionSlots;
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

    @Override
    public Set<Integer> getStatChoices() {
        return statChoices;
    }
}
