/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.legends;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.legends.Legend;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a legend.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpLegend implements Legend {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @IdValue
    private int swap = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    private int heal = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    private int elite = IdValue.DEFAULT_INTEGER_ID;
    @SetValue
    @IdValue
    private Set<Integer> utilities = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpLegend() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getSwap() {
        return swap;
    }

    @Override
    public int getHeal() {
        return heal;
    }

    @Override
    public int getElite() {
        return elite;
    }

    @Override
    public Set<Integer> getUtilities() {
        return utilities;
    }
}
