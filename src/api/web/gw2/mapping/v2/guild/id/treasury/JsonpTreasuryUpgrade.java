/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.id.treasury;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of an guild treasury upgrade.
 * @author Fabrice Bouyé
 */
public final class JsonpTreasuryUpgrade implements TreasuryUpgrade {

    @IdValue
    private int upgradeId = -1;
    @QuantityValue
    private int count = 0;

    /**
     * Create a new empty instance.
     */
    public JsonpTreasuryUpgrade() {
    }

    @Override
    public int getUpgradeId() {
        return upgradeId;
    }

    @Override
    public int getCount() {
        return count;
    }
}
