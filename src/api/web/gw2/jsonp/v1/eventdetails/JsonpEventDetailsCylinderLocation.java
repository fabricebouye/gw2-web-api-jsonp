/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v1.eventdetails;

import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v1.eventdetails.EventDetailsCylinderLocation;

/**
 * Default JSON-P implementation of a cylinder event details location.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpEventDetailsCylinderLocation extends JsonpEventDetailsLocation implements EventDetailsCylinderLocation {

    private double height = QuantityValue.DEFAULT;
    private double radius = QuantityValue.DEFAULT;
    private double rotation = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpEventDetailsCylinderLocation() {
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getRotation() {
        return rotation;
    }

}
