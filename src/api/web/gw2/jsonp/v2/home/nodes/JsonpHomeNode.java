/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.home.nodes;


import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.v2.home.nodes.HomeNode;

/**
 * Default JSON-P implementation of a home gathering node.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpHomeNode implements HomeNode {
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;

    /**
     * Creates a new empty instance.
     */
    public JsonpHomeNode() {
    }

    @Override
    public String getId() {
        return id;
    }
}
