/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.build;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.v2.build.Build;

/**
 * Default JSON-P implementation of a build.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpBuild implements Build {
    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;

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