/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.itemstats;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.v2.itemstats.Itemstats;
import api.web.gw2.mapping.v2.itemstats.ItemstatsAttribute;

import java.util.Collections;
import java.util.Map;

/**
 * Default JSON-P implementation of an item stat set.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpItemstats implements Itemstats {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @MapValue
    private Map<ItemstatsAttribute, Integer> attributes = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpItemstats() {
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
    public Map<ItemstatsAttribute, Integer> getAttributes() {
        return attributes;
    }
}
