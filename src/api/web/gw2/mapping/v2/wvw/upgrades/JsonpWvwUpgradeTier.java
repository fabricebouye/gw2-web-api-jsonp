/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.wvw.upgrades;

import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a WvW upgrade tier.
 * @author Fabrice Bouyé
 */
public final class JsonpWvwUpgradeTier implements WvwUpgradeTier {

    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @QuantityValue
    private int yaksRequired = QuantityValue.DEFAULT;
    @SetValue
    private Set<WvwUpgrade> upgrades = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpWvwUpgradeTier() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getYaksRequired() {
        return yaksRequired;
    }

    @Override
    public Set<WvwUpgrade> getUpgrades() {
        return upgrades;
    }
}
