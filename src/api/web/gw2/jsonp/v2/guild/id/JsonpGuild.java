/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.guild.id;

import api.web.gw2.mapping.core.*;
import api.web.gw2.mapping.v2.guild.id.Guild;
import api.web.gw2.mapping.v2.guild.id.GuildEmblem;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a guild.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuild implements Guild {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    private String name = LocalizedResource.DEFAULT;
    private String tag = LocalizedResource.DEFAULT;
    @OptionalValue
    @LevelValue
    private OptionalInt level = OptionalInt.empty();
    @OptionalValue
    private Optional<String> motd = Optional.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt influence = OptionalInt.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt aetherium = OptionalInt.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt favor = OptionalInt.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt resonance = OptionalInt.empty();
    private GuildEmblem emblem;
    @QuantityValue
    private int memberCount = QuantityValue.DEFAULT;
    @QuantityValue
    private int memberCapacity = QuantityValue.DEFAULT;

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
    public OptionalInt getLevel() {
        return level;
    }

    @Override
    public Optional<String> getMotd() {
        return motd;
    }

    @Override
    public OptionalInt getInfluence() {
        return influence;
    }

    @Override
    public OptionalInt getAetherium() {
        return aetherium;
    }

    @Override
    public OptionalInt getFavor() {
        return favor;
    }

    @Override
    public OptionalInt getResonance() {
        return resonance;
    }

    @Override
    public GuildEmblem getEmblem() {
        return emblem;
    }

    @Override
    public int getMemberCount() {
        return memberCount;
    }

    @Override
    public int getMemberCapacity() {
        return memberCapacity;
    }
}
