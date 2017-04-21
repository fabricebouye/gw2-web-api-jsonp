/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.wvw.ranks;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;

/**
 * Default JSON-P implementation of a WvW rank.
 * @author Fabrice Bouyé
 */
public final class JsonpWvwRank implements WvwRank {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String title = LocalizedResource.DEFAULT;
    @QuantityValue
    private int minRank = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpWvwRank() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getMinRank() {
        return minRank;
    }
}
