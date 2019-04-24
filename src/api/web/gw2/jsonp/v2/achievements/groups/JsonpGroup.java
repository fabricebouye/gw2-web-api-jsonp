/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.achievements.groups;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.achievements.groups.Group;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of an achievement category group.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGroup implements Group {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @QuantityValue
    private int order = QuantityValue.DEFAULT;
    @SetValue
    private Set<Integer> categories = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpGroup() {
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
    public String getDescription() {
        return description;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public Set<Integer> getCategories() {
        return categories;
    }
}
