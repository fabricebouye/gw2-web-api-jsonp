/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.wvw.matches;

import api.web.gw2.mapping.core.EnumValue;

/**
 * Default JSON-P implementation of a match map bonus.
 * @author Fabrice Bouyé
 */
public final class JsonpMatchMapBonus implements MatchMapBonus {

    @EnumValue
    private MatchMapBonusType type = MatchMapBonusType.UNKNOWN;
    @EnumValue
    private MatchTeam owner = MatchTeam.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpMatchMapBonus() {
    }

    @Override
    public MatchMapBonusType getType() {
        return type;
    }

    @Override
    public MatchTeam getOwner() {
        return owner;
    }
}
