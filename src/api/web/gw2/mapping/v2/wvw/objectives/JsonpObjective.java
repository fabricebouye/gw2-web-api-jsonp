/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.wvw.objectives;

import api.web.gw2.mapping.core.Coord2DValue;
import api.web.gw2.mapping.core.Coord3DValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.Point2D;
import api.web.gw2.mapping.core.Point3D;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.wvw.MapType;

/**
 * Default JSON-P implementation of an objective.
 * @author Fabrice Bouyé
 */
public final class JsonpObjective implements Objective {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @IdValue
    private int sectorId = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private ObjectiveType type = ObjectiveType.UNKNOWN;
    @EnumValue
    private MapType mapType = MapType.UNKNOWN;
    @IdValue
    private int mapId = IdValue.DEFAULT_INTEGER_ID;
    @Coord3DValue
    private Point3D coord = Point3D.origin();
    @Coord2DValue
    private Point2D labelCoord = Point2D.origin();
    @URLValue
    private URLReference marker = URLReference.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpObjective() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSectorId() {
        return sectorId;
    }

    @Override
    public ObjectiveType getType() {
        return type;
    }

    @Override
    public MapType getMapType() {
        return mapType;
    }

    @Override
    public int getMapId() {
        return mapId;
    }

    @Override
    public Point3D getCoord() {
        return coord;
    }

    @Override
    public URLReference getMarker() {
        return marker;
    }

    @Override
    public Point2D getLabelCoord() {
        return labelCoord;
    }
}
