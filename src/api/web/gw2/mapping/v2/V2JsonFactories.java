/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2;

import api.web.gw2.mapping.v2.account.Account;
import api.web.gw2.mapping.v2.account.JsonAccountUtils;
import api.web.gw2.mapping.v2.characters.Character;
import api.web.gw2.mapping.v2.characters.JsonCharactersUtils;
import api.web.gw2.mapping.v2.characters.equipment.Equipment;
import api.web.gw2.mapping.v2.characters.equipment.JsonEquipmentUtils;
import api.web.gw2.mapping.v2.characters.inventory.Inventory;
import api.web.gw2.mapping.v2.characters.inventory.InventoryBag;
import api.web.gw2.mapping.v2.characters.inventory.JsonInventoryUtils;
import api.web.gw2.mapping.v2.files.JsonFilesUtils;
import api.web.gw2.mapping.v2.files.File;
import api.web.gw2.mapping.v2.quaggans.JsonQuaggansUtils;
import api.web.gw2.mapping.v2.quaggans.Quaggan;
import api.web.gw2.mapping.v2.tokeninfo.JsonTokenInfoUtils;
import api.web.gw2.mapping.v2.tokeninfo.TokenInfo;
import api.web.gw2.mapping.v2.worlds.JsonWorldsUtils;
import api.web.gw2.mapping.v2.worlds.World;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import javax.json.JsonObject;

/**
 * Provides JSON-P factories for APIv2 types.
 * @author Fabrice Bouyé
 * @see APIv2
 */
public enum V2JsonFactories {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Factories map: type -> Function(JsonObject, type).
     */
    private final HashMap factories = new HashMap();

    V2JsonFactories() {
        // Register default factories.
        // v2/account
        registerFactory(Account.class, JsonAccountUtils.INSTANCE::jsonObjectToAccount);
        // v2/build
        // v2/characters
        registerFactory(Character.class, JsonCharactersUtils.INSTANCE::jsonObjectToCharacter);
        // v2/characters/equipment
        registerFactory(Equipment.class, JsonEquipmentUtils.INSTANCE::jsonObjectToEquipment);
        // v2/characters/inventory
        registerFactory(Inventory.class, JsonInventoryUtils.INSTANCE::jsonObjectToInventory);
        registerFactory(InventoryBag.class, JsonInventoryUtils.INSTANCE::jsonObjectToInventoryBag);
        // v2/colors
        // v2/commerce
        // v2/continents
        // v2/files
        // v2/items
        // v2/maps
        // v2/materials
        registerFactory(File.class, JsonFilesUtils.INSTANCE::jsonObjectToFile);
        // v2/quaggans
        registerFactory(Quaggan.class, JsonQuaggansUtils.INSTANCE::jsonObjectToQuaggan);
        // v2/recipes
        // v2/skins
        // v2/tokeninfo
        registerFactory(TokenInfo.class, JsonTokenInfoUtils.INSTANCE::jsonObjectToTokenInfo);
        // v2/worlds
        registerFactory(World.class, JsonWorldsUtils.INSTANCE::jsonObjectToWorld);
    }

    public <T> Function<JsonObject, T> registerFactory(final Class<T> type, final Function<JsonObject, T> value) throws NullPointerException {
        Objects.requireNonNull(type);
        final Function<JsonObject, T> result = (Function<JsonObject, T>) factories.put(type, value);
        return result;
    }

    public <T> Optional<Function<JsonObject, T>> findFactory(final Class<T> type) throws NullPointerException {
        Objects.requireNonNull(type);
        final Function<JsonObject, T> result = (Function<JsonObject, T>) factories.get(type);
        return Optional.ofNullable(result);
    }
}
