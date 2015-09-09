/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.guilddetails;

import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of the details of a guild.
 * @author Fabrice Bouyé
 */
public final class JsonpGuildDetails implements GuildDetails {

    @IdValue
    String guildId = "";
    String guildName = "";
    String tag = "";
    GuildDetailsEmblem emblem = null;

    /**
     * Creates a new empty instance.
     */
    JsonpGuildDetails() {
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
