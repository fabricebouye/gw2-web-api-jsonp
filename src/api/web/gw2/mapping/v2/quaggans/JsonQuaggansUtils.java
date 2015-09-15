/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.quaggans;

import api.web.gw2.mapping.core.JsonUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a quaggan object.
 * @author Fabrice Bouyé
 */
public enum JsonQuaggansUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Gets a factory that allows to create quaggan instances.
     * @return A {@code QuagganFactory} instance, never {@code null}.
     */
    public static QuagganFactory getQuagganFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToQuaggan);
    }

    /**
     * Read from the provided JSON object and return a quaggan object.
     * @param jsonObject The source JSON object.
     * @return A {@code Quaggan} instance, never {@code null}.
     */
    public Quaggan jsonObjectToQuaggan(final JsonObject jsonObject) {
        final DefaultQuaggan result = new DefaultQuaggan();
        result.id = jsonObject.getString("id"); // NOI18N.
        final String jsonURL = jsonObject.getString("url"); // NOI18N.
        try {
            final URL url = new URL(jsonURL);
            result.url = Optional.of(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(JsonQuaggansUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
