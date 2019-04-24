/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.seasons.leaderboards;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.pvp.seasons.leaderboards.PvpSeasonLeaderboardScore;

/**
 * Default JSON-P implementation of a PvP league leaderboard score.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpSeasonLeaderboardScore implements PvpSeasonLeaderboardScore {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @QuantityValue
    private int value = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpSeasonLeaderboardScore() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getValue() {
        return value;
    }
}
