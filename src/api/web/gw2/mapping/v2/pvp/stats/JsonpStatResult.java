/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.stats;

import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a PvP stat result.
 * @author Fabrice Bouyé
 */
public final class JsonpStatResult implements StatResult {

    @QuantityValue
    private int wins = 0;
    @QuantityValue
    private int losses = 0;
    @QuantityValue
    private int desertions = 0;
    @QuantityValue
    private int byes = 0;
    @QuantityValue
    private int forfeits = 0;

    /**
     * Creates a new empty instance.
     */
    public JsonpStatResult() {
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public int getLosses() {
        return losses;
    }

    @Override
    public int getDesertions() {
        return desertions;
    }

    @Override
    public int getByes() {
        return byes;
    }

    @Override
    public int getForfeits() {
        return forfeits;
    }
}
