/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.account.luck;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.account.luck.Luck;
import api.web.gw2.mapping.v2.account.luck.LuckId;

/**
 * Default JSON-P implementation of account luck.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpLuck implements Luck {
    @EnumValue
    private LuckId id = LuckId.UNKNOWN;
    @QuantityValue
    private int value = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpLuck() {
    }

    @Override
    public LuckId getId() {
        return id;
    }

    @Override
    public int getValue() {
        return value;
    }
}
