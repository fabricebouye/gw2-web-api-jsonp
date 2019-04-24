/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.amulets;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.pvp.amulets.PvpAmulet;
import api.web.gw2.mapping.v2.pvp.amulets.PvpAmuletAttribute;

import java.util.Collections;
import java.util.Map;

/**
 * Default JSON-P implementation of a PvP amulet.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpAmulet implements PvpAmulet {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;

    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;

    @URLValue
    private URLReference icon = URLReference.empty();

    @MapValue
    private Map<PvpAmuletAttribute, Integer> attributes = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpAmulet() {
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
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public Map<PvpAmuletAttribute, Integer> getAttributes() {
        return attributes;
    }

}
