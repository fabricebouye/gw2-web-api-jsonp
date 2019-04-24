/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.guild.id.teams;

import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.guild.id.teams.GuildTeamLadderResult;

/**
 * Default JSON-P implementation of an guild team ladder result.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildTeamLadderResult implements GuildTeamLadderResult {

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
    public JsonpGuildTeamLadderResult() {
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
