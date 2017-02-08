/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a guild.
 * @author Fabrice Bouyé
 */
public final class JsonpGuild implements Guild {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    private String name = LocalizedResource.DEFAULT;
    private String tag = LocalizedResource.DEFAULT;
    @LevelValue
    private int level = QuantityValue.DEFAULT;
    private String motd = LocalizedResource.DEFAULT;
    @QuantityValue
    private int influence = QuantityValue.DEFAULT;
    @QuantityValue
    private int aetherium = QuantityValue.DEFAULT;
    @QuantityValue
    private int favor = QuantityValue.DEFAULT;
    @QuantityValue
    private int resonance = QuantityValue.DEFAULT;
    private GuildEmblem emblem;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuild() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getMotd() {
        return motd;
    }

    @Override
    public int getInfluence() {
        return influence;
    }

    @Override
    public int getAetherium() {
        return aetherium;
    }

    @Override
    public int getFavor() {
        return favor;
    }

    @Override
    public int getResonance() {
        return resonance;
    }

    @Override
    public GuildEmblem getEmblem() {
        return emblem;
    }
}
