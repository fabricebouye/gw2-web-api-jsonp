/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.DurationValue;
import java.time.Duration;

/**
 * Default JSON-P implementation of a trait time fact.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitTimeFact extends JsonpTraitFact implements TraitTimeFact {

    @DurationValue
    private Duration duration = DurationValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitTimeFact() {
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

}
