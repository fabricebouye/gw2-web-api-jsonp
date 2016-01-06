/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.wvw.objectives;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.Point2D;
import api.web.gw2.mapping.core.Point3D;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.wvw.MapType;
import java.net.URL;
import java.util.Optional;

/**
 * Default JSON-P implementation of an objective.
 * @author Fabrice Bouyé
 */
public final class JsonpObjective implements Objective {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = "";
    @LocalizedResource
    private String name = "";
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String sectorId = "";
    @EnumValue
    private ObjectiveType type = ObjectiveType.UNKNOWN;
    @EnumValue
    private MapType mapType = MapType.UNKNOWN;
    @IdValue
    private int mapId = -1;
    private Point3D<Double> coord = new Point3D<>(0d, 0d, 0d);
    private Point2D<Double> labelCoord = new Point2D<>(0d, 0d);
    @URLValue
    @OptionalValue
    private Optional<URL> marker = Optional.empty();

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
    public String getSectorId() {
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
    public Point3D<Double> getCoord() {
        return coord;
    }

    @Override
    public Optional<URL> getMarker() {
        return marker;
    }

    @Override
    public Point2D<Double> getLabelCoord() {
        return labelCoord;
    }
}
