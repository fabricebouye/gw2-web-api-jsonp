/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.items;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.v2.items.ItemBuff;

/**
 * Default JSON-P implementation of a buff.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpItemBuff implements ItemBuff {

    @IdValue
    private int skillId = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpItemBuff() {
    }

    @Override
    public int getSkillId() {
        return skillId;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
