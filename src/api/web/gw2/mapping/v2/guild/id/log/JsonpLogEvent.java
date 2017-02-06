/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.log;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.EnumValue;
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
 * Default JSON-P implementation of a guild log event.
 * @author Fabrice Bouyé
 */
public final class JsonpLogEvent implements LogEvent {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @DateValue
    private ZonedDateTime time = DateValue.DEFAULT;
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String user = IdValue.DEFAULT_STRING_ID;
    @EnumValue
    private LogEventType type = LogEventType.UNKNOWN;
    @IdValue
    @OptionalValue
    private OptionalInt itemId = OptionalInt.empty();
    @QuantityValue
    @OptionalValue
    private OptionalInt count = OptionalInt.empty();
    @OptionalValue
    private Optional<String> motd = Optional.empty();
    @IdValue
    @OptionalValue
    private OptionalInt upgradeId = OptionalInt.empty();
    @EnumValue
    @OptionalValue
    private Optional<LogEventStashOperation> operation = Optional.empty();
    @OptionalValue
    @CoinValue
    private Optional<CoinAmount> coins = Optional.empty();
    @EnumValue
    @OptionalValue
    private Optional<LogEventUpgradeAction> action = Optional.empty();
    @EnumValue
    @OptionalValue
    private Optional<LogEventInfluenceActivity> activity;
    @OptionalValue
    @QuantityValue
    private OptionalInt totalParticipants = OptionalInt.empty();
    @SetValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Set<String> participants = Collections.EMPTY_SET;
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> invitedBy = Optional.empty();
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> kickedBy = Optional.empty();
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> changedBy = Optional.empty();
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> oldRank = Optional.empty();
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> newRank = Optional.empty();
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> declinedBy = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpLogEvent() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public ZonedDateTime getTime() {
        return time;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public LogEventType getType() {
        return type;
    }

    @Override
    public OptionalInt getItemId() {
        return itemId;
    }

    @Override
    public OptionalInt getCount() {
        return count;
    }

    @Override
    public Optional<String> getMotd() {
        return motd;
    }

    @Override
    public OptionalInt getUpgradeId() {
        return upgradeId;
    }

    @Override
    public Optional<LogEventUpgradeAction> getAction() {
        return action;
    }

    @Override
    public Optional<LogEventStashOperation> getOperation() {
        return operation;
    }

    @Override
    public Optional<CoinAmount> getCoins() {
        return coins;
    }

    @Override
    public Optional<LogEventInfluenceActivity> getActivity() {
        return activity;
    }

    @Override
    public OptionalInt getTotalParticipants() {
        return totalParticipants;
    }

    @Override
    public Set<String> getParticipants() {
        return participants;
    }

    @Override
    public Optional<String> getInvitedBy() {
        return invitedBy;
    }

    @Override
    public Optional<String> getKickedBy() {
        return kickedBy;
    }

    @Override
    public Optional<String> getChangedBy() {
        return changedBy;
    }

    @Override
    public Optional<String> getOldRank() {
        return oldRank;
    }

    @Override
    public Optional<String> getNewRank() {
        return newRank;
    }

    @Override
    public Optional<String> getDeclinedBy() {
        return declinedBy;
    }
}
