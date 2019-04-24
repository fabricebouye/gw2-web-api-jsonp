/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.gliders;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.gliders.Glider;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Default JSON-P implementation of a glider.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpGlider implements Glider {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    @SetValue
    private Set<Integer> unlockItems = Collections.EMPTY_SET;
    @QuantityValue
    private int order = QuantityValue.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @IdValue
    @ListValue
    private List<Integer> defaultDyes = Collections.EMPTY_LIST;

    /**
     * Creates an empty instance.
     */
    public JsonpGlider() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Set<Integer> getUnlockItems() {
        return unlockItems;
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
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Integer> getDefaultDyes() {
        return defaultDyes;
    }
}
