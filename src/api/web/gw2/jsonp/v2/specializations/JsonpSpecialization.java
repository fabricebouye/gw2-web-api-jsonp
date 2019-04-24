/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.specializations;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.specializations.Specialization;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a specialization.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpSpecialization implements Specialization {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @EnumValue
    private CharacterProfession profession = CharacterProfession.UNKNOWN;
    private boolean elite = false;
    @URLValue
    private URLReference icon = URLReference.empty();
    @URLValue
    private URLReference background = URLReference.empty();
    @SetValue
    private Set<Integer> minorTraits = Collections.EMPTY_SET;
    @SetValue
    private Set<Integer> majorTraits = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpSpecialization() {
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
    public CharacterProfession getProfession() {
        return profession;
    }

    @Override
    public boolean isElite() {
        return elite;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public Set<Integer> getMinorTraits() {
        return minorTraits;
    }

    @Override
    public Set<Integer> getMajorTraits() {
        return majorTraits;
    }

    @Override
    public URLReference getBackground() {
        return background;
    }

}
