/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.traits.TraitPrefix;

/**
 * Default JSON-P implementation of a trait prefix.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitPrefix implements TraitPrefix {

    @LocalizedResource
    private String text = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @LocalizedResource
    private String status = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
