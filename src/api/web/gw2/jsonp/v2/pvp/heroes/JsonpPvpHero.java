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
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.pvp.heroes.PvpHero;
import api.web.gw2.mapping.v2.pvp.heroes.PvpHeroSkin;
import api.web.gw2.mapping.v2.pvp.heroes.PvpHeroStat;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Default JSON-P implementation of a PvP hero skin.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpHero implements PvpHero {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String type = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @MapValue
    private Map<PvpHeroStat, Integer> stats = Collections.EMPTY_MAP;
    @URLValue
    private URLReference overlay = URLReference.empty();
    @URLValue
    private URLReference underlay = URLReference.empty();
    @SetValue
    private Set<PvpHeroSkin> skins = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance;
     */
    public JsonpPvpHero() {
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
    public String getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Map<PvpHeroStat, Integer> getStats() {
        return stats;
    }

    @Override
    public URLReference getOverlay() {
        return overlay;
    }

    @Override
    public URLReference getUnderlay() {
        return underlay;
    }

    @Override
    public Set<PvpHeroSkin> getSkins() {
        return skins;
    }
}
