/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a trait traited fact.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitTraitedFact implements TraitTraitedFact {

    @IdValue
    private int requiresTrait = -1;
    @OptionalValue
    private OptionalInt overrides = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitTraitedFact() {
    }

    @Override
    public int getRequiresTrait() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OptionalInt getOverrides() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
