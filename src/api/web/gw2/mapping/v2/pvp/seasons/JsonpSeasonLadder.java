/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.seasons;

import api.web.gw2.mapping.core.SetValue;
import java.util.Set;

/**
 * Default JSON-P implementation of a PvP league season ladder.
 * @author Fabrice Bouyé
 */
public final class JsonpSeasonLadder implements SeasonLadder {

    private SeasonLadderSettings settings;
    @SetValue
    private Set<SeasonLadderScoring> scorings;

    /**
     * Creates a new empty instance.
     */
    public JsonpSeasonLadder() {
    }

    @Override
    public SeasonLadderSettings getSettings() {
        return settings;
    }

    @Override
    public Set<SeasonLadderScoring> getScorings() {
        return scorings;
    }
}
