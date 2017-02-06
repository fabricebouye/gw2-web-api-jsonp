/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.seasons;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a PvP league season ladder's settings scoring tiers.
 * @author Fabrice Bouyé
 */
public final class JsonpSeasonLadderSettingsTier implements SeasonLadderSettingsTier {

    @SetValue
    private Set<Integer> range = Collections.EMPTY_SET;
    @OptionalValue
    private Optional<String> color = Optional.empty();
    @OptionalValue
    @EnumValue
    private Optional<SeasonLadderSettingsTierType> type = Optional.empty();
    @OptionalValue
    @LocalizedResource
    private Optional<String> name = Optional.empty();
            

    /**
     * Creates a new empty instance.
     */
    public JsonpSeasonLadderSettingsTier() {
    }

    @Override
    public Set<Integer> getRange() {
        return range;
    }

    @Override
    public Optional<String> getColor() {
        return color;
    }

    @Override
    public Optional<SeasonLadderSettingsTierType> getType() {
        return type;
    }

    @Override
    public Optional<String> getName() {
        return name;
    }
}
