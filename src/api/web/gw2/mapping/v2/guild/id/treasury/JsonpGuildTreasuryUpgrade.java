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

/**
 * Default JSON-P implementation of an guild treasury upgrade.
 * @author Fabrice Bouyé
 */
public final class JsonpGuildTreasuryUpgrade implements GuildTreasuryUpgrade {

    @IdValue
    private int upgradeId = IdValue.DEFAULT_INTEGER_ID;
    @QuantityValue
    private int count = QuantityValue.DEFAULT;

    /**
     * Create a new empty instance.
     */
    public JsonpGuildTreasuryUpgrade() {
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
