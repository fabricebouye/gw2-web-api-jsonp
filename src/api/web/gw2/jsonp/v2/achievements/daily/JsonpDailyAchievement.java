/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.achievements.daily;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievement;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievementCampaign;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievementLevelRange;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a daily achievements.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpDailyAchievement implements DailyAchievement {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;

    private DailyAchievementLevelRange level = DailyAchievementLevelRange.ALL_LEVELS;

    @SetValue
    @EnumValue
    private Set<DailyAchievementCampaign> requiredAccess = Collections.EMPTY_SET;

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

    @Override
    public Set<DailyAchievementCampaign> getRequiredAccess() {
        return requiredAccess;
    }
}
