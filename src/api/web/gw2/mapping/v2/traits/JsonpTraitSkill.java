/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.RuntimeType;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a trait skill.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitSkill implements TraitSkill {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @SetValue
    @RuntimeType(selector = "type", pattern = "Trait%sFact") // NOI18N.
    private Set<TraitFact> facts = Collections.EMPTY_SET;
    @SetValue
    @RuntimeType(selector = "type", pattern = "Trait%sFact") // NOI18N.
    private Set<TraitFact> traitedFacts = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpTraitSkill() {
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
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Set<TraitFact> getFacts() {
        return facts;
    }

    @Override
    public Set<TraitFact> getTraitedFacts() {
        return traitedFacts;
    }
}
