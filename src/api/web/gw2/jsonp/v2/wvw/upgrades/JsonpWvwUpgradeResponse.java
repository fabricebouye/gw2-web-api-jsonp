/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.wvw.upgrades;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.wvw.upgrades.WvwUpgradeResponse;
import api.web.gw2.mapping.v2.wvw.upgrades.WvwUpgradeTier;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a WvW upgrade response.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpWvwUpgradeResponse implements WvwUpgradeResponse {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @SetValue
    private Set<WvwUpgradeTier> tiers = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpWvwUpgradeResponse() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Set<WvwUpgradeTier> getTiers() {
        return tiers;
    }
}
