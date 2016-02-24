/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v1.guilddetails;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a guild emblem.
 * @author Fabrice Bouyé
 */
public final class JsonpGuildDetailsEmblem implements GuildDetailsEmblem {

    @IdValue
    private int backgroundId = -1;
    @IdValue
    private int foregroundId = -1;
    @SetValue
    @EnumValue
    private Set<GuildDetailsEmblemFlag> flags = Collections.EMPTY_SET;
    @IdValue
    private int backgroundColorId = -1;
    @IdValue
    private int foregroundPrimaryColorId = -1;
    @IdValue
    private int foregroundSecondaryColorId = -1;

    /**
     * Creates a new empty instance.
     */
    public JsonpGuildDetailsEmblem() {
    }

    @Override
    public int getBackgroundId() {
        return backgroundId;
    }

    @Override
    public int getForegroundId() {
        return foregroundId;
    }

    @Override
    public Set<GuildDetailsEmblemFlag> getFlags() {
        return flags;
    }

    @Override
    public int getBackgroundColorId() {
        return backgroundColorId;
    }

    @Override
    public int getForegroundPrimaryColorId() {
        return foregroundPrimaryColorId;
    }

    @Override
    public int getForegroundSecondaryColorId() {
        return foregroundSecondaryColorId;
    }
}
