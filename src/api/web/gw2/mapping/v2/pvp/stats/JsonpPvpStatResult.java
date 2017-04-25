/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
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
public final class JsonpPvpStatResult implements PvpStatResult {

    @QuantityValue
    private int wins = QuantityValue.DEFAULT;
    @QuantityValue
    private int losses = QuantityValue.DEFAULT;
    @QuantityValue
    private int desertions = QuantityValue.DEFAULT;
    @QuantityValue
    private int byes = QuantityValue.DEFAULT;
    @QuantityValue
    private int forfeits = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpStatResult() {
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
