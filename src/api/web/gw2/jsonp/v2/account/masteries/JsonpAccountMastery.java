/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.account.masteries;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.account.masteries.AccountMastery;

/**
 * Default JSON-P implementation of an account mastery unlock.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpAccountMastery implements AccountMastery {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int level = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpAccountMastery() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getLevel() {
        return level;
    }
}
