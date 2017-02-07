/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.treasury;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of an guild treasury.
 * @author Fabrice Bouyé
 */
public final class JsonpTreasury implements Treasury {

    @IdValue
    private int itemId = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;
    @SetValue
    private Set<TreasuryUpgrade> neededBy = Collections.EMPTY_SET;

    /**
     * Create a new empty instance.
     */
    public JsonpTreasury() {
    }

    @Override
    public int getItemId() {
        return itemId;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Set<TreasuryUpgrade> getNeededBy() {
        return neededBy;
    }
}
