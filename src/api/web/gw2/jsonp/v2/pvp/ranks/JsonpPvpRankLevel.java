/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.ranks;

import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.pvp.ranks.PvpRankLevel;

/**
 * Default JSON-P implementation of a PvP rank.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpRankLevel implements PvpRankLevel {

    @LevelValue
    private int minRank = LevelValue.MIN_LEVEL;
    @LevelValue
    private int maxRank = LevelValue.MIN_LEVEL;
    @QuantityValue
    private int points = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpRankLevel() {
    }

    @Override
    public int getMinRank() {
        return minRank;
    }

    @Override
    public int getMaxRank() {
        return maxRank;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
