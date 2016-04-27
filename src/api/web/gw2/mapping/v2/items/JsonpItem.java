/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.RuntimeType;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import java.util.Collections;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of an item.
 * @author Fabrice Bouyé
 */
public final class JsonpItem implements Item {

    @IdValue
    private int id = -1;
    @LocalizedResource
    private String name = ""; // NOI18N.
    @OptionalValue
    @LocalizedResource
    private Optional<String> description = Optional.empty();
    @EnumValue
    private ItemType type = ItemType.WEAPON;
    @LevelValue
    private int level = LevelValue.MIN_LEVEL;
    @EnumValue
    private ItemRarity rarity = ItemRarity.UNKNOWN;
    @CoinValue
    private CoinAmount vendorValue = CoinAmount.ZERO;
    @OptionalValue
    @IdValue
    private OptionalInt defaultSkin = OptionalInt.empty();
    @SetValue
    @EnumValue
    private Set<ItemFlag> flags = Collections.EMPTY_SET;
    @SetValue
    @EnumValue
    private Set<ItemGameType> gameTypes = Collections.EMPTY_SET;
    @SetValue
    @EnumValue
    private Set<ItemRestriction> restrictions = Collections.EMPTY_SET;
    @URLValue
    private URLReference icon = URLReference.empty();
    @OptionalValue
    @RuntimeType(selector = "type", pattern = "Item%sDetails", source = RuntimeType.Source.PARENT)
    private Optional<ItemDetails> details = Optional.empty();
    private String chatLink = "";

    /**
     * Creates a new empty instance.
     */
    public JsonpItem() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<String> getDescription() {
        return description;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public ItemRarity getRarity() {
        return rarity;
    }

    @Override
    public CoinAmount getVendorValue() {
        return vendorValue;
    }

    @Override
    public OptionalInt getDefaultSkin() {
        return defaultSkin;
    }

    @Override
    public Set<ItemFlag> getFlags() {
        return flags;
    }

    @Override
    public Set<ItemGameType> getGameTypes() {
        return gameTypes;
    }

    @Override
    public Set<ItemRestriction> getRestrictions() {
        return restrictions;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public Optional<ItemDetails> getDetails() {
        return details;
    }

    @Override
    public String getChatLink() {
        return chatLink;
    }
}
