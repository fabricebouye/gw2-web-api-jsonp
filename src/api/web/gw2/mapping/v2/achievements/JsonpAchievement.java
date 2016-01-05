/* 
 * Copyright (C) 2015 Fabrice Bouyé
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
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
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
    @OptionalValue
    private Optional<URL> icon = Optional.empty();
    @LocalizedResource
    private String name = "";
    @LocalizedResource
    private String description = "";
    @LocalizedResource
    private String requirement = "";
    @EnumValue
    private AchievementType type = AchievementType.UNKNOWN;
    @SetValue
    @EnumValue
    private Set<AchievementFlag> flags = Collections.EMPTY_SET;

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
    public Optional<URL> getIcon() {
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

}
