/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.inventory;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventory;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventoryBag;

import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P  implementation of a bag.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterInventoryBag implements CharacterInventoryBag {
    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int size = QuantityValue.DEFAULT;
    @ListValue
    private List<CharacterInventory> inventory = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterInventoryBag() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public List<CharacterInventory> getInventory() {
        return inventory;
    }
}
