/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.PercentValue;

/**
 * Default JSON-P implementation of a trait buff conversion fact.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitBuffConversionFact extends JsonpTraitFact implements TraitBuffConversionFact {

    @PercentValue
    private int percent = 0;
    @EnumValue(factory = "api.web.gw2.mapping.v2.traits.TraitsUtils::findTraitAttribute") // NOI18N.
    private TraitAttribute source = TraitAttribute.UNKNOWN;
    @EnumValue(factory = "api.web.gw2.mapping.v2.traits.TraitsUtils::findTraitAttribute") // NOI18N.
    private TraitAttribute target = TraitAttribute.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitBuffConversionFact() {
    }

    @Override
    public int getPercent() {
        return percent;
    }

    @Override
    public TraitAttribute getSource() {
        return source;
    }

    @Override
    public TraitAttribute getTarget() {
        return target;
    }
}
