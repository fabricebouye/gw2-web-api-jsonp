/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.achievements;

import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of an achievement's tier.
 * @author Fabrice Bouyé
 */
public final class JsonpAchievementTier implements AchievementTier {

    @QuantityValue
    private int count = QuantityValue.DEFAULT;
    @QuantityValue
    private int points = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpAchievementTier() {
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
