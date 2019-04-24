/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.achievements;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.v2.achievements.AchievementReward;
import api.web.gw2.mapping.v2.achievements.AchievementRewardType;

/**
 * Default JSON-P implementation of an achievement's reward.
 *
 * @author Fabrice Bouyé
 */
public abstract class JsonpAchievementReward implements AchievementReward {
    @EnumValue
    private AchievementRewardType type = AchievementRewardType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpAchievementReward() {
    }

    @Override
    public AchievementRewardType getType() {
        return type;
    }
}
