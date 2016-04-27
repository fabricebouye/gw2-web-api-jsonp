/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.wvw.matches;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Default JSON-P implementation of a match.
 * @author Fabrice Bouyé
 */
public final class JsonpMatch implements Match {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = ""; // NOI18N.
    @DateValue
    private ZonedDateTime startTime = DateValue.DEFAULT;
    @DateValue
    private ZonedDateTime endTime = DateValue.DEFAULT;
    @MapValue
    private Map<MatchTeam, Integer> scores = Collections.EMPTY_MAP;
    @IdValue
    @MapValue
    private Map<MatchTeam, Integer> worlds = Collections.EMPTY_MAP;
    @IdValue
    @MapValue
    @SetValue
    private Map<MatchTeam, Set<Integer>> allWorlds = Collections.EMPTY_MAP;
    @QuantityValue
    @MapValue
    private Map<MatchTeam, Integer> deaths = Collections.EMPTY_MAP;
    @QuantityValue
    @MapValue
    private Map<MatchTeam, Integer> kills = Collections.EMPTY_MAP;
    @SetValue
    private Set<MatchMap> maps = Collections.EMPTY_SET;

    /**
     * Creates a new instance.
     */
    public JsonpMatch() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public ZonedDateTime getStartTime() {
        return startTime;
    }

    @Override
    public ZonedDateTime getEndTime() {
        return endTime;
    }

    @Override
    public Map<MatchTeam, Integer> getScores() {
        return scores;
    }

    @Override
    public Map<MatchTeam, Integer> getWorlds() {
        return worlds;
    }

    @Override
    public Map<MatchTeam, Set<Integer>> getAllWorlds() {
        return allWorlds;
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
    public Set<MatchMap> getMaps() {
        return maps;
    }
}
