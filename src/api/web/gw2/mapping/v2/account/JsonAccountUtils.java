/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account;

import api.web.gw2.mapping.core.JsonUtils;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;

/**
 * A factory that uses JSON-P to produce an account object.
 * @author Fabrice Bouyé
 */
public enum JsonAccountUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Gets a factory that allows to create account instances.
     * @return A {@code AccountFactory} instance, never {@code null}.
     */
    public static AccountFactory getAccountFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToAccount);
    }

    /**
     * Read from the provided JSON object and return an account object.
     * @param jsonObject The source JSON object.
     * @return An {@code Account} instance, never {@code null}.
     */
    public Account jsonObjectToAccount(final JsonObject jsonObject) {
        final DefaultAccount result = new DefaultAccount();
        result.id = jsonObject.getString("id"); // NOI18N.
        result.name = jsonObject.getString("name"); // NOI18N.
        result.world = jsonObject.getInt("world"); // NOI18N.
        {
            final JsonArray jsonArray = jsonObject.getJsonArray("guilds"); // NOI18N.
            result.guilds = JsonUtils.setFromJsonArray(jsonArray, JsonString.class, JsonUtils.STRING_CONVERTER);
        }
        return result;
    }
}
