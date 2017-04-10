/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.inventory;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventoryBinding;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventoryBag;

/**
 * Default JSON-P implementation of a shared inventory slot.
 * @author Fabrice Bouyé
 * @see InventoryBag
 */
public final class JsonpSharedInventory implements SharedInventory {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;
    @EnumValue
    private CharacterInventoryBinding binding = CharacterInventoryBinding.UNKNOWN;
    @OptionalValue
    @QuantityValue
    private OptionalInt charges = OptionalInt.empty();
    @IdValue
    @ListValue
    private List<Integer> infusions = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpSharedInventory() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public OptionalInt getCharges() {
        return charges;
    }

    @Override
    public List<Integer> getInfusions() {
        return infusions;
    }
}
