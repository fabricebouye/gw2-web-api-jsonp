/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.sab;

import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.v2.characters.id.sab.CharacterSabResponse;
import api.web.gw2.mapping.v2.characters.id.sab.CharacterSabSong;
import api.web.gw2.mapping.v2.characters.id.sab.CharacterSabUnlock;
import api.web.gw2.mapping.v2.characters.id.sab.CharacterSabZone;

import java.util.Collections;
import java.util.List;

/**
 * Default JSON-P implementation of a SAB response.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterSabResponse implements CharacterSabResponse {

    @ListValue
    private List<CharacterSabZone> zones = Collections.EMPTY_LIST;
    @ListValue
    private List<CharacterSabUnlock> unlocks = Collections.EMPTY_LIST;
    @ListValue
    private List<CharacterSabSong> songs = Collections.EMPTY_LIST;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterSabResponse() {
    }

    @Override
    public List<CharacterSabZone> getZones() {
        return zones;
    }

    @Override
    public List<CharacterSabUnlock> getUnlocks() {
        return unlocks;
    }

    @Override
    public List<CharacterSabSong> getSongs() {
        return songs;
    }
}
