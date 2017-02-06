/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.seasons.leaderboards;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of a PvP league leaderboard entry.
 * @author Fabrice Bouyé
 */
public final class JsonpLeaderboardEntry implements LeaderboardEntry {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String name = IdValue.DEFAULT_STRING_ID;
    @QuantityValue
    private int rank = QuantityValue.DEFAULT;
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> team = Optional.empty();
    @OptionalValue
    @IdValue
    private OptionalInt teamId = OptionalInt.empty();
    @DateValue
    private ZonedDateTime date = DateValue.DEFAULT;
    @SetValue
    private Set<LeaderboardScore> scores = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpLeaderboardEntry() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Optional<String> getTeam() {
        return team;
    }

    @Override
    public OptionalInt getTeamId() {
        return teamId;
    }

    @Override
    public ZonedDateTime getDate() {
        return date;
    }

    @Override
    public Set<LeaderboardScore> getScores() {
        return scores;
    }
}
