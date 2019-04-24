/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.guild.id.teams;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.guild.id.teams.GuildTeam;
import api.web.gw2.mapping.v2.guild.id.teams.GuildTeamLadderResult;
import api.web.gw2.mapping.v2.guild.id.teams.GuildTeamMember;
import api.web.gw2.mapping.v2.guild.id.teams.GuildTeamState;
import api.web.gw2.mapping.v2.pvp.PvpLadder;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Default JSON-P implementation of an guild team.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildTeam implements GuildTeam {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @SetValue
    private Set<GuildTeamMember> members = Collections.EMPTY_SET;
    private String name = LocalizedResource.DEFAULT;
    @EnumValue
    private GuildTeamState state = GuildTeamState.UNKNOWN;
    private GuildTeamLadderResult aggregate = GuildTeamLadderResult.EMPTY;
    @MapValue
    private Map<PvpLadder, GuildTeamLadderResult> ladders = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuildTeam() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Set<GuildTeamMember> getMembers() {
        return members;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public GuildTeamState getState() {
        return state;
    }

    @Override
    public GuildTeamLadderResult getAggregate() {
        return aggregate;
    }

    @Override
    public Map<PvpLadder, GuildTeamLadderResult> getLadders() {
        return ladders;
    }
}
