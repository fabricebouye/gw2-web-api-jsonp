/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.tokeninfo;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a token info.
 * @author Fabrice Bouyé
 */
public final class JsonpTokenInfo implements TokenInfo {

    @IdValue
    private String id = "";
    private String name = "";
    @SetValue
    private Set<TokenInfoPermission> permissions = Collections.EMPTY_SET;

    /**
     * Creates an empty instance.
     */
    public JsonpTokenInfo() {
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
    public Set<TokenInfoPermission> getPermissions() {
        return permissions;
    }
}