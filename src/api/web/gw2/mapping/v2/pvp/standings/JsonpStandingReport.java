/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.standings;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a PvP standing report.
 * @author Fabrice Bouyé
 */
public final class JsonpStandingReport implements StandingReport {

    @QuantityValue
    private int totalPoints = QuantityValue.DEFAULT;
    @IdValue
    private int division = QuantityValue.DEFAULT;
    @QuantityValue
    private int tier = QuantityValue.DEFAULT;
    @QuantityValue
    private int points = QuantityValue.DEFAULT;
    @QuantityValue
    private int repeats = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpStandingReport() {
    }

    @Override
    public int getTotalPoints() {
        return points;
    }

    @Override
    public int getDivision() {
        return division;
    }

    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public int getRepeats() {
        return repeats;
    }
}
