/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.wvw.matches;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.v2.wvw.matches.WvwMatchMapObjective;
import api.web.gw2.mapping.v2.wvw.matches.WvwMatchTeam;
import api.web.gw2.mapping.v2.wvw.objectives.WvwObjectiveType;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Default JSON-P implementation of a match map objective.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpWvwMatchMapObjective implements WvwMatchMapObjective {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @EnumValue
    private WvwObjectiveType type = WvwObjectiveType.UNKNOWN;
    @EnumValue
    private WvwMatchTeam owner = WvwMatchTeam.UNKNOWN;
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
    public JsonpWvwMatchMapObjective() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public WvwObjectiveType getType() {
        return type;
    }

    @Override
    public WvwMatchTeam getOwner() {
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
