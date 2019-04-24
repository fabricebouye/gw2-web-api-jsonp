/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.wvw.matches;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.v2.wvw.matches.WvwMatchMapBonus;
import api.web.gw2.mapping.v2.wvw.matches.WvwMatchMapBonusType;
import api.web.gw2.mapping.v2.wvw.matches.WvwMatchTeam;

/**
 * Default JSON-P implementation of a match map bonus.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpWvwMatchMapBonus implements WvwMatchMapBonus {

    @EnumValue
    private WvwMatchMapBonusType type = WvwMatchMapBonusType.UNKNOWN;
    @EnumValue
    private WvwMatchTeam owner = WvwMatchTeam.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpWvwMatchMapBonus() {
    }

    @Override
    public WvwMatchMapBonusType getType() {
        return type;
    }

    @Override
    public WvwMatchTeam getOwner() {
        return owner;
    }
}
