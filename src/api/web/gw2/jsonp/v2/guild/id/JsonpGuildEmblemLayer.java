/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.guild.id;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.v2.guild.id.GuildEmblemLayer;

import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of a guild emblem layer.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildEmblemLayer implements GuildEmblemLayer {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @ListValue
    @IdValue
    private List<Integer> colors = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuildEmblemLayer() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Integer> getColors() {
        return colors;
    }
}
