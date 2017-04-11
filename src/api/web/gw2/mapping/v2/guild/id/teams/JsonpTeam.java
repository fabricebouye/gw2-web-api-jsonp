/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.teams;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.pvp.PvpLadder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Default JSON-P implementation of an guild team.
 * @author Fabrice Bouyé
 */
public final class JsonpTeam implements Team {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @SetValue
    private Set<TeamMember> members = Collections.EMPTY_SET;
    private String name = LocalizedResource.DEFAULT;
    @EnumValue
    private TeamState state = TeamState.UNKNOWN;
    private TeamLadderResult aggregate = TeamLadderResult.EMPTY;
    @MapValue
    private Map<PvpLadder, TeamLadderResult> ladders = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpTeam() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Set<TeamMember> getMembers() {
        return members;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TeamState getState() {
        return state;
    }

    @Override
    public TeamLadderResult getAggregate() {
        return aggregate;
    }

    @Override
    public Map<PvpLadder, TeamLadderResult> getLadders() {
        return ladders;
    }
}
