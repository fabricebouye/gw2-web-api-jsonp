/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.PercentValue;
import api.web.gw2.mapping.v2.traits.TraitComboFinisherFact;
import api.web.gw2.mapping.v2.traits.TraitComboFinisherType;

/**
 * Default JSON-P implementation of a trait combo finisher fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitComboFinisherFact extends JsonpTraitFact implements TraitComboFinisherFact {

    @PercentValue
    private int percent = PercentValue.DEFAULT;
    @EnumValue
    private TraitComboFinisherType finisherType = TraitComboFinisherType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitComboFinisherFact() {
    }

    @Override
    public int getPercent() {
        return percent;
    }

    @Override
    public TraitComboFinisherType getFinisherType() {
        return finisherType;
    }
}
