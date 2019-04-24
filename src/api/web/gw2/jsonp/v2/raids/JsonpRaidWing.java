/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.raids;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.raids.RaidWing;
import api.web.gw2.mapping.v2.raids.RaidWingEvent;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a raid wing.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpRaidWing implements RaidWing {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @SetValue
    private Set<RaidWingEvent> events = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpRaidWing() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Set<RaidWingEvent> getEvents() {
        return events;
    }
}
