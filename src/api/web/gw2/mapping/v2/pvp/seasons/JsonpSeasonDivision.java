/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.pvp.seasons;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import java.util.Collections;
import java.util.Set;

/**
 * Default JSON-P implementation of a PvP league season's division.
 * @author Fabrice Bouyé
 */
public final class JsonpSeasonDivision implements SeasonDivision {
    
    private String name = ""; // NOI18N.
    @SetValue
    @EnumValue
    private Set<SeasonDivisionFlag> flags = Collections.EMPTY_SET;
    @URLValue
    private URLReference largeIcon = URLReference.empty();
    @URLValue
    private URLReference smallIcon = URLReference.empty();
    @URLValue
    private URLReference pipIcon = URLReference.empty();
    @SetValue
    private Set<SeasonTier> tiers = Collections.EMPTY_SET;
    
    /**
    * Creates a new empty instance.
    */
    public JsonpSeasonDivision() {        
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<SeasonDivisionFlag> getFlags() {
        return flags;
    }

    @Override
    public URLReference getLargeIcon() {
        return largeIcon;
    }

    @Override
    public URLReference getSmallIcon() {
        return smallIcon;
    }

    @Override
    public URLReference getPipIcon() {
        return pipIcon;
    }

    @Override
    public Set<SeasonTier> getTiers() {
        return tiers;
    }
}
