/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.commerce.listings;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a listing response.
 * @author Fabrice Bouyé
 */
public final class JsonpListingResponse implements ListingResponse {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @SetValue
    private Set<Listing> buys = Collections.EMPTY_SET;
    @SetValue
    private Set<Listing> sells = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpListingResponse() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Set<Listing> getBuys() {
        return buys;
    }

    @Override
    public Set<Listing> getSells() {
        return sells;
    }
}
