/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.members;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.IdValue;
import java.time.ZonedDateTime;

/**
 * Default JSON-P implementation of a guild member.
 * @author Fabrice Bouyé
 */
public final class JsonpMember implements Member {

    @IdValue
    private String name = ""; // NOI18N.
    @IdValue
    private String rank = ""; // NOI18N.
    @DateValue
    private ZonedDateTime joined = DateValue.DEFAULT;

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
    public ZonedDateTime getJoined() {
        return joined;
    }
}
