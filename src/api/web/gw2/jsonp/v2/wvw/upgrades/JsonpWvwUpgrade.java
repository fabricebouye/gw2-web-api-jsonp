/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.wvw.upgrades;

import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.wvw.upgrades.WvwUpgrade;

/**
 * Default JSON-P implementation of a WvW upgrade.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpWvwUpgrade implements WvwUpgrade {

    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpWvwUpgrade() {
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
    public URLReference getIcon() {
        return icon;
    }
}
