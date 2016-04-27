/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.achievements;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.RuntimeType;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of an achievements.
 * @author Fabrice Bouyé
 */
public final class JsonpAchievement implements Achievement {

    @IdValue
    private int id = -1;
    @URLValue
    private URLReference icon = URLReference.empty();
    @LocalizedResource
    private String name = ""; // NOI18N.
    @LocalizedResource
    private String description = ""; // NOI18N.
    @LocalizedResource
    private String requirement = ""; // NOI18N.
    @EnumValue
    private AchievementType type = AchievementType.UNKNOWN;
    @SetValue
    @EnumValue
    private Set<AchievementFlag> flags = Collections.EMPTY_SET;
    @SetValue
    private Set<AchievementTier> tiers = Collections.EMPTY_SET;
    @OptionalValue
    @SetValue
    @RuntimeType(selector = "type", pattern = "Achievement%sReward") // NOI18N.
    private Optional<Set<AchievementReward>> rewards = Optional.empty();
    @OptionalValue
    @SetValue
    private Optional<Set<AchievementBit>> bits = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpAchievement() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getRequirement() {
        return requirement;
    }

    @Override
    public AchievementType getType() {
        return type;
    }

    @Override
    public Set<AchievementFlag> getFlags() {
        return flags;
    }

    @Override
    public Set<AchievementTier> getTiers() {
        return tiers;
    }

    @Override
    public Optional<Set<AchievementReward>> getRewards() {
        return rewards;
    }

    @Override
    public Optional<Set<AchievementBit>> getBits() {
        return bits;
    }
}
