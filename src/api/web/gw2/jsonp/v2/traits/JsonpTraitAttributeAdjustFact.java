/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.traits.TraitAttribute;
import api.web.gw2.mapping.v2.traits.TraitAttributeAdjustFact;

/**
 * Default JSON-P implementation of a trait attribute adjust fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitAttributeAdjustFact extends JsonpTraitFact implements TraitAttributeAdjustFact {

    @QuantityValue
    private int value = QuantityValue.DEFAULT;
    @EnumValue
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
