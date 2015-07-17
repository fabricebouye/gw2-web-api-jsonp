/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters.inventory;

import api.web.gw2.mapping.core.JsonUtils;
import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a equipment object.
 * @author Fabrice Bouyé
 */
public enum JsonInventoryUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Gets a factory that allows to create bag instances.
     * @return An {@code InventoryBagFactory} instance, never {@code null}.
     */
    public static InventoryBagFactory getInventoryBagFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToInventoryBag);
    }

    /**
     * Gets a factory that allows to create inventory instances.
     * @return An {@code InventoryFactory} instance, never {@code null}.
     */
    public static InventoryFactory getInventoryFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToInventory);
    }

    /**
     * Read from the provided JSON object and return a bag object.
     * @param jsonObject The source JSON object.
     * @return An {@code InventoryBag} instance, never {@code null}.
     */
    public InventoryBag jsonObjectToInventoryBag(final JsonObject jsonObject) {
        final DefaultInventoryBag result = new DefaultInventoryBag();
        result.id = jsonObject.getInt("id"); // NOI18N.
        result.size = jsonObject.getInt("size"); // NOI18N.
        {
            final JsonArray jsonArray = jsonObject.getJsonArray("inventory"); // NOI18N.
            result.inventory = JsonUtils.listFromJsonArray(jsonArray, JsonObject.class, INSTANCE::jsonObjectToInventory);
        }
        return result;
    }

    /**
     * Read from the provided JSON object and return an inventory object.
     * @param jsonObject The source JSON object.
     * @return An {@code Inventory} instance, never {@code null}.
     */
    public Inventory jsonObjectToInventory(final JsonObject jsonObject) {
        final DefaultInventory result = new DefaultInventory();
        result.id = jsonObject.getInt("id"); // NOI18N.
        result.count = (short) jsonObject.getInt("count"); // NOI18N.
        return result;
    }
}
