/* 
 * Copyright (C) 2015 Fabrice Bouyé
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
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a trait skill.
 * @author Fabrice Bouyé
 */
public final class JsonpTraitSkill implements TraitSkill {

    @IdValue
    private int id = -1;
    @LocalizedResource
    private String name = "";
    @OptionalValue
    @URLValue
    private Optional<URL> icon = Optional.empty();
    @LocalizedResource
    private String description = "";
    @OptionalValue
    @SetValue
    @RuntimeType(selector = "type", pattern = "Trait%sFact")
    private Optional<Set<TraitFact>> facts = Optional.empty();
    @OptionalValue
    @SetValue
    @RuntimeType(selector = "type", pattern = "Trait%sFact")
    private Optional<Set<TraitFact>> traitedFacts = Optional.empty();

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
    public Optional<URL> getIcon() {
        return icon;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Optional<Set<TraitFact>> getFacts() {
        return facts;
    }

    @Override
    public Optional<Set<TraitFact>> getTraitedFacts() {
        return traitedFacts;
    }
}
