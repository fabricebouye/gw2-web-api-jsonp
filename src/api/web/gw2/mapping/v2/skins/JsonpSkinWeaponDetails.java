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
 * Default JSON-P implementation of a skin weapon details.
 * @author Fabrice Bouyé
 */
public final class JsonpSkinWeaponDetails extends JsonpSkinDetails implements SkinWeaponDetails {

    @EnumValue
    private SkinWeaponType type = SkinWeaponType.UNKNOWN;
    @EnumValue
    private SkinWeaponDamageType damageType = SkinWeaponDamageType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpSkinWeaponDetails() {
    }

    @Override
    public SkinWeaponType getType() {
        return type;
    }

    @Override
    public SkinWeaponDamageType getDamageType() {
        return damageType;
    }
}
