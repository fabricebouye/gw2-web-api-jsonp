/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.seasons;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonLadderSettings;
import api.web.gw2.mapping.v2.pvp.seasons.PvpSeasonLadderSettingsTier;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a PvP league season ladder's settings.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpSeasonLadderSettings implements PvpSeasonLadderSettings {

    private String name = LocalizedResource.DEFAULT;
    @QuantityValue
    private int duration = QuantityValue.DEFAULT;
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String scoring = IdValue.DEFAULT_STRING_ID;
    @SetValue
    private Set<PvpSeasonLadderSettingsTier> tiers = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpSeasonLadderSettings() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getScoring() {
        return scoring;
    }

    @Override
    public Set<PvpSeasonLadderSettingsTier> getTiers() {
        return tiers;
    }

}
