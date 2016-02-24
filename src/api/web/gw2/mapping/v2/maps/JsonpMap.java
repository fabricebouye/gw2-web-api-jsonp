/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.maps;

import api.web.gw2.mapping.core.ContinentBounds;
import api.web.gw2.mapping.core.ContinentRect;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.MapBounds;
import api.web.gw2.mapping.core.MapRect;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a map.
 * @author Fabrice Bouyé
 */
public final class JsonpMap implements Map {

    @IdValue
    private int id = -1;
    @LocalizedResource
    private String name = "";
    @LevelValue
    private int minLevel = LevelValue.MIN_LEVEL;
    @LevelValue
    private int maxLevel = LevelValue.MIN_LEVEL;
    @IdValue
    private int defaultFloor = -1;
    @IdValue
    @SetValue
    private Set<Integer> floors = Collections.EMPTY_SET;
    @IdValue
    private int continentId = -1;
    @LocalizedResource
    private String continentName = "";
    @IdValue
    private int regionId = -1;
    @LocalizedResource
    private String regionName = "";
    @MapRect
    private MapBounds mapRect = MapBounds.empty();
    @ContinentRect
    private ContinentBounds continentRect = ContinentBounds.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpMap() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMinLevel() {
        return minLevel;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public int getDefaultFloor() {
        return defaultFloor;
    }

    @Override
    public Set<Integer> getFloors() {
        return floors;
    }

    @Override
    public int getContinentId() {
        return continentId;
    }

    @Override
    public String getContinentName() {
        return continentName;
    }

    @Override
    public int getRegionId() {
        return regionId;
    }

    @Override
    public String getRegionName() {
        return regionName;
    }

    @Override
    public MapBounds getMapRect() {
        return mapRect;
    }

    @Override
    public ContinentBounds getContinentRect() {
        return continentRect;
    }

}
