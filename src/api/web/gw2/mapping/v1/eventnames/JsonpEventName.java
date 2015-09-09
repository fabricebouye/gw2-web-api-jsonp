/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.eventnames;

import api.web.gw2.mapping.core.IdValue;

/**
 * Default implementation of the name of an event.
 * @author Fabrice Bouyé
 */
public final class JsonpEventName implements EventName {
    @IdValue
    String id = "";
    String name = "";

    /**
     * Creates a new empty instance.
     */
    JsonpEventName() {
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
