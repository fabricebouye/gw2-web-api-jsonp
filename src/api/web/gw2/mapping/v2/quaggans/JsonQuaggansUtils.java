/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.quaggans;

import api.web.gw2.mapping.core.JsonUtils;
import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a quaggan object.
 * @author Fabrice Bouyé
 */
enum JsonQuaggansUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Gets a factory that allows to create quaggan isntances.
     * @return A {@code QuagganFactory} instance, never {@code null}.
     */
    public static QuagganFactory getFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToQuaggan);
    }

    /**
     * Read from the provided JSON object and return a Quaggan object.
     * @param jsonObject The source JSON object.
     * @return A {@code Quaggan} instance, never {@code null}.
     */
    Quaggan jsonObjectToQuaggan(final JsonObject jsonObject) {
        final DefaultQuaggan result = new DefaultQuaggan();
        result.id = jsonObject.getString("id"); // NOI18N.
        result.url = jsonObject.getString("url"); // NOI18N.
        return result;
    }
}
