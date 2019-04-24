/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v1.eventdetails;

import api.web.gw2.jsonp.core.RuntimeType;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v1.eventdetails.EventDetails;
import api.web.gw2.mapping.v1.eventdetails.EventDetailsFlag;
import api.web.gw2.mapping.v1.eventdetails.EventDetailsLocation;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of the details of an event.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpEventDetails implements EventDetails {

    private String name = LocalizedResource.DEFAULT;
    @LevelValue
    private int level = LevelValue.MIN_LEVEL;
    @IdValue
    private int mapId = IdValue.DEFAULT_INTEGER_ID;
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
