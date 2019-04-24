/* 
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.wvw.matches;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.wvw.matches.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Default JSON-P implementation of a match map.
 * @author Fabrice Bouyé
 */
public final class JsonpWvwMatchMap implements WvwMatchMap {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @MapValue
    private Map<WvwMatchTeam, Integer> scores = Collections.EMPTY_MAP;
    @QuantityValue
    @MapValue
    private Map<WvwMatchTeam, Integer> deaths = Collections.EMPTY_MAP;
    @QuantityValue
    @MapValue
    private Map<WvwMatchTeam, Integer> kills = Collections.EMPTY_MAP;
    @EnumValue
    private WvwMatchMapType type = WvwMatchMapType.UNKNOWN;
    @ListValue
    private List<WvwMatchMapBonus> bonuses = Collections.EMPTY_LIST;
    @SetValue
    private Set<WvwMatchMapObjective> objectives = Collections.EMPTY_SET;

    /**
     * Creates a new instance.
     */
    public JsonpWvwMatchMap() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Map<WvwMatchTeam, Integer> getScores() {
        return scores;
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
    public WvwMatchMapType getType() {
        return type;
    }

    @Override
    public List<WvwMatchMapBonus> getBonuses() {
        return bonuses;
    }

    @Override
    public Set<WvwMatchMapObjective> getObjectives() {
        return objectives;
    }
}
