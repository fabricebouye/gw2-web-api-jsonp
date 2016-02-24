/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.materials;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.SetValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a material storage.
 * @author Fabrice Bouyé
 */
public final class JsonpMaterialStorage implements MaterialStorage {

    @IdValue
    private int id = -1;
    @LocalizedResource
    private String name = "";
    @SetValue
    @IdValue
    private Set<Integer> items = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpMaterialStorage() {
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
    public Set<Integer> getItems() {
        return items;
    }

}
