/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
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
 * Default JSON-P implementation of a prefix buff fact.
 * @author Fabrice Bouyé
 */
public final class JsonpPrefixedBuffFact extends JsonpTraitFact implements TraitPrefixedBuffFact {

    @DurationValue
    private Duration duration = Duration.ZERO;
    @LocalizedResource
    private String status = "";
    @LocalizedResource
    private String description = "";
    @QuantityValue
    private int applyCount = 0;
    private TraitPrefix prefix = TraitPrefix.EMPTY;

    /**
     * Creates a new empty instance.
     */
    public JsonpPrefixedBuffFact() {
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

    @Override
    public TraitPrefix getPrefix() {
        return prefix;
    }
}
