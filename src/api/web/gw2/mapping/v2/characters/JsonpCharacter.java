/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.characters.inventory.InventoryBag;
import api.web.gw2.mapping.v2.characters.equipment.Equipment;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Default JSON-P implementation of a character.
 * @author Fabrice Bouyé
 */
public final class JsonpCharacter implements Character {

    private String name = "";
    @EnumValue
    private CharacterRace race = CharacterRace.UNKNOWN;
    @EnumValue
    private CharacterProfession profession = CharacterProfession.UNKNOWN;
    @EnumValue
    private CharacterGender gender = CharacterGender.UNKNOWN;
    @LevelValue
    private int level = LevelValue.MIN_LEVEL;
    @OptionalValue
    @IdValue(flavor = IdValue.Flavor.STRING)
    private Optional<String> guild = Optional.empty();
    @DateValue
    private ZonedDateTime created = DateValue.DEFAULT;
    @QuantityValue
    private long age = 0;
    @QuantityValue
    private int deaths = 0;
    @OptionalValue
    @ListValue
    private Optional<List<Equipment>> equipment = Optional.empty();
    @OptionalValue
    @ListValue
    private Optional<List<InventoryBag>> bags = Optional.empty();
    @OptionalValue
    @SetValue
    private Optional<Set<CharacterCrafting>> crafting = Optional.empty();
    @OptionalValue
    @MapValue
    private Optional<Map<CharacterGameType, CharacterSpecialization>> specializations = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacter() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CharacterRace getRace() {
        return race;
    }

    @Override
    public CharacterProfession getProfession() {
        return profession;
    }

    @Override
    public CharacterGender getGender() {
        return gender;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public Optional<String> getGuild() {
        return guild;
    }

    @Override
    public ZonedDateTime getCreated() {
        return created;
    }

    @Override
    public long getAge() {
        return age;
    }

    @Override
    public int getDeaths() {
        return deaths;
    }

    @Override
    public Optional<List<Equipment>> getEquipment() {
        return equipment;
    }

    @Override
    public Optional<List<InventoryBag>> getBags() {
        return bags;
    }

    @Override
    public Optional<Set<CharacterCrafting>> getCrafting() {
        return crafting;
    }

    @Override
    public Optional<Map<CharacterGameType, CharacterSpecialization>> getSpecialisations() {
        return specializations;
    }
}
