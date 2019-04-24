/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.skills;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.skills.SkillFactType;
import api.web.gw2.mapping.v2.skills.SkillTraitedFact;

import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a skill traited fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpSkillTraitedFact implements SkillTraitedFact {

    @LocalizedResource
    private String text = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @EnumValue
    private SkillFactType type = SkillFactType.UNKNOWN;
    @IdValue
    private int requiredTrait = IdValue.DEFAULT_INTEGER_ID;
    @OptionalValue
    @QuantityValue
    private OptionalInt overrides = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpSkillTraitedFact() {
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public SkillFactType getType() {
        return type;
    }

    @Override
    public int getRequiredTrait() {
        return requiredTrait;
    }

    @Override
    public OptionalInt getOverrides() {
        return overrides;
    }
}
