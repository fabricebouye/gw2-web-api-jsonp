/* 
 * Copyright (C) 2015 Fabrice Bouyé
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
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of an account achievements.
 * @author Fabrice Bouyé
 */
public final class JsonpAchievement implements Achievement {

    @IdValue
    private int id = -1;
    @QuantityValue
    @OptionalValue
    private Optional<Integer> current = Optional.empty();
    @QuantityValue
    @OptionalValue
    private Optional<Integer> max = Optional.empty();
    private boolean done = false;
    @OptionalValue
    @SetValue
    private Optional<Set<Integer>> bits = Optional.empty();

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
    public Optional<Integer> getCurrent() {
        return current;
    }

    @Override
    public Optional<Integer> getMax() {
        return max;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public Optional<Set<Integer>> getBits() {
        return bits;
    }
}
