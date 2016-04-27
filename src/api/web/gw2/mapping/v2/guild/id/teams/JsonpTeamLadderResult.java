/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.teams;

import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of an guild team ladder result.
 * @author Fabrice Bouyé
 */
public final class JsonpTeamLadderResult implements TeamLadderResult {

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
     * Create a new empty instance.
     */
    public JsonpTeamLadderResult() {
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
