/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.wvw.matches;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.v2.wvw.objectives.ObjectiveType;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Default JSON-P implementation of a match map objective.
 * @author Fabrice Bouyé
 */
public final class JsonpMatchMapObjective implements MatchMapObjective {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = "";
    @EnumValue
    private ObjectiveType type = ObjectiveType.UNKNOWN;
    @EnumValue
    private MatchTeam owner = MatchTeam.UNKNOWN;
    @DateValue
    private ZonedDateTime lastFlipped = DateValue.DEFAULT;
    @IdValue(flavor = IdValue.Flavor.STRING)
    @OptionalValue
    private Optional<String> claimedBy = Optional.empty();
    @DateValue
    @OptionalValue
    private Optional<ZonedDateTime> claimedAt = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpMatchMapObjective() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public ObjectiveType getType() {
        return type;
    }

    @Override
    public MatchTeam getOwner() {
        return owner;
    }

    @Override
    public ZonedDateTime getLastFlipped() {
        return lastFlipped;
    }

    @Override
    public Optional<String> getClaimedBy() {
        return claimedBy;
    }

    @Override
    public Optional<ZonedDateTime> getClaimedAt() {
        return claimedAt;
    }
}
