/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.account.mastery.points;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.account.mastery.points.AccountMasteryPointsTotal;
import api.web.gw2.mapping.v2.masteries.MasteryRegion;

/**
 * Default JSON-P implementation of an account mastery points total.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpAccountMasteryPointsTotal implements AccountMasteryPointsTotal {

    @EnumValue
    private MasteryRegion region = MasteryRegion.UNKNOWN;
    @QuantityValue
    private int spent = QuantityValue.DEFAULT;
    @QuantityValue
    private int earned = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpAccountMasteryPointsTotal() {
    }

    @Override
    public MasteryRegion getRegion() {
        return region;
    }

    @Override
    public int getSpent() {
        return spent;
    }

    @Override
    public int getEarned() {
        return earned;
    }
}
