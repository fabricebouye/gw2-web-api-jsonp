/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.masteries;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a mastery.
 * @author Fabrice Bouyé
 */
public final class JsonpMastery implements Mastery {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String requirements = LocalizedResource.DEFAULT;
    @QuantityValue
    private int order = QuantityValue.DEFAULT;
    @URLValue
    private URLReference background = URLReference.empty();
    @EnumValue
    private MasteryRegion region = MasteryRegion.UNKNOWN;
    @SetValue
    private Set<MasteryLevel> levels = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpMastery() {
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
    public String getRequirement() {
        return requirements;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public URLReference getBackground() {
        return background;
    }

    @Override
    public MasteryRegion getRegion() {
        return region;
    }

    @Override
    public Set<MasteryLevel> getLevels() {
        return levels;
    }
}
