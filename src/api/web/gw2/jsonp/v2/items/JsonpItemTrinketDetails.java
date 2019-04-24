/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.items;

import api.web.gw2.mapping.core.*;
import api.web.gw2.mapping.v2.items.*;

import java.util.*;

/**
 * Default JSON-P implementation of a trinket details.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpItemTrinketDetails extends JsonpItemDetails implements ItemTrinketDetails {

    @EnumValue
    private ItemTrinketType type = ItemTrinketType.UNKNOWN;
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

    public JsonpItemTrinketDetails() {
        super(ItemType.TRINKET);
    }

    @Override
    public ItemTrinketType getType() {
        return type;
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
