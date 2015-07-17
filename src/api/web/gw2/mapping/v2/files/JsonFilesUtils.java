/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.files;

import api.web.gw2.mapping.core.JsonUtils;
import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a file object.
 * @author Fabrice Bouyé
 */
public enum JsonFilesUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Gets a factory that allows to create file instances.
     * @return A {@code FileFactory} instance, never {@code null}.
     */
    public static FileFactory getFilesFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToFile);
    }

    /**
     * Read from the provided JSON object and return a file object.
     * @param jsonObject The source JSON object.
     * @return A {@code File} instance, never {@code null}.
     */
    public File jsonObjectToFile(final JsonObject jsonObject) {
        final DefaultFile result = new DefaultFile();
        result.id = jsonObject.getString("id"); // NOI18N.
        result.icon = jsonObject.getString("icon"); // NOI18N.
        return result;
    }
}
