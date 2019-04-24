/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.home.cats;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.v2.home.cats.HomeCat;

/**
 * Default JSON-P implementation of a home cat.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpHomeCat implements HomeCat {
    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String hint = IdValue.DEFAULT_STRING_ID;

    /**
     * Creates a new empty instance.
     */
    public JsonpHomeCat() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getHint() {
        return hint;
    }
}
