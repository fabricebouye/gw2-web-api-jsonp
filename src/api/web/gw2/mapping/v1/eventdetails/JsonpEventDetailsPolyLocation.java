/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.eventdetails;

import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.NumericRange;
import api.web.gw2.mapping.core.Point2D;
import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of a poly event details location.
 * @author Fabrice Bouyé
 */
public final class JsonpEventDetailsPolyLocation extends JsonpEventDetailsLocation implements EventDetailsPolyLocation {

    private NumericRange<Double> zRange = new NumericRange<>(0d, 0d);
    @ListValue
    private List<Point2D> points = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpEventDetailsPolyLocation() {
    }

    @Override
    public NumericRange<Double> getZRange() {
        return zRange;
    }

    @Override
    public List<Point2D> getPoints() {
        return points;
    }
}
