/* 
 * Copyright (C) 2015 Fabrice Bouyé
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
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a trait.
 * @author Fabrice Bouyé
 */
public final class JsonpTrait implements Trait {

    @IdValue
    private int id = -1;
    @LocalizedResource
    private String name = ""; // NOI18N.
    @OptionalValue
    @URLValue
    private Optional<URL> icon = Optional.empty();
    @LocalizedResource
    private String description = "";
    @IdValue
    private int specialization = -1;
    @EnumValue(factory = "api.web.gw2.mapping.v2.traits.TraitsUtils::findTraitTier") // NOI18N.
    private TraitTier tier = TraitTier.UNKNOWN;
    @EnumValue(factory = "api.web.gw2.mapping.v2.traits.TraitsUtils::findTraitSlotType") // NOI18N.
    private TraitSlotType slot = TraitSlotType.UNKNOWN;
    @OptionalValue
    @SetValue
    @RuntimeType(selector = "type", pattern = "Trait%sFact")
    private Optional<Set<TraitFact>> facts = Optional.empty();
    @OptionalValue
    @SetValue
    @RuntimeType(selector = "type", pattern = "Trait%sFact")
    private Optional<Set<TraitFact>> traitedFacts = Optional.empty();
    @OptionalValue
    @SetValue
    private Optional<Set<TraitSkill>> skills = Optional.empty();

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
    public Optional<URL> getIcon() {
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
    public Optional<Set<TraitFact>> getFacts() {
        return facts;
    }

    @Override
    public Optional<Set<TraitFact>> getTraitedFacts() {
        return traitedFacts;
    }

    @Override
    public Optional<Set<TraitSkill>> getSkills() {
        return skills;
    }
}
