/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.heroes;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.pvp.heroes.PvpHeroSkin;

/**
 * Default JSON-P implementation of a PvP hero skin.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpHeroSkin implements PvpHeroSkin {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    private boolean _default = false;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpHeroSkin() {
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
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public boolean isDefault() {
        return _default;
    }
}
