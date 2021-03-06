/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.PercentValue;
import api.web.gw2.mapping.v2.traits.TraitAttribute;
import api.web.gw2.mapping.v2.traits.TraitBuffConversionFact;

/**
 * Default JSON-P implementation of a trait buff conversion fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitBuffConversionFact extends JsonpTraitFact implements TraitBuffConversionFact {

    @PercentValue
    private int percent = PercentValue.DEFAULT;
    @EnumValue
    private TraitAttribute source = TraitAttribute.UNKNOWN;
    @EnumValue
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
