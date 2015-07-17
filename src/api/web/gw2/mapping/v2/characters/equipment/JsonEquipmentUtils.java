/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters.equipment;

import api.web.gw2.mapping.core.JsonUtils;
import java.util.Optional;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a equipment object.
 * @author Fabrice Bouyé
 */
public enum JsonEquipmentUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Gets a factory that allows to create equipment instances.
     * @return A {@code EquipmentFactory} instance, never {@code null}.
     */
    public static EquipmentFactory getEquipmentFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToEquipment);
    }

    /**
     * Read from the provided JSON object and return an equipment object.
     * @param jsonObject The source JSON object.
     * @return A {@code Equipment} instance, never {@code null}.
     */
    public Equipment jsonObjectToEquipment(final JsonObject jsonObject) {
        final DefaultEquipment result = new DefaultEquipment();
        result.id = jsonObject.getInt("id"); // NOI18N.
        result.slot = EquipmentUtils.findEquipmentSlot(jsonObject.getString("slot")); // NOI18N.
        if (jsonObject.containsKey("upgrades")) { // NOI18N.
            final JsonArray jsonArray = jsonObject.getJsonArray("upgrades"); // NOI18N.
            result.upgrades = Optional.ofNullable(JsonUtils.listFromJsonArray(jsonArray, JsonNumber.class, JsonUtils.INTEGER_CONVERTER));
        }
        if (jsonObject.containsKey("infusions")) {
            final JsonArray jsonArray = jsonObject.getJsonArray("infusions"); // NOI18N.
            result.infusions = Optional.ofNullable(JsonUtils.listFromJsonArray(jsonArray, JsonNumber.class, JsonUtils.INTEGER_CONVERTER));
        }
        result.skin = jsonObject.getInt("skin"); // NOI18N.
        return result;
    }
}
