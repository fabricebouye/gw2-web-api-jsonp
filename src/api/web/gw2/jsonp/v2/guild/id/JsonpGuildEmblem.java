/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.guild.id;

import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.v2.guild.id.GuildEmblem;
import api.web.gw2.mapping.v2.guild.id.GuildEmblemLayer;
import api.web.gw2.mapping.v2.guild.id.GuildsEmblemFlag;

import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of a guild emblem.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildEmblem implements GuildEmblem {

    private GuildEmblemLayer background;
    private GuildEmblemLayer foreground;
    @ListValue
    private List<GuildsEmblemFlag> flags = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuildEmblem() {
    }

    @Override
    public GuildEmblemLayer getBackground() {
        return background;
    }

    @Override
    public GuildEmblemLayer getForeground() {
        return foreground;
    }

    @Override
    public List<GuildsEmblemFlag> getFlags() {
        return flags;
    }
}
