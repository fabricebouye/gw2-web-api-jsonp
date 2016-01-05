/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.achievements;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of an achievement's bit.
 * @author Fabrice Bouyé
 */
public final class JsonpAchievementBit implements AchievementBit {

    @EnumValue
    private AchievementBitType type = AchievementBitType.UNKNOWN;
    @IdValue
    @OptionalValue
    private OptionalInt id = OptionalInt.empty();
    @LocalizedResource
    @OptionalValue
    private Optional<String> text = Optional.empty();
    
    /**
     * Creates a new empty instance.
     */
    public JsonpAchievementBit() {
    }

    @Override
    public AchievementBitType getType() {
        return type;
    }

    @Override
    public OptionalInt getId() {
        return id;
    }

    @Override
    public Optional<String> getText() {
        return text;
    }

}
