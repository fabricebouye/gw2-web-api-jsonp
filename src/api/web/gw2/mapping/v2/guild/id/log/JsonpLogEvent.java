/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.log;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a guild log event.
 * @author Fabrice Bouyé
 */
public final class JsonpLogEvent implements LogEvent {

    @IdValue
    private int id = -1;
    @DateValue
    private ZonedDateTime time = DateValue.DEFAULT;
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String user = "";
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
}
