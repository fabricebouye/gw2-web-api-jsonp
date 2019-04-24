/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.skills;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.skills.SkillFact;
import api.web.gw2.mapping.v2.skills.SkillFactType;

/**
 * Base JSON-P implementation of a skill fact.
 *
 * @author Fabrice Bouyé
 */
public abstract class JsonpSkillFact implements SkillFact {

    @LocalizedResource
    private String text = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @EnumValue
    private SkillFactType type = SkillFactType.UNKNOWN;

    /**
     * Creates a new empty instance.
     */
    public JsonpSkillFact() {
    }

    @Override
    public final String getText() {
        return text;
    }

    @Override
    public final URLReference getIcon() {
        return icon;
    }

    @Override
    public final SkillFactType getType() {
        return type;
    }
}
