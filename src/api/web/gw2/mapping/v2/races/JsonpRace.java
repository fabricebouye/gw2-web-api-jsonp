/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.races;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a playable race.
 * @author Fabrice Bouyé
 */
public final class JsonpRace implements Race {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @IdValue
    @SetValue
    private Set<Integer> skills = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpRace() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Set<Integer> getSkills() {
        return skills;
    }
}
