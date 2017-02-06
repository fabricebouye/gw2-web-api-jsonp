/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.masteries;

import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;

/**
 * Default JSON-P implementation of a mastery level.
 * @author Fabrice Bouyé
 */
public final class JsonpMasteryLevel implements MasteryLevel {

    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String instruction = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @QuantityValue
    private int pointCost = QuantityValue.DEFAULT;
    @QuantityValue
    private int expCost = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpMasteryLevel() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getInstruction() {
        return instruction;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public int getPointCost() {
        return pointCost;
    }

    @Override
    public int getExpCost() {
        return expCost;
    }
}
