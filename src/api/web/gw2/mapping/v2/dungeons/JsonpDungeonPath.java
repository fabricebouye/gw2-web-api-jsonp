/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.dungeons;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a dungeon path.
 * @author Fabrice Bouyé
 */
public final class JsonpDungeonPath implements DungeonPath {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @EnumValue
    private DungeonPathType type = DungeonPathType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpDungeonPath() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public DungeonPathType getType() {
        return type;
    }
}
