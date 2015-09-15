/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account;

import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default implementation of an account.
 * @author Fabrice Bouyé
 */
public final class JsonpAccount implements Account {

    String id = "";
    String name = "";
    int world = -1;
    @SetValue
    Set<String> guilds = Collections.EMPTY_SET;

    /**
     * Creates an empty instance.
     */
    public JsonpAccount() {
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
    public int getWorld() {
        return world;
    }

    @Override
    public Set<String> getGuilds() {
        return guilds;
    }
}
