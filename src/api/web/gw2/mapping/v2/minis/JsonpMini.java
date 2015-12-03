/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.minis;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
import java.util.Optional;

/**
 * The JSONP implementation of a miniature.
 * @author Fabrice Bouyé
 */
public final class JsonpMini implements Mini {

    @IdValue
    private int id = -1;
    @LocalizedResource
    private String name = "";
    @LocalizedResource
    @OptionalValue
    private Optional<String> unlock = Optional.empty();
    @LocalizedResource
    @OptionalValue
    @URLValue
    private Optional<URL> icon = Optional.empty();
    @QuantityValue
    private int order = 0;
    @IdValue
    private int itemId = -1;

    /**
     * Creates a new empty instance.
     */
    public JsonpMini() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<String> getUnlock() {
        return unlock;
    }

    @Override
    public Optional<URL> getIcon() {
        return icon;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public int getItemId() {
        return itemId;
    }

}
