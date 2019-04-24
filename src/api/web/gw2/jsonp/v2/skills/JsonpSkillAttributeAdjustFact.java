/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.skills;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.skills.SkillAttribute;
import api.web.gw2.mapping.v2.skills.SkillAttributeAdjustFact;

/**
 * Default JSON-P implementation of a skill attribute adjust fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpSkillAttributeAdjustFact extends JsonpSkillFact implements SkillAttributeAdjustFact {

    @QuantityValue
    private int value = QuantityValue.DEFAULT;
    @EnumValue
    private SkillAttribute target = SkillAttribute.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpSkillAttributeAdjustFact() {
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public SkillAttribute getTarget() {
        return target;
    }
}
