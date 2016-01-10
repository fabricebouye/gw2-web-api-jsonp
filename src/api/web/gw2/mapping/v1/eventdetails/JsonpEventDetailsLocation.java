/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.eventdetails;

import api.web.gw2.mapping.core.Coord3DValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.Point3D;

/**
 * Default JSON-P implementation of the location of the details of an event.
 * @author Fabrice Bouyé
 */
public abstract class JsonpEventDetailsLocation implements EventDetailsLocation {

    @EnumValue
    private EventDetailsLocationType type = EventDetailsLocationType.UNKNOWN;
    @Coord3DValue
    private Point3D center = Point3D.origin();

    /**
     * Creates a new empty instance.
     */
    public JsonpEventDetailsLocation() {
    }

    @Override
    public final EventDetailsLocationType getType() {
        return type;
    }

    @Override
    public final Point3D getCenter() {
        return center;
    }
}
