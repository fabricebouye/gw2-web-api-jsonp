/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.achievements;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of an achievement's item reward.
 * @author Fabrice Bouyé
 */
public final class JsonpAchievementItemReward extends JsonpAchievementReward implements AchievementItemReward {

    @IdValue
    private int id = -1;
    @QuantityValue
    private int count = 0;

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
