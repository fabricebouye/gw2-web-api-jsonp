/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.stories;

import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.v2.stories.StoryChapter;

/**
 * Default JSON-P implementation of a story chapter.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpStoryChapter implements StoryChapter {

    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpStoryChapter() {
    }

    @Override
    public String getName() {
        return name;
    }
}
