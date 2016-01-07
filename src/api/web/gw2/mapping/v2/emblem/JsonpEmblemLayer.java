/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.emblem;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a guild emblem.
 * @author Fabrice Bouyé
 */
public class JsonpEmblemLayer implements EmblemLayer {

    @IdValue
    private int id = -1;
    @SetValue
    @OptionalValue
    @URLValue
    private Set<Optional<URL>> layers = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpEmblemLayer() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Set<Optional<URL>> getLayers() {
        return layers;
    }
}
