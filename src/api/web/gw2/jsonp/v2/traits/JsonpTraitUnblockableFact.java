/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.traits;

import api.web.gw2.mapping.v2.traits.TraitUnblockableFact;

/**
 * Default JSON-P implementation of a trait unblockable fact.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpTraitUnblockableFact extends JsonpTraitFact implements TraitUnblockableFact {

    private boolean value = false;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitUnblockableFact() {
    }
}
