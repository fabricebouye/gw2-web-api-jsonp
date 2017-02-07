/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.eventdetails;

import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a sphere event details location.
 * @author Fabrice Bouyé
 */
public final class JsonptEventDetailsSphereLocation extends JsonpEventDetailsLocation implements EventDetailsSphereLocation {    
    private double radius = QuantityValue.DEFAULT;
    private double rotation = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    JsonptEventDetailsSphereLocation() {
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
