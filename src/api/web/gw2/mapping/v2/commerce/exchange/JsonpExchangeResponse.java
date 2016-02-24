/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.commerce.exchange;

import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of the exchange result
 * @author Fabrice Bouyé
 */
public final class JsonpExchangeResponse implements ExchangeResponse {

    @SetValue
    private Set<ExchangeResource> resources = Collections.EMPTY_SET;

    /**
     * Creates a new empty result.
     */
    public JsonpExchangeResponse() {
    }

    @Override
    public Set<ExchangeResource> getResources() {
        return resources;
    }
}
