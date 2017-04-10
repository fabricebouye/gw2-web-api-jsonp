/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters.id.training;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a character training.
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterTraining implements CharacterTraining {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int spent = QuantityValue.DEFAULT;
    private boolean done = false;

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterTraining() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getSpent() {
        return spent;
    }

    @Override
    public boolean isDone() {
        return done;
    }
}
