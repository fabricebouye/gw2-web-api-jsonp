/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.ranks;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.pvp.ranks.PvpRank;
import api.web.gw2.mapping.v2.pvp.ranks.PvpRankLevel;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a PvP rank.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpRank implements PvpRank {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    private int finisherId = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @LevelValue
    private int minRank = LevelValue.MIN_LEVEL;
    @LevelValue
    private int maxRank = LevelValue.MIN_LEVEL;
    @SetValue
    private Set<PvpRankLevel> levels = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpRank() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getFinisherId() {
        return finisherId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public int getMinRank() {
        return minRank;
    }

    @Override
    public int getMaxRank() {
        return maxRank;
    }

    @Override
    public Set<PvpRankLevel> getLevels() {
        return levels;
    }

}
