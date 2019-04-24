/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.account.mastery.points;

import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.account.mastery.points.AccountMasteryPoints;
import api.web.gw2.mapping.v2.account.mastery.points.AccountMasteryPointsTotal;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of an account mastery points report.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpAccountMasteryPoints implements AccountMasteryPoints {

    @SetValue
    private Set<AccountMasteryPointsTotal> totals = Collections.EMPTY_SET;
    @SetValue
    private Set<Integer> unlocked = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpAccountMasteryPoints() {
    }

    @Override
    public Set<AccountMasteryPointsTotal> getTotals() {
        return totals;
    }

    @Override
    public Set<Integer> getUnlocked() {
        return unlocked;
    }
}
