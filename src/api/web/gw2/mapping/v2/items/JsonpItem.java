/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.items;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.LevelValue;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of an item.
 * @author Fabrice Bouyé
 */
public final class JsonpItem implements Item {

    private int id = -1;
    private String name = "";
    private Optional<String> description = Optional.empty();
    private ItemType type = ItemType.WEAPON;
    private int level = LevelValue.MIN_LEVEL;
    private ItemRarity rarity = ItemRarity.UNKNOWN;
    @CoinValue
    private CoinAmount vendorValue = CoinAmount.ZERO;
    private OptionalInt defaultSkin = OptionalInt.empty();
    private Set<ItemFlag> flags = Collections.EMPTY_SET;
    private Set<ItemGameType> gameTypes = Collections.EMPTY_SET;
    private Set<ItemRestriction> restrictions = Collections.EMPTY_SET;
    private Optional<URL> icon = Optional.empty();
    private Optional<ItemDetails> details = Optional.empty();

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
    public Optional<URL> getIcon() {
        return icon;
    }

    @Override
    public Optional<ItemDetails> getDetails() {
        return details;
    }
}
