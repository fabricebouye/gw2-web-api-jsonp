/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.emblem;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.emblem.EmblemLayer;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a guild emblem.
 *
 * @author Fabrice Bouyé
 */
public class JsonpEmblemLayer implements EmblemLayer {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @SetValue
    @URLValue
    private Set<URLReference> layers = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpEmblemLayer() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Set<URLReference> getLayers() {
        return layers;
    }
}
