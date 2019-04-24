/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.core.DurationValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.traits.TraitPrefix;
import api.web.gw2.mapping.v2.traits.TraitPrefixedBuffFact;

import java.time.Duration;

/**
 * Default JSON-P implementation of a trait prefixed buff fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitPrefixedBuffFact extends JsonpTraitFact implements TraitPrefixedBuffFact {

    @DurationValue
    private Duration duration = DurationValue.DEFAULT;
    @LocalizedResource
    private String status = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @QuantityValue
    private int applyCount = QuantityValue.DEFAULT;
    private TraitPrefix prefix = TraitPrefix.EMPTY;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitPrefixedBuffFact() {
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
