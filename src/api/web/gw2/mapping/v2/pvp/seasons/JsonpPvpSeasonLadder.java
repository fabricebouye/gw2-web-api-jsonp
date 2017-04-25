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
public final class JsonpPvpSeasonLadder implements PvpSeasonLadder {

    private PvpSeasonLadderSettings settings;
    @SetValue
    private Set<PvpSeasonLadderScoring> scorings;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpSeasonLadder() {
    }

    @Override
    public PvpSeasonLadderSettings getSettings() {
        return settings;
    }

    @Override
    public Set<PvpSeasonLadderScoring> getScorings() {
        return scorings;
    }
}
