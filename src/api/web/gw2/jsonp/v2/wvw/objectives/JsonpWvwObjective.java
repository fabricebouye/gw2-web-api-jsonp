/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.wvw.objectives;

import api.web.gw2.mapping.core.Coord2DValue;
import api.web.gw2.mapping.core.Coord3DValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.Point2D;
import api.web.gw2.mapping.core.Point3D;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.wvw.WvwMapType;
import api.web.gw2.mapping.v2.wvw.objectives.WvwObjective;
import api.web.gw2.mapping.v2.wvw.objectives.WvwObjectiveType;

import java.util.OptionalInt;

/**
 * Default JSON-P implementation of an objective.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpWvwObjective implements WvwObjective {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @IdValue
    private int sectorId = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private WvwObjectiveType type = WvwObjectiveType.UNKNOWN;
    @EnumValue
    private WvwMapType mapType = WvwMapType.UNKNOWN;
    @IdValue
    private int mapId = IdValue.DEFAULT_INTEGER_ID;
    @Coord3DValue
    private Point3D coord = Point3D.origin();
    @Coord2DValue
    private Point2D labelCoord = Point2D.origin();
    @URLValue
    private URLReference marker = URLReference.empty();
    private String chatLink = LocalizedResource.DEFAULT;
    @IdValue
    @OptionalValue
    private OptionalInt upgradeId = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpWvwObjective() {
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
    public WvwObjectiveType getType() {
        return type;
    }

    @Override
    public WvwMapType getMapType() {
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

    @Override
    public String getChatLink() {
        return chatLink;
    }

    @Override
    public OptionalInt getUpgradeId() {
        return upgradeId;
    }
}
