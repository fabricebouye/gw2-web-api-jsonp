/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.professions;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.professions.ProfessionTrackCost;
import api.web.gw2.mapping.v2.professions.ProfessionTrackCostType;

import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a profession track cost.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpProfessionTrackCost implements ProfessionTrackCost {

    @QuantityValue
    private int cost = QuantityValue.DEFAULT;
    @EnumValue
    private ProfessionTrackCostType type = ProfessionTrackCostType.UNKNOWN;
    @OptionalValue
    @IdValue
    private OptionalInt skillId = OptionalInt.empty();
    @OptionalValue
    @IdValue
    private OptionalInt traitId = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpProfessionTrackCost() {
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public ProfessionTrackCostType getType() {
        return type;
    }

    @Override
    public OptionalInt getSkillId() {
        return skillId;
    }

    @Override
    public OptionalInt getTraitId() {
        return traitId;
    }
}
