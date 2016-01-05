/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.specializations;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a specialization.
 * @author Fabrice Bouyé
 */
public final class JsonpSpecialization implements Specialization {

    @IdValue
    private int id = -1;
    @LocalizedResource
    private String name = ""; // NOI18N.
    @EnumValue
    private CharacterProfession profession = CharacterProfession.UNKNOWN;
    private boolean elite = false;
    @OptionalValue
    @URLValue
    private Optional<URL> icon = Optional.empty();
    @OptionalValue
    @URLValue
    private Optional<URL> background = Optional.empty();
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
    public Optional<URL> getIcon() {
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
    public Optional<URL> getBackground() {
        return background;
    }

}
