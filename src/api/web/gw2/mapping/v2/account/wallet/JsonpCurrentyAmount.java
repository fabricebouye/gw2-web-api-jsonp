/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.wallet;

/**
 * Default implementation of an currency amount.
 * @author Fabrice Bouyé
 */
public final class JsonpCurrentyAmount implements CurrencyAmount {

    int id = 0;
     int value = 0;

    /**
     * Creates a new empty instance.
     */
    public JsonpCurrentyAmount() {
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
