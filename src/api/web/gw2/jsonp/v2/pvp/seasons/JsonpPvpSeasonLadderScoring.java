/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.seasons;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonLadderScoring;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonLadderScoringOrdering;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonLadderScoringType;

/**
 * Default JSON-P implementation of a PvP league season ladder's settings scoring.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpSeasonLadderScoring implements PvpSeasonLadderScoring {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @EnumValue
    private PvpSeasonLadderScoringType type = PvpSeasonLadderScoringType.UNKNOWN;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @EnumValue
    private PvpSeasonLadderScoringOrdering ordering = PvpSeasonLadderScoringOrdering.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpSeasonLadderScoring() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PvpSeasonLadderScoringType getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public PvpSeasonLadderScoringOrdering getOrdering() {
        return ordering;
    }
}
