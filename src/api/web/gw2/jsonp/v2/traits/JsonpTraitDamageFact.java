/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.traits.TraitDamageFact;

/**
 * Default JSON-P implementation of a trait damage fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitDamageFact extends JsonpTraitFact implements TraitDamageFact {

    @QuantityValue
    private int hitCount = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitDamageFact() {
    }

    @Override
    public int getHitCount() {
        return hitCount;
    }
}
