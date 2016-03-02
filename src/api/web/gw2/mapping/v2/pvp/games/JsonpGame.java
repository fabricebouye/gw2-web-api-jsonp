/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.games;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Map;

/**
 * Default JSON-P implementation of a PvP game.
 * @author Fabrice Bouyé
 */
public final class JsonpGame implements Game {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = "";
    @IdValue
    private int mapId = -1;
    @DateValue
    private ZonedDateTime started = DateValue.DEFAULT;
    @DateValue
    private ZonedDateTime ended = DateValue.DEFAULT;
    @EnumValue
    private GameResult result = GameResult.UNKNOWN;
    @EnumValue
    private GameTeam team = GameTeam.UNKNOWN;
    @EnumValue
    private CharacterProfession profession = CharacterProfession.UNKNOWN;
    @MapValue
    private Map<GameTeam, Integer> scores = Collections.EMPTY_MAP;

    /**
     * Creates a new empty instance.
     */
    public JsonpGame() {
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
    public GameResult getResult() {
        return result;
    }

    @Override
    public GameTeam getTeam() {
        return team;
    }

    @Override
    public CharacterProfession getProfession() {
        return profession;
    }

    @Override
    public Map<GameTeam, Integer> getScores() {
        return scores;
    }

}
