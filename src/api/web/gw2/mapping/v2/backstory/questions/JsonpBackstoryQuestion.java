/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.backstory.questions;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.characters.CharacterRace;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a backstory (character's biography) question.
 * @author Fabrice Bouyé
 */
public class JsonpBackstoryQuestion implements BackstoryQuestion {
 
    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String title = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @SetValue
    @EnumValue
    private Set<CharacterProfession> professions = Collections.EMPTY_SET;
    @SetValue
    @EnumValue
    private Set<CharacterRace> races = Collections.EMPTY_SET;
    @SetValue
    @IdValue
    private Set<Integer> answers = Collections.EMPTY_SET;
    @QuantityValue
    private int order = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpBackstoryQuestion() {
    }

    @Override
    public int getId() {
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
    public Set<CharacterProfession> getProfessions() {
        return professions;
    }

    @Override
    public Set<CharacterRace> getRace() {
        return races;
    }

    @Override
    public Set<Integer> getAnswers() {
        return answers;
    }

    @Override
    public int getOrder() {
        return order;
    }   
}
