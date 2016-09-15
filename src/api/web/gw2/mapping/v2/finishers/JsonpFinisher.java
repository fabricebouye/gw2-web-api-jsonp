/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.finishers;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import java.util.Optional;

/**
 * Default JSON-P implementation of a finisher.
 * @author Fabrice Bouyé
 */
public final class JsonpFinisher implements Finisher {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    @OptionalValue
    private Optional<String> unlockDetails = Optional.empty();
    @QuantityValue
    private int order = QuantityValue.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpFinisher() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Optional<String> getUnlockDetails() {
        return unlockDetails;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public String getName() {
        return name;
    }

}
