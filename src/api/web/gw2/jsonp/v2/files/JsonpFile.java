/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.files;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.files.File;

/**
 * Default JSON-P implementation of a file.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpFile implements File {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @URLValue
    private URLReference icon = URLReference.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpFile() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }
}
