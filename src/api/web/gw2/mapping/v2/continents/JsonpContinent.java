/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.continents;

import api.web.gw2.mapping.core.ContinentDimensions;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a continent.
 * @author Fabrice Bouyé
 */
public final class JsonpContinent implements Continent {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = "";
    @LocalizedResource
    private String name = "";
    private ContinentDimensions continentDims = ContinentDimensions.EMPTY;
    @QuantityValue
    private int minZoom = 0;
    @QuantityValue
    private int maxZoom = 0;
    @SetValue
    @IdValue
    private Set<Integer> floors = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpContinent() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ContinentDimensions getContinentDims() {
        return continentDims;
    }

    @Override
    public int getMinZoom() {
        return minZoom;
    }

    @Override
    public int getMaxZoom() {
        return maxZoom;
    }

    @Override
    public Set<Integer> getFloors() {
        return floors;
    }
}
