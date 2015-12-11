/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.DurationValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import java.time.Duration;

/**
 * Default JSON-P implementation of a trait buff fact.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitBuffFact extends JsonpTraitFact implements TraitBuffFact {

    @DurationValue
    private Duration duration = Duration.ZERO;
    @LocalizedResource
    private String status = "";
    @LocalizedResource
    private String description = "";
    @QuantityValue
    private int applyCount = 0;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitBuffFact() {
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getApplyCount() {
        return applyCount;
    }
}
