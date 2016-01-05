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
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a trait fact.
 * @author Fabrice Bouyé
 */
public abstract class JsonpTraitFact implements TraitFact {

    @OptionalValue
    @LocalizedResource
    private Optional<String> text = Optional.empty();
    @EnumValue
    private TraitFactType type = TraitFactType.UNKNOWN;
    @OptionalValue
    @URLValue
    private Optional<URL> icon = Optional.empty();
    @IdValue
    @OptionalValue
    private OptionalInt requiresTrait = OptionalInt.empty();
    @OptionalValue
    private OptionalInt overrides = OptionalInt.empty();

    /**
     * Creates a new empty instance;
     */
    public JsonpTraitFact() {
    }

    @Override
    public Optional<String> getText() {
        return text;
    }

    @Override
    public Optional<URL> getIcon() {
        return icon;
    }

    @Override
    public OptionalInt getRequiresTrait() {
        return requiresTrait;
    }

    @Override
    public OptionalInt getOverrides() {
        return overrides;
    }
}
