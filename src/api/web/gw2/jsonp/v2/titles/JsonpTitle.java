/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.titles;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.titles.Title;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of a title.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTitle implements Title {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @IdValue
    private int achievement = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    @SetValue
    private Set<Integer> achievements = Collections.EMPTY_SET;
    @QuantityValue
    @OptionalValue
    private OptionalInt apRequired = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpTitle() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAchievement() {
        return achievement;
    }

    @Deprecated
    @Override
    public Set<Integer> getAchievements() {
        return achievements;
    }

    @Override
    public OptionalInt getApRequired() {
        return apRequired;
    }
}
