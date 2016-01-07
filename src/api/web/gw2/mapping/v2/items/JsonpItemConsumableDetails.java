/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import java.time.Duration;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a consumable details.
 * @author Fabrice Bouyé
 */
public final class JsonpItemConsumableDetails extends JsonpItemDetails implements ItemConsumableDetails {

    private ItemConsumableType type = ItemConsumableType.UNKNOWN;
    private Optional<String> description = Optional.empty();
    private Optional<Duration> duration = Optional.empty();
    private Optional<ItemConsumableUnlockType> unlockType = Optional.empty();
    private OptionalInt colorId = OptionalInt.empty();
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
        return duration;
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
