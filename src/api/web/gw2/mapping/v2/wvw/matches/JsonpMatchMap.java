/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.wvw.matches;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Default JSON-P implementation of a match map.
 * @author Fabrice Bouyé
 */
public final class JsonpMatchMap implements MatchMap {

    @IdValue
    private int id = -1;
    @MapValue
    private Map<MatchTeam, Integer> scores = Collections.EMPTY_MAP;
    @QuantityValue
    @MapValue
    private Map<MatchTeam, Integer> deaths = Collections.EMPTY_MAP;
    @QuantityValue
    @MapValue
    private Map<MatchTeam, Integer> kills = Collections.EMPTY_MAP;
    @EnumValue
    private MatchMapType type = MatchMapType.UNKNOWN;
    @ListValue
    private List<MatchMapBonus> bonuses = Collections.EMPTY_LIST;
    @SetValue
    private Set<MatchMapObjective> objectives = Collections.EMPTY_SET;

    /**
     * Creates a new instance.
     */
    public JsonpMatchMap() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Map<MatchTeam, Integer> getScores() {
        return scores;
    }

    @Override
    public Map<MatchTeam, Integer> getDeaths() {
        return deaths;
    }

    @Override
    public Map<MatchTeam, Integer> getKills() {
        return kills;
    }

    @Override
    public MatchMapType getType() {
        return type;
    }

    @Override
    public List<MatchMapBonus> getBonuses() {
        return bonuses;
    }

    @Override
    public Set<MatchMapObjective> getObjectives() {
        return objectives;
    }
}
