/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
import java.util.Optional;

/**
 * Default JSON-P implementation of a trait prefix.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitPrefix implements TraitPrefix {

    @LocalizedResource
    private String text = "";
    @OptionalValue
    @URLValue
    private Optional<URL> icon = Optional.empty();
    @LocalizedResource
    private String status = "";
    @LocalizedResource
    private String description = "";

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Optional<URL> getIcon() {
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
