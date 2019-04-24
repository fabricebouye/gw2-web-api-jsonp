/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.skins;

import api.web.gw2.jsonp.core.RuntimeType;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.skins.Skin;
import api.web.gw2.mapping.v2.skins.SkinDetails;
import api.web.gw2.mapping.v2.skins.SkinFlag;
import api.web.gw2.mapping.v2.skins.SkinRarity;
import api.web.gw2.mapping.v2.skins.SkinRestriction;
import api.web.gw2.mapping.v2.skins.SkinType;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a skin.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpSkin implements Skin {

    @IdValue
    private int id = 1;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @EnumValue
    private SkinType type = SkinType.UNKNOWN;
    @SetValue
    @EnumValue
    private Set<SkinFlag> flags = Collections.EMPTY_SET;
    @SetValue
    @EnumValue
    private Set<SkinRestriction> restrictions = Collections.EMPTY_SET;
    @URLValue
    private URLReference icon = URLReference.empty();
    @OptionalValue
    @LocalizedResource
    private Optional<String> description = Optional.empty();
    @OptionalValue
    @RuntimeType(selector = "type", pattern = "Skin%sDetails", source = RuntimeType.Source.PARENT) // NOI18N.
    private Optional<SkinDetails> details = Optional.empty();
    @EnumValue
    private SkinRarity rarity = SkinRarity.UNKNOWN;

    /**
     * Creates a new instance.
     */
    public JsonpSkin() {
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
    public SkinType getType() {
        return type;
    }

    @Override
    public Set<SkinFlag> getFlags() {
        return flags;
    }

    @Override
    public Set<SkinRestriction> getRestrictions() {
        return restrictions;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public Optional<String> getDescription() {
        return description;
    }

    @Override
    public <T extends SkinDetails> Optional<T> getDetails() {
        return (Optional<T>) details;
    }

    @Override
    public SkinRarity getRarity() {
        return rarity;
    }
}
