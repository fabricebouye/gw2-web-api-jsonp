/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.materials;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a account material storage.
 * @author Fabrice Bouyé
 */
public final class JsonpMaterial implements Material {

    @IdValue
    private int id = -1;
    @IdValue
    private int category = -1;
    @QuantityValue
    private int count = 0;

    /**
     * Creates a new empty instance.
     */
    public JsonpMaterial() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCategory() {
        return category;
    }

    @Override
    public int getCount() {
        return count;
    }
}
