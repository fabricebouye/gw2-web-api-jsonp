/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.eventdetails;

/**
 * Default JSON-P implementation of a cylinder event details location.
 * @author Fabrice Bouyé
 */
public final class JsonptEventDetailsCylinderLocation extends JsonpEventDetailsLocation implements EventDetailsCylinderLocation {
    private double height = 0;
    private double radius = 0;
    private double rotation = 0;
    
    /**
     * Creates a new empty instance.
     */
    public JsonptEventDetailsCylinderLocation() {
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
