/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.seasons;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;

/**
 * Default JSON-P implementation of a PvP league season ladder's settings scoring.
 * @author Fabrice Bouyé
 */
public final class JsonpSeasonLadderScoring implements SeasonLadderScoring {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @EnumValue
    private SeasonLadderScoringType type = SeasonLadderScoringType.UNKNOWN;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @EnumValue
    private SeasonLadderScoringOrdering ordering = SeasonLadderScoringOrdering.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpSeasonLadderScoring() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public SeasonLadderScoringType getType() {
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
    public SeasonLadderScoringOrdering getOrdering() {
        return ordering;
    }
}
