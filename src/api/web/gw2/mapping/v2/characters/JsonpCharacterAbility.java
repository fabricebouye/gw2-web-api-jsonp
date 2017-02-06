/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a character's WvW ability.
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterAbility implements CharacterAbility {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int rank = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterAbility() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getRank() {
        return rank;
    }
}
