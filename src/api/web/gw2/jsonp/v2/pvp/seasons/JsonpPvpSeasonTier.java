/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.seasons;

import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonTier;

/**
 * Default JSON-P implementation of a PvP league season's division tier.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpSeasonTier implements PvpSeasonTier {

    @QuantityValue
    private int points = QuantityValue.DEFAULT;

    /**
     * Create a new empty instance.
     */
    public JsonpPvpSeasonTier() {

    }

    @Override
    public int getPoints() {
        return points;
    }
}
