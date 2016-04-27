/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;

/**
 * Default JSON-P implementation of a trait prefix.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitPrefix implements TraitPrefix {

    @LocalizedResource
    private String text = ""; // NOI18N.
    @URLValue
    private URLReference icon = URLReference.empty();
    @LocalizedResource
    private String status = ""; // NOI18N.
    @LocalizedResource
    private String description = ""; // NOI18N.

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
