/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.raids;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a raid wing event.
 * @author Fabrice Bouyé
 */
public final class JsonpRaidWingEvent implements RaidWingEvent {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @EnumValue
    private RaidWingEventType type = RaidWingEventType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpRaidWingEvent() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public RaidWingEventType getType() {
        return type;
    }
}
