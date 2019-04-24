/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.achievements;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.achievements.AchievementItemReward;

/**
 * Default JSON-P implementation of an achievement's item reward.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpAchievementItemReward extends JsonpAchievementReward implements AchievementItemReward {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpAchievementItemReward() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCount() {
        return count;
    }
}
