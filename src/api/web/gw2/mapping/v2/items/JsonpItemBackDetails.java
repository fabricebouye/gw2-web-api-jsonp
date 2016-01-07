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
 * Default JSON-P implementation of an back item details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemBackDetails extends JsonpItemDetails implements ItemBackDetails {

    private List<ItemInfusionSlot> infusionSlots = Collections.EMPTY_LIST;
    private Optional<ItemInfixUpgrade> infixUpgrade = Optional.empty();
    private OptionalInt suffixItemId = OptionalInt.empty();
    private String secondarySuffixItemId = "";

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
}
