/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.sab;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.v2.characters.id.sab.CharacterSabUnlock;

/**
 * Default JSON-P implementation of a SAB response.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterSabUnlock implements CharacterSabUnlock {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    private String name = LocalizedResource.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterSabUnlock() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
