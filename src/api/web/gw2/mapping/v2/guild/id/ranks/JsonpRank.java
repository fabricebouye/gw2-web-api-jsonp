/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.ranks;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.guild.permissions.PermissionId;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a guild rank.
 * @author Fabrice Bouyé
 */
public final class JsonpRank implements Rank {

    @IdValue
    private String id = "";
    @QuantityValue
    private int order = 0;
    @SetValue
    @EnumValue
    private Set<PermissionId> permissions = Collections.EMPTY_SET;
    @URLValue
    private URLReference icon = URLReference.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpRank() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public Set<PermissionId> getPermissions() {
        return permissions;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }
}
