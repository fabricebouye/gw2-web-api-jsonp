/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.eventdetails;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.RuntimeType;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of the details of an event.
 * @author Fabrice Bouyé
 */
public final class JsonpEventDetails implements EventDetails {

    private String name = ""; // NOI18N.
    @LevelValue
    private int level = -1;
    @IdValue
    private int mapId = -1;
    @SetValue
    private Set<EventDetailsFlag> flags = Collections.EMPTY_SET;
    @RuntimeType(selector = "type", pattern = "EventDetails%sLocation") // NOI18N.
    private EventDetailsLocation location;

    /**
     * Creates a new empty instance.
     */
    public JsonpEventDetails() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getMapId() {
        return mapId;
    }

    @Override
    public Set<EventDetailsFlag> getFlags() {
        return flags;
    }

    @Override
    public EventDetailsLocation getLocation() {
        return location;
    }
}
