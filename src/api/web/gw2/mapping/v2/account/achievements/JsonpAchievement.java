/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.achievements;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of an account achievements.
 * @author Fabrice Bouyé
 */
public final class JsonpAchievement implements Achievement {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    @OptionalValue
    private OptionalInt current = OptionalInt.empty();
    @QuantityValue
    @OptionalValue
    private OptionalInt max = OptionalInt.empty();
    private boolean done = false;
    @SetValue
    private Set<Integer> bits = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpAchievement() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public OptionalInt getCurrent() {
        return current;
    }

    @Override
    public OptionalInt getMax() {
        return max;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public Set<Integer> getBits() {
        return bits;
    }
}
