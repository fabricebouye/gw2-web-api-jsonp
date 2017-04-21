/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
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
public final class JsonpWvwMatch implements WvwMatch {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @DateValue
    private ZonedDateTime startTime = DateValue.DEFAULT;
    @DateValue
    private ZonedDateTime endTime = DateValue.DEFAULT;
    @MapValue
    private Map<WvwMatchTeam, Integer> scores = Collections.EMPTY_MAP;
    @IdValue
    @MapValue
    private Map<WvwMatchTeam, Integer> worlds = Collections.EMPTY_MAP;
    @IdValue
    @MapValue
    @SetValue
    private Map<WvwMatchTeam, Set<Integer>> allWorlds = Collections.EMPTY_MAP;
    @QuantityValue
    @MapValue
    private Map<WvwMatchTeam, Integer> deaths = Collections.EMPTY_MAP;
    @QuantityValue
    @MapValue
    private Map<WvwMatchTeam, Integer> kills = Collections.EMPTY_MAP;
    @SetValue
    private Set<WvwMatchMap> maps = Collections.EMPTY_SET;

    /**
     * Creates a new instance.
     */
    public JsonpWvwMatch() {
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
    public Map<WvwMatchTeam, Integer> getScores() {
        return scores;
    }

    @Override
    public Map<WvwMatchTeam, Integer> getWorlds() {
        return worlds;
    }

    @Override
    public Map<WvwMatchTeam, Set<Integer>> getAllWorlds() {
        return allWorlds;
    }

    @Override
    public Map<WvwMatchTeam, Integer> getDeaths() {
        return deaths;
    }

    @Override
    public Map<WvwMatchTeam, Integer> getKills() {
        return kills;
    }

    @Override
    public Set<WvwMatchMap> getMaps() {
        return maps;
    }
}
