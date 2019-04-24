/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.account.finishers;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.account.finishers.AccountFinisher;

import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a finisher unlock.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpAccountFinisher implements AccountFinisher {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    private boolean permanent = false;
    @QuantityValue
    @OptionalValue
    private OptionalInt quantity = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpAccountFinisher() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isPermanent() {
        return permanent;
    }

    @Override
    public OptionalInt getQuantity() {
        return quantity;
    }
}
