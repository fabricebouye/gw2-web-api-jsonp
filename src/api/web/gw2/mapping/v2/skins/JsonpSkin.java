/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.skins;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.RuntimeType;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLValue;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a skin.
 * @author Fabrice Bouyé
 */
public final class JsonpSkin implements Skin {

    @IdValue
    private int id = 1;
    @LocalizedResource
    private String name = ""; // NOI18N.
    @EnumValue(factory = "api.web.gw2.mapping.v2.skins.SkinsUtils::findSkinType") // NOI18N.
    private SkinType type = SkinType.UNKNOWN;
    @SetValue
    @EnumValue(factory = "api.web.gw2.mapping.v2.skins.SkinsUtils::findSkinFlag") // NOI18N.
    private Set<SkinFlag> flags = Collections.EMPTY_SET;
    @SetValue
    @EnumValue(factory = "api.web.gw2.mapping.v2.skins.SkinsUtils::findSkinRestriction") // NOI18N.
    private Set<SkinRestriction> restrictions = Collections.EMPTY_SET;
    @OptionalValue
    @URLValue
    private Optional<URL> icon = Optional.empty();
    @OptionalValue
    @LocalizedResource
    private Optional<String> description = Optional.empty();
    @OptionalValue
    @RuntimeType(selector = "type", pattern = "Skin%sDetails", source = RuntimeType.Source.PARENT) // NOI18N.
    private Optional<SkinDetails> details = Optional.empty();

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
    public Optional<URL> getIcon() {
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
}
