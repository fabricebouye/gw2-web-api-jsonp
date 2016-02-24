/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.achievements.daily;

import api.web.gw2.mapping.core.LevelValue;

/**
 * Default JSON-P implementation of a level range for daily achievements.
 * @author Fabrice Bouyé
 */
public final class JsonpDailyAchievementLevelRange implements DailyAchievementLevelRange {

    @LevelValue
    private int min = LevelValue.MIN_LEVEL;
    @LevelValue
    private int max = LevelValue.MAX_LEVEL;

    /**
     * Creates a new empty instance.
     */
    public JsonpDailyAchievementLevelRange() {
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof DailyAchievementLevelRange) {
            result = equals((DailyAchievementLevelRange) obj);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return hashValues();
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }
}
