/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.skills;

import api.web.gw2.mapping.core.EnumValue;

/**
 * Default JSON-P implementation of a skill combo field fact.
 * @author Fabrice Bouyé
 */
public final class JsonpSkillComboFieldFact extends JsonpSkillFact implements SkillComboFieldFact {

    @EnumValue
    private SkillComboFieldType fieldType = SkillComboFieldType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpSkillComboFieldFact() {
    }

    @Override
    public SkillComboFieldType getFieldType() {
        return fieldType;
    }
}
