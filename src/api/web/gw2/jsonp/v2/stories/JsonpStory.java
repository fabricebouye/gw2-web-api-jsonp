/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.stories;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.characters.CharacterRace;
import api.web.gw2.mapping.v2.stories.Story;
import api.web.gw2.mapping.v2.stories.StoryChapter;
import api.web.gw2.mapping.v2.stories.StoryFlag;

import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a story.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpStory implements Story {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @IdValue(flavor = IdValue.Flavor.STRING)
    private String season = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String description = LocalizedResource.DEFAULT;
    @LocalizedResource
    private String timeline = LocalizedResource.DEFAULT;
    @LevelValue
    private int level = LevelValue.MIN_LEVEL;
    @QuantityValue
    private int order = QuantityValue.DEFAULT;
    @SetValue
    private Set<StoryChapter> chapters = Collections.EMPTY_SET;
    @SetValue
    @EnumValue
    private Set<CharacterRace> races = Collections.EMPTY_SET;
    @SetValue
    @EnumValue
    private Set<StoryFlag> flags = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpStory() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getSeason() {
        return season;
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
    public String getTimeline() {
        return timeline;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public Set<StoryChapter> getChapters() {
        return chapters;
    }

    @Override
    public Set<CharacterRace> getRaces() {
        return races;
    }

    @Override
    public Set<StoryFlag> getFlags() {
        return flags;
    }
}
