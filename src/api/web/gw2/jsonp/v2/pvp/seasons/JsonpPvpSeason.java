/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.seasons;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeason;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonDivision;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonLadder;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonLadderType;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Default JSON-P implementation of a PvP league season.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpSeason implements PvpSeason {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @SetValue
    private Set<PvpSeasonDivision> divisions = Collections.EMPTY_SET;
    @DateValue
    private ZonedDateTime start = DateValue.DEFAULT;
    @DateValue
    private ZonedDateTime end = DateValue.DEFAULT;
    private boolean active = false;
    @MapValue
    private Map<PvpSeasonLadderType, PvpSeasonLadder> leaderboards = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpSeason() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<PvpSeasonDivision> getDivisions() {
        return divisions;
    }

    @Override
    public ZonedDateTime getStart() {
        return start;
    }

    @Override
    public ZonedDateTime getEnd() {
        return end;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public Map<PvpSeasonLadderType, PvpSeasonLadder> getLeaderboards() {
        return leaderboards;
    }
}
