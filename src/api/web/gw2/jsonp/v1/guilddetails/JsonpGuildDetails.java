/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v1.guilddetails;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.v1.guilddetails.GuildDetails;
import api.web.gw2.mapping.v1.guilddetails.GuildDetailsEmblem;

/**
 * Default JSON-P implementation of the details of a guild.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildDetails implements GuildDetails {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String guildId = IdValue.DEFAULT_STRING_ID;
    private String guildName = LocalizedResource.DEFAULT;
    private String tag = LocalizedResource.DEFAULT;
    private GuildDetailsEmblem emblem = null;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuildDetails() {
    }

    @Override
    public String getGuildId() {
        return guildId;
    }

    @Override
    public String getGuildName() {
        return guildName;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public GuildDetailsEmblem getEmblem() {
        return emblem;
    }
}
