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
 * Default JSON-P implementation of a trait combo finisher fact.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitComboFinisherFact extends JsonpTraitFact implements TraitComboFinisherFact {

    @PercentValue
    private int percent = 0;
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
