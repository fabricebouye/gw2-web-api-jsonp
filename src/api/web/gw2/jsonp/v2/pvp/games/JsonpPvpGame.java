/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.pvp.games;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.pvp.games.PvpGame;
import api.web.gw2.mapping.v2.pvp.games.PvpGameResult;
import api.web.gw2.mapping.v2.pvp.games.PvpGameTeam;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Map;

/**
 * Default JSON-P implementation of a PvP game.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpPvpGame implements PvpGame {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @IdValue
    private int mapId = IdValue.DEFAULT_INTEGER_ID;
    @DateValue
    private ZonedDateTime started = DateValue.DEFAULT;
    @DateValue
    private ZonedDateTime ended = DateValue.DEFAULT;
    @EnumValue
    private PvpGameResult result = PvpGameResult.UNKNOWN;
    @EnumValue
    private PvpGameTeam team = PvpGameTeam.UNKNOWN;
    @EnumValue
    private CharacterProfession profession = CharacterProfession.UNKNOWN;
    @MapValue
    private Map<PvpGameTeam, Integer> scores = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpPvpGame() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getMapId() {
        return mapId;
    }

    @Override
    public ZonedDateTime getStarted() {
        return started;
    }

    @Override
    public ZonedDateTime getEnded() {
        return ended;
    }

    @Override
    public PvpGameResult getResult() {
        return result;
    }

    @Override
    public PvpGameTeam getTeam() {
        return team;
    }

    @Override
    public CharacterProfession getProfession() {
        return profession;
    }

    @Override
    public Map<PvpGameTeam, Integer> getScores() {
        return scores;
    }

}
