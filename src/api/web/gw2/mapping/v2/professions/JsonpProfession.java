/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.professions;

import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Default JSON-P implementation of a profession.
 * @author Fabrice Bouyé
 */
public final class JsonpProfession implements Profession {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String id = IdValue.DEFAULT_STRING_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @URLValue
    private URLReference icon = URLReference.empty();
    @URLValue
    private URLReference iconBig = URLReference.empty();
    @SetValue
    private Set<Integer> specializations = Collections.EMPTY_SET;
    @MapValue
    private Map<ProfessionWeaponType, ProfessionWeaponSkillSet> weapons = Collections.EMPTY_MAP;
    @SetValue
    private Set<ProfessionTrack> training = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpProfession() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public URLReference getIconBig() {
        return iconBig;
    }

    @Override
    public Set<Integer> getSpecializations() {
        return specializations;
    }

    @Override
    public Map<ProfessionWeaponType, ProfessionWeaponSkillSet> getWeapons() {
        return weapons;
    }

    @Override
    public Set<ProfessionTrack> getTraining() {
        return training;
    }
}
