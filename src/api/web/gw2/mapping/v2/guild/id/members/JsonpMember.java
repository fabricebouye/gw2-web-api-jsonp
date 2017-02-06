/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.members;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Default JSON-P implementation of a guild member.
 * @author Fabrice Bouyé
 */
public final class JsonpMember implements Member {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String name = IdValue.DEFAULT_STRING_ID;
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String rank = IdValue.DEFAULT_STRING_ID;
    @DateValue
    @OptionalValue
    private Optional<ZonedDateTime> joined = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpMember() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public Optional<ZonedDateTime> getJoined() {
        return joined;
    }
}
