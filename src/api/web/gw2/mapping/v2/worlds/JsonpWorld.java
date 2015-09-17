/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.worlds;

import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a world.
 * @author Fabrice Bouyé
 */
public final class JsonpWorld implements World {

    @IdValue
    private int id = -1;
    private String name = "";

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
}
