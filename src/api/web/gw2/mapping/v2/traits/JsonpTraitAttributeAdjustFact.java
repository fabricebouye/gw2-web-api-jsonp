/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a trait attribute adjust fact.
 */
public final class JsonpTraitAttributeAdjustFact extends JsonpTraitFact implements TraitAttributeAdjustFact {

    @QuantityValue
    private int value = 0;
    @EnumValue(factory = "api.web.gw2.mapping.v2.traits.TraitsUtils::findTraitAttribute") // NOI18N.
    private TraitAttribute target = TraitAttribute.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitAttributeAdjustFact() {
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public TraitAttribute getTarget() {
        return target;
    }
}