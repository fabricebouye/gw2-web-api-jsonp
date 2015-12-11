/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a trait number fact.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitNumberFact extends JsonpTraitFact implements TraitNumberFact {

    @QuantityValue
    private int value = 0;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitNumberFact() {
    }

    @Override
    public int getValue() {
        return value;
    }
}
