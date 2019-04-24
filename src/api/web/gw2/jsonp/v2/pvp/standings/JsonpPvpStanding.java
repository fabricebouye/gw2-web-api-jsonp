/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.standings;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.v2.pvp.standings.PvpStanding;
import api.web.gw2.mapping.v2.pvp.standings.PvpStandingReport;

/**
 * Default JSON-P implementation of a PvP standing.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpStanding implements PvpStanding {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String seasonId = IdValue.DEFAULT_STRING_ID;
    private PvpStandingReport current = PvpStandingReport.EMPTY;
    private PvpStandingReport best = PvpStandingReport.EMPTY;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpStanding() {
    }

    @Override
    public String getSeasonId() {
        return seasonId;
    }

    @Override
    public PvpStandingReport getCurrent() {
        return current;
    }

    @Override
    public PvpStandingReport getBest() {
        return best;
    }
}
