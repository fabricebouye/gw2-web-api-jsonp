/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.SetValue;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of an account.
 * @author Fabrice Bouyé
 */
public final class JsonpAccount implements Account {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = "";
    private String name = "";
    @IdValue
    private int world = -1;
    @SetValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Set<String> guilds = Collections.EMPTY_SET;
    @DateValue
    private ZonedDateTime created = DateValue.DEFAULT;
    @EnumValue
    private AccountAccessType access = AccountAccessType.UNKNOWN;
    @LevelValue
    private int fractalLevel = 1;

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

    @Override
    public ZonedDateTime getCreated() {
        return created;
    }

    @Override
    public AccountAccessType getAccess() {
        return access;
    }

    @Override
    public int getFractalLevel() {
        return fractalLevel;
    }
}
