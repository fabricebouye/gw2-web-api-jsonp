/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters.id.equipment;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.MapValue;
import java.util.Collections;
import java.util.Map;

/**
 * Default JSON-P implementation of the equipment stats.
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterEquipmentStats implements CharacterEquipmentStats {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @MapValue
    private Map<CharacterEquipmentAttribute, Integer> attributes = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterEquipmentStats() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Map<CharacterEquipmentAttribute, Integer> getAttributes() {
        return attributes;
    }
}
