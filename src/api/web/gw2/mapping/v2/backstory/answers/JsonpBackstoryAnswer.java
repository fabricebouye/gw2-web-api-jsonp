/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.backstory.answers;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.characters.CharacterRace;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a backstory (character's biography) answer.
 * @author Fabrice Bouyé
 */
public final class JsonpBackstoryAnswer implements BackstoryAnswer {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String title = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String journal = LocalizedResource.DEFAULT;
    @IdValue
    private int question = IdValue.DEFAULT_INTEGER_ID;
    @SetValue
    @EnumValue
    private Set<CharacterProfession> professions = Collections.EMPTY_SET;
    @SetValue
    @EnumValue
    private Set<CharacterRace> races = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpBackstoryAnswer() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getJournal() {
        return journal;
    }

    @Override
    public int getQuestion() {
        return question;
    }

    @Override
    public Set<CharacterProfession> getProfessions() {
        return professions;
    }

    @Override
    public Set<CharacterRace> getRace() {
        return races;
    }
}
