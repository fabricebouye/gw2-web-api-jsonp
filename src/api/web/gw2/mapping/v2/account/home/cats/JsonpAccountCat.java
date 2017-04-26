/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.home.cats;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;

/**
 * Default JSON-P implementation of a cat.
 * @author Fabrice Bouyé
 */
public final class JsonpAccountCat implements AccountCat {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private AccountCatHint hint = AccountCatHint.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpAccountCat() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public AccountCatHint getHint() {
        return hint;
    }
}
