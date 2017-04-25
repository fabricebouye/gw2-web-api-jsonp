/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.stats;

import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.pvp.PvpLadder;
import java.util.Collections;
import java.util.Map;

/**
 * Default JSON-P implementation of a PvP stat.
 * @author Fabrice Bouyé
 */
public final class JsonpPvpStat implements PvpStat {

    @LevelValue
    private int pvpRank = LevelValue.MIN_LEVEL;
    @QuantityValue
    private int pvpRankPoints = QuantityValue.DEFAULT;
    @QuantityValue
    private int pvpRankRollovers = QuantityValue.DEFAULT;
    private PvpStatResult aggregate = PvpStatResult.EMPTY;
    @MapValue
    private Map<CharacterProfession, PvpStatResult> professions = Collections.EMPTY_MAP;
    @MapValue
    private Map<PvpLadder, PvpStatResult> ladders = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpStat() {
    }

    @Override
    public int getPvpRank() {
        return pvpRank;
    }

    @Override
    public int getPvpRankPoints() {
        return pvpRankPoints;
    }

    @Override
    public int getPvpRankRollovers() {
        return pvpRankRollovers;
    }

    @Override
    public PvpStatResult getAggregate() {
        return aggregate;
    }

    @Override
    public Map<CharacterProfession, PvpStatResult> getProfessions() {
        return professions;
    }

    @Override
    public Map<PvpLadder, PvpStatResult> getLadders() {
        return ladders;
    }
}
