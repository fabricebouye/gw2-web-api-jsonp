/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.traits;

import api.web.gw2.mapping.core.EnumValue;
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
 * Default JSON-P implementation of a trait.
 * @author Fabrice Bouyé
 */
public final class JsonpTrait implements Trait {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @IdValue
    private int specialization = IdValue.DEFAULT_INTEGER_ID;
    @EnumValue
    private TraitTier tier = TraitTier.UNKNOWN;
    @EnumValue
    private TraitSlotType slot = TraitSlotType.UNKNOWN;
    @SetValue
    @RuntimeType(selector = "type", pattern = "Trait%sFact") // NOI18N.
    private Set<TraitFact> facts = Collections.EMPTY_SET;
    @SetValue
    @RuntimeType(selector = "type", pattern = "Trait%sFact") // NOI18N.
    private Set<TraitFact> traitedFacts = Collections.EMPTY_SET;
    @SetValue
    private Set<TraitSkill> skills = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpTrait() {
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
    public String getDescription() {
        return description;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public int getSpecialization() {
        return specialization;
    }

    @Override
    public TraitTier getTier() {
        return tier;
    }

    @Override
    public TraitSlotType getSlot() {
        return slot;
    }

    @Override
    public Set<TraitFact> getFacts() {
        return facts;
    }

    @Override
    public Set<TraitFact> getTraitedFacts() {
        return traitedFacts;
    }

    @Override
    public Set<TraitSkill> getSkills() {
        return skills;
    }
}
