/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.achievements.daily;

import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a daily achievements.
 * @author Fabrice Bouyé
 */
public final class JsonpDailyAchievement implements DailyAchievement {

    @IdValue
    private int id = -1;

    private DailyAchievementLevelRange level = DailyAchievementLevelRange.ALL_LEVELS;

    /**
     * Creates a new empty instance.
     */
    public JsonpDailyAchievement() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public DailyAchievementLevelRange getLevel() {
        return level;
    }
}
