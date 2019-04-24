/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.minis;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.minis.Mini;

import java.util.Optional;

/**
 * Default JSON-P implementation of a miniature.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpMini implements Mini {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    @OptionalValue
    private Optional<String> unlock = Optional.empty();
    @URLValue
    private URLReference icon = URLReference.empty();
    @QuantityValue
    private int order = QuantityValue.DEFAULT;
    @IdValue
    private int itemId = IdValue.DEFAULT_INTEGER_ID;

    /**
     * Creates a new empty instance.
     */
    public JsonpMini() {
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
    public Optional<String> getUnlock() {
        return unlock;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public int getItemId() {
        return itemId;
    }

}
