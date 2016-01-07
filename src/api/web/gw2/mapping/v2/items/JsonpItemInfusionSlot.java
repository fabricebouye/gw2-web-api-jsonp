/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of an item infusion slot.
 * @author Fabrice Bouyé
 */
public final class JsonpItemInfusionSlot implements ItemInfusionSlot {

    private OptionalInt itemId = OptionalInt.empty();
    private Set<ItemInfusionSlotFlag> flags = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpItemInfusionSlot() {
    }

    @Override
    public OptionalInt getItemId() {
        return itemId;
    }

    @Override
    public Set<ItemInfusionSlotFlag> getFlags() {
        return flags;
    }
}
