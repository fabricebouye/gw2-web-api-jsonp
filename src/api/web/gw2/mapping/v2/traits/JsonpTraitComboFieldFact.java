/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.EnumValue;

/**
 * Default JSON-P implementation of a trait combo field fact.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitComboFieldFact extends JsonpTraitFact implements TraitComboFieldFact {

    @EnumValue
    private TraitComboFieldType fieldType = TraitComboFieldType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitComboFieldFact() {
    }

    @Override
    public TraitComboFieldType getFieldType() {
        return fieldType;
    }
}
