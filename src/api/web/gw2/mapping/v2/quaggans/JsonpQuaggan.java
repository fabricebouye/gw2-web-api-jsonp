/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.quaggans;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
import java.util.Optional;

/**
 * Default JSON-P implementation of a guaggan.
 * @author Fabrice Bouyé
 */
public final class JsonpQuaggan implements Quaggan {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = "";
    @OptionalValue
    @URLValue
    private Optional<URL> url = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpQuaggan() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Optional<URL> getUrl() {
        return url;
    }
}
