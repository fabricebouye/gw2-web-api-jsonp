/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.skills;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.PercentValue;

/**
 * Default JSON-P implementation of a skill combo finisher fact.
 * @author Fabrice Bouyé
 */
public final class JsonpSkillComboFinisherFact extends JsonpSkillFact implements SkillComboFinisherFact {

    @PercentValue
    private int percent = PercentValue.DEFAULT;
    @EnumValue
    private SkillComboFinisherType finisherType = SkillComboFinisherType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpSkillComboFinisherFact() {
    }

    @Override
    public int getPercent() {
        return percent;
    }

    @Override
    public SkillComboFinisherType getFinisherType() {
        return finisherType;
    }
}
