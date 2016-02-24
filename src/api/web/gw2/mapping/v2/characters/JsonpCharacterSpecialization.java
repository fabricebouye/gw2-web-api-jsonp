/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a character's specialization.
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterSpecialization implements CharacterSpecialization {

    @IdValue
    private int id = -1;
    @SetValue
    @IdValue
    private Set<Integer> traits = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterSpecialization() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Set<Integer> getTraits() {
        return traits;
    }
}
