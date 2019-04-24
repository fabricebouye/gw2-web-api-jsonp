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
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.items.ItemBackDetails;
import api.web.gw2.mapping.v2.items.ItemInfixUpgrade;
import api.web.gw2.mapping.v2.items.ItemInfusionSlot;
import api.web.gw2.mapping.v2.items.ItemType;

import java.util.*;

/**
 * Default JSON-P implementation of an back item details.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpItemBackDetails extends JsonpItemDetails implements ItemBackDetails {

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
     * Creates a new default empty instance.
     */
    public JsonpItemBackDetails() {
        super(ItemType.BACK);
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
