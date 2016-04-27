/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.teams;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of an guild team member.
 * @author Fabrice Bouyé
 */
public final class JsonpTeamMember implements TeamMember {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String name = ""; // NOI18N.
    @EnumValue
    private TeamMemberRole role = TeamMemberRole.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpTeamMember() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TeamMemberRole getRole() {
        return role;
    }
}
