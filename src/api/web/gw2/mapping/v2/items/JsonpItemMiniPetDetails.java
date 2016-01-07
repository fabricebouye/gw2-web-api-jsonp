/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a minipet details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemMiniPetDetails extends JsonpItemDetails implements ItemMiniPetDetails {

    @IdValue
    private int minipetId = -1;

    public JsonpItemMiniPetDetails() {
        super(ItemType.MINI_PET);
    }

    @Override
    public int getMinipetId() {
        return minipetId;
    }
}
