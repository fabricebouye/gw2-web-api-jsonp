/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.skills;

import api.web.gw2.mapping.core.DurationValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.skills.SkillBuffFact;

import java.time.Duration;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a skill buff fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpSkillBuffFact extends JsonpSkillFact implements SkillBuffFact {

    @OptionalValue
    @DurationValue
    private Optional<Duration> duration = Optional.empty();
    private String status = LocalizedResource.DEFAULT;
    @OptionalValue
    @LocalizedResource
    private Optional<String> description = Optional.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt applyCount = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpSkillBuffFact() {
    }

    @Override
    public Optional<Duration> getDuration() {
        return duration;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public Optional<String> getDescription() {
        return description;
    }

    @Override
    public OptionalInt getApplyCount() {
        return applyCount;
    }
}
