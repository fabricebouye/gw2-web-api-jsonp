/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.achievements.categories;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.achievements.categories.Category;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of an achievement category.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCategory implements Category {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @QuantityValue
    private int order = QuantityValue.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @SetValue
    private Set<Integer> achievements = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpCategory() {
    }

    @Override
    public int getId() {
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
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public Set<Integer> getAchievements() {
        return achievements;
    }

}
