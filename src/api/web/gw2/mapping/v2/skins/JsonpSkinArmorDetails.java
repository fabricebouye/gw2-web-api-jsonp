/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.skins;

import api.web.gw2.mapping.core.EnumValue;

/**
 * Default JSON-P implementation of a skin armor details.
 * @author Fabrice Bouyé
 */
public final class JsonpSkinArmorDetails extends JsonpSkinDetails implements SkinArmorDetails {

    @EnumValue
    private SkinArmorType type = SkinArmorType.UNKNOWN;
    @EnumValue
    private SkinArmorWeightClass weightClass = SkinArmorWeightClass.UNKNOWN;

    /**
     * Creates a new instance.
     */
    public JsonpSkinArmorDetails() {
    }

    @Override
    public SkinArmorType getType() {
        return type;
    }

    @Override
    public SkinArmorWeightClass getWeightClass() {
        return weightClass;
    }
}
