/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.mounts.skins;

import api.web.gw2.mapping.core.*;
import api.web.gw2.mapping.v2.mounts.skins.MountSkin;
import api.web.gw2.mapping.v2.mounts.skins.MountSkinDyeSlot;
import api.web.gw2.mapping.v2.mounts.types.MountType;

import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of a mount skin.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpMountSkin implements MountSkin {
    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @ListValue
    private List<MountSkinDyeSlot> dyeSlots = Collections.EMPTY_LIST;
    @EnumValue
    private MountType mount = MountType.UNKNOWN;

    /**
     * Creates an empty instance.
     */
    public JsonpMountSkin() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public List<MountSkinDyeSlot> getDyeSlots() {
        return dyeSlots;
    }

    @Override
    public MountType getMount() {
        return mount;
    }
}
