/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.standings;

import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a PvP standing.
 * @author Fabrice Bouyé
 */
public final class JsonpStanding implements Standing {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String seasonId = IdValue.DEFAULT_STRING_ID;
    private StandingReport current = StandingReport.EMPTY;
    private StandingReport best = StandingReport.EMPTY;

    /**
     * Creates a new empty instance.
     */
    public JsonpStanding() {
    }

    @Override
    public String getSeasonId() {
        return seasonId;
    }

    @Override
    public StandingReport getCurrent() {
        return current;
    }

    @Override
    public StandingReport getBest() {
        return best;
    }
}
