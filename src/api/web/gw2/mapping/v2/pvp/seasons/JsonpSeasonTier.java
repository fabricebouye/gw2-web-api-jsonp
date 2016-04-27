/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.seasons;

import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a PvP league season's division tier.
 * @author Fabrice Bouyé
 */
public final class JsonpSeasonTier implements SeasonTier {

    @QuantityValue
    private int points = QuantityValue.DEFAULT;

    /**
     * Create a new empty instance.
     */
    public JsonpSeasonTier() {

    }

    @Override
    public int getPoints() {
        return points;
    }
}
