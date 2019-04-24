/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.sab;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.v2.characters.id.sab.CharacterSabMode;
import api.web.gw2.mapping.v2.characters.id.sab.CharacterSabZone;

/**
 * Default JSON-P implementation of a SAB response.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterSabZone implements CharacterSabZone {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    private int world = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    private int zone = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private CharacterSabMode mode = CharacterSabMode.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterSabZone() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getWorld() {
        return world;
    }

    @Override
    public int getZone() {
        return zone;
    }

    @Override
    public CharacterSabMode getMode() {
        return mode;
    }
}
