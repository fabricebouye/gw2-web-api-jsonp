/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.wallet;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of an currency amount.
 * @author Fabrice Bouyé
 */
public final class JsonpAccountCurrencyAmount implements AccountCurrencyAmount {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int value = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpAccountCurrencyAmount() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getValue() {
        return value;
    }
}