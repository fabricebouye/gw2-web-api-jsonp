/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.build;

import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a build.
 * @author Fabrice Bouyé
 */
public final class JsonpBuild implements Build {
    @IdValue
    private int id = -1;

    /**
     * Creates a new empty instance.
     */
    public JsonpBuild() {
    }

    @Override
    public int getId() {
        return id;
    }
}
