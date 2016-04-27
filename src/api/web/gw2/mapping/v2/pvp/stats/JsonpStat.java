/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
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
import api.web.gw2.mapping.v2.pvp.PvPLadder;
import java.util.Collections;
import java.util.Map;

/**
 * Default JSON-P implementation of a PvP stat.
 * @author Fabrice Bouyé
 */
public final class JsonpStat implements Stat {

    @LevelValue
    private int pvpRank = LevelValue.MIN_LEVEL;
    @QuantityValue
    private int pvpRankPoints = QuantityValue.DEFAULT;
    @QuantityValue
    private int pvpRankRollovers = QuantityValue.DEFAULT;
    private StatResult aggregate = StatResult.EMPTY;
    @MapValue
    private Map<CharacterProfession, StatResult> professions = Collections.EMPTY_MAP;
    @MapValue
    private Map<PvPLadder, StatResult> ladders = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpStat() {
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
    public StatResult getAggregate() {
        return aggregate;
    }

    @Override
    public Map<CharacterProfession, StatResult> getProfessions() {
        return professions;
    }

    @Override
    public Map<PvPLadder, StatResult> getLadders() {
        return ladders;
    }
}
