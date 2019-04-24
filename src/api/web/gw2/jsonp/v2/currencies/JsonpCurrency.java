/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.currencies;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.currencies.Currency;

/**
 * Default JSON-P implementation of a currency.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCurrency implements Currency {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @QuantityValue
    private int order = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpCurrency() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
