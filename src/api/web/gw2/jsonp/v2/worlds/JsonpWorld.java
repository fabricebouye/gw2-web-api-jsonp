/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.worlds;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.v2.worlds.World;
import api.web.gw2.mapping.v2.worlds.WorldPopulation;

/**
 * Default JSON-P implementation of a world.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpWorld implements World {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @EnumValue
    private WorldPopulation population = WorldPopulation.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpWorld() {
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
    public WorldPopulation getPopulation() {
        return population;
    }
}
