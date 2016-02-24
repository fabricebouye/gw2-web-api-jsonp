/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.DurationValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import java.time.Duration;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a consumable details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemConsumableDetails extends JsonpItemDetails implements ItemConsumableDetails {

    @EnumValue
    private ItemConsumableType type = ItemConsumableType.UNKNOWN;
    @OptionalValue
    @LocalizedResource
    private Optional<String> description = Optional.empty();
    @OptionalValue
    @DurationValue(flavor = DurationValue.Flavor.MILLIS)
    private Optional<Duration> durationMs = Optional.empty();
    @OptionalValue
    @EnumValue
    private Optional<ItemConsumableUnlockType> unlockType = Optional.empty();
    @OptionalValue
    @IdValue
    private OptionalInt colorId = OptionalInt.empty();
    @OptionalValue
    @IdValue
    private OptionalInt recipeId = OptionalInt.empty();

    public JsonpItemConsumableDetails() {
        super(ItemType.CONSUMABLE);
    }

    @Override
    public ItemConsumableType getType() {
        return type;
    }

    @Override
    public Optional<String> getDescription() {
        return description;
    }

    @Override
    public Optional<Duration> getDurationMs() {
        return durationMs;
    }

    @Override
    public Optional<ItemConsumableUnlockType> getUnlockType() {
        return unlockType;
    }

    @Override
    public OptionalInt getColorId() {
        return colorId;
    }

    @Override
    public OptionalInt getRecipeId() {
        return recipeId;
    }
}
