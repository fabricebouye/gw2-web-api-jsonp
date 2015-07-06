/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.worlds;

import api.web.gw2.mapping.core.JsonUtils;
import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a world object.
 * @author Fabrice Bouyé
 */
public enum JsonWorldsUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Gets a factory that allows to create world instances.
     * @return A {@code WorldFactory} instance, never {@code null}.
     */
    public static WorldFactory getFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToWorld);
    }

    /**
     * Read from the provided JSON object and return a world object.
     * @param jsonObject The source JSON object.
     * @return A {@code World} instance, never {@code null}.
     */
    World jsonObjectToWorld(final JsonObject jsonObject) {
        final DefaultWorld result = new DefaultWorld();
        result.id = jsonObject.getInt("id"); // NOI18N.
        result.name = jsonObject.getString("name"); // NOI18N.
        return result;
    }
}
