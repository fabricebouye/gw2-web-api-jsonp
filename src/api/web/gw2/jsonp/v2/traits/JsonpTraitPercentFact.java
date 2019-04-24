/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.core.PercentValue;
import api.web.gw2.mapping.v2.traits.TraitPercentFact;

/**
 * Default JSON-P implementation of a trait percent fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitPercentFact extends JsonpTraitFact implements TraitPercentFact {

    @PercentValue
    private int percent = PercentValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitPercentFact() {
    }

    @Override
    public int getPercent() {
        return percent;
    }
}
