/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters.id.equipment;

import api.web.gw2.mapping.core.ListValue;
import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of the equipment response.
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterEquipmentResponse implements CharacterEquipmentResponse {

    @ListValue
    private List<CharacterEquipment> equipment = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterEquipmentResponse() {
    }

    @Override
    public List<CharacterEquipment> getEquipment() {
        return equipment;
    }
}
