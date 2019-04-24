/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.stories.seasons;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.stories.seasons.StorySeason;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a story season.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpStorySeason implements StorySeason {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @QuantityValue
    private int order = QuantityValue.DEFAULT;
    @SetValue
    @IdValue
    private Set<Integer> stories = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpStorySeason() {
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
    public int getOrder() {
        return order;
    }

    @Override
    public Set<Integer> getStories() {
        return stories;
    }
}
