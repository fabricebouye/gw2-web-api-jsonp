/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.tokeninfo;

import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a token info object.
 * @author Fabrice Bouyé
 */
public enum JsonTokenInfoUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Read from the provided JSON object and return a token info object.
     * @param jsonObject The source JSON object.
     * @return A {@code TokenInfo} instance, never {@code null}.
     */
    public TokenInfo jsonObjectToTokenInfo(final JsonObject jsonObject) {
        final DefaultTokenInfo result = new DefaultTokenInfo();
        result.id = jsonObject.getString("id"); // NOI18N.
        result.name = jsonObject.getString("name"); // NOI18N.
        return result;
    }
}
