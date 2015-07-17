/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters;

import api.web.gw2.mapping.core.JsonUtils;
import api.web.gw2.mapping.v2.V2JsonFactories;
import api.web.gw2.mapping.v2.characters.equipment.Equipment;
import api.web.gw2.mapping.v2.characters.inventory.InventoryBag;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 * A factory that uses JSON-P to produce a character object.
 * @author Fabrice Bouyé
 */
public enum JsonCharactersUtils {

    /**
     * The unique instance of this class.
     */
    INSTANCE;

    /**
     * Gets a factory that allows to create character instances.
     * @return A {@code CharacterFactory} instance, never {@code null}.
     */
    public static CharacterFactory getCharacterFactory() {
        return basecode -> JsonUtils.fromJsonObject(basecode, INSTANCE::jsonObjectToCharacter);
    }

    /**
     * Read from the provided JSON object and return an character object.
     * @param jsonObject The source JSON object.
     * @return A {@code Character} instance, never {@code null}.
     */
    public Character jsonObjectToCharacter(final JsonObject jsonObject) {
        final DefaultCharacter result = new DefaultCharacter();
        result.name = jsonObject.getString("name"); // NOI18N.
        result.race = CharactersUtils.findCharacterRace(jsonObject.getString("race")); // NOI18N.)
        result.profession = CharactersUtils.findCharacterProfession(jsonObject.getString("profession")); // NOI18N.)
        result.gender = CharactersUtils.findCharacterGender(jsonObject.getString("gender")); // NOI18N.)
        result.level = jsonObject.getInt("level"); // NOI18N.        
        result.guild = Optional.ofNullable(JsonUtils.nullOrMissingString(jsonObject, "guild")); // NOI18N.
        result.created = LocalDate.parse(jsonObject.getString("created")); // NOI18N.)
        result.age = jsonObject.getJsonNumber("age").longValue(); // NOI18N.
        result.deaths = jsonObject.getInt("deaths"); // NOI18N.
        final Optional<Function<JsonObject, Equipment>> equipmentConverter = V2JsonFactories.INSTANCE.findFactory(Equipment.class);
        equipmentConverter.ifPresent(converter -> {;
            final JsonArray jsonEquipment = JsonUtils.nullOrMissingJsonArray(jsonObject, "equipment"); // NOI18N.
            final List<Equipment> equipment = JsonUtils.listFromJsonArray(jsonEquipment, JsonObject.class, converter);
            result.equipment = Optional.of(equipment);
        });
        final Optional<Function<JsonObject, InventoryBag>> bagConverger = V2JsonFactories.INSTANCE.findFactory(InventoryBag.class);
        bagConverger.ifPresent(converter -> {;
            final JsonArray jsonBags = JsonUtils.nullOrMissingJsonArray(jsonObject, "bags"); // NOI18N.
            final List<InventoryBag> bags = JsonUtils.listFromJsonArray(jsonBags, JsonObject.class, converter);
            result.bags = Optional.of(bags);
        });
        return result;
    }
}
