/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.mounts.skins;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.v2.mounts.skins.MountDyeSlotMaterial;
import api.web.gw2.mapping.v2.mounts.skins.MountSkinDyeSlot;

/**
 * Default JSON-P implementation of a mount skin dye slot.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpMountSkinDyeSlot implements MountSkinDyeSlot {
    @IdValue
    private int colorId = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private MountDyeSlotMaterial material = MountDyeSlotMaterial.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpMountSkinDyeSlot() {
    }

    @Override
    public int getColorId() {
        return colorId;
    }

    @Override
    public MountDyeSlotMaterial getMaterial() {
        return material;
    }
}
