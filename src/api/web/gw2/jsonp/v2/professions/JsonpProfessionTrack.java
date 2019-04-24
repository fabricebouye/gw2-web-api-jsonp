/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.professions;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.professions.ProfessionTrack;
import api.web.gw2.mapping.v2.professions.ProfessionTrackCategory;
import api.web.gw2.mapping.v2.professions.ProfessionTrackCost;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a profession track.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpProfessionTrack implements ProfessionTrack {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private ProfessionTrackCategory category = ProfessionTrackCategory.UNKNOWN;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @SetValue
    private Set<ProfessionTrackCost> track = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpProfessionTrack() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public ProfessionTrackCategory getCategory() {
        return category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<ProfessionTrackCost> getTrack() {
        return track;
    }
}
