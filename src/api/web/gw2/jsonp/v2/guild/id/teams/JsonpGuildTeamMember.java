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
import api.web.gw2.mapping.v2.guild.id.teams.GuildTeamMember;
import api.web.gw2.mapping.v2.guild.id.teams.GuildTeamMemberRole;

/**
 * Default JSON-P implementation of an guild team member.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildTeamMember implements GuildTeamMember {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String name = IdValue.DEFAULT_STRING_ID;
    @EnumValue
    private GuildTeamMemberRole role = GuildTeamMemberRole.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuildTeamMember() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public GuildTeamMemberRole getRole() {
        return role;
    }
}
