/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.traits.TraitDistanceFact;

/**
 * Default JSON-P implementation of a trait distance fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitDistanceFact extends JsonpTraitFact implements TraitDistanceFact {

    @QuantityValue
    private int distance = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitDistanceFact() {
    }

    @Override
    public int getDistance() {
        return distance;
    }
}
