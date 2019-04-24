/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.guild.permissions;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.v2.guild.permissions.GuildPermission;
import api.web.gw2.mapping.v2.guild.permissions.GuildPermissionId;

/**
 * Default JSON-P implementation of a guild permission.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGuildPermission implements GuildPermission {

    @IdValue
    @EnumValue
    private GuildPermissionId id = GuildPermissionId.UNKNOWN;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuildPermission() {
    }

    @Override
    public GuildPermissionId getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
