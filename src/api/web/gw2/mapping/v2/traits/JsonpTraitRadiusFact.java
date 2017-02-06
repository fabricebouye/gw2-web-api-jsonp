/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a trait radius fact.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitRadiusFact extends JsonpTraitFact implements TraitRadiusFact {

    @QuantityValue
    private int distance = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitRadiusFact() {
    }

    @Override
    public int getDistance() {
        return distance;
    }
}
