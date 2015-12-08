/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.eventnames;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;

/**
 * Default JSON-P implementation of the name of an event.
 * @author Fabrice Bouyé
 */
public final class JsonpEventName implements EventName {
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = "";
    @LocalizedResource
    private String name = "";

    /**
     * Creates a new empty instance.
     */
    public JsonpEventName() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
