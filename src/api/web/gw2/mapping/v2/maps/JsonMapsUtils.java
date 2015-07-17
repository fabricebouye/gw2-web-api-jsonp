/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.maps;

import api.web.gw2.mapping.core.JsonCoreUtils;
import api.web.gw2.mapping.core.JsonUtils;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a map object.
 * @author Fabrice Bouyé
 */
public enum JsonMapsUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Read from the provided JSON object and return a map object.
     * @param jsonObject The source JSON object.
     * @return A {@code Map} instance, never {@code null}.
     */
    public Map jsonObjectToMap(final JsonObject jsonObject) {
        final DefaultMap result = new DefaultMap();
        result.id = jsonObject.getInt("id"); // NOI18N.
        result.name = jsonObject.getString("name"); // NOI18N.
        result.minLevel = jsonObject.getInt("min_level"); // NOI18N.
        result.maxLevel = jsonObject.getInt("max_level"); // NOI18N.
        result.defaultFloor = jsonObject.getInt("default_floor"); // NOI18N.
        final JsonArray jsonFloors = jsonObject.getJsonArray("floors");  // NOI18N.
        result.floors = JsonUtils.setFromJsonArray(jsonFloors, JsonNumber.class, JsonUtils.INTEGER_CONVERTER);
        result.regionId = jsonObject.getInt("region_id"); // NOI18N.
        result.regionName = jsonObject.getString("region_name"); // NOI18N.
        result.continentId = jsonObject.getInt("continent_id"); // NOI18N.
        result.continentName = jsonObject.getString("continent_name"); // NOI18N.
        final JsonArray jsonMapRect = jsonObject.getJsonArray("map_rect"); // NOI18N.
        result.mapRect = JsonCoreUtils.INSTANCE.jsonArrayToMapDimension(jsonMapRect);
        final JsonArray jsonContinentRect = jsonObject.getJsonArray("continent_rect"); // NOI18N.
        result.continentRect = JsonCoreUtils.INSTANCE.jsonArrayToContinentDimension(jsonContinentRect);
        return result;
    }
}
