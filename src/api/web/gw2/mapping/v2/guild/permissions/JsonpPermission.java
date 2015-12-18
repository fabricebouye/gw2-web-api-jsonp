/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.permissions;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;

/**
 * Default JSON-P implementation of a guild permission.
 * @author Fabrice Bouyé
 */
public final class JsonpPermission implements Permission {

    @IdValue
    @EnumValue(factory = "api.web.gw2.mapping.v2.guild.permissions.PermissionsUtils::findPermissionId") // NOI18N.
    private PermissionId id = PermissionId.UNKNOWN;
    @LocalizedResource
    private String name = ""; // NOI18N.
    @LocalizedResource
    private String description = ""; // NOI18N.

    /**
     * Creates a new empty instance.
     */
    public JsonpPermission() {
    }

    @Override
    public PermissionId getId() {
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
