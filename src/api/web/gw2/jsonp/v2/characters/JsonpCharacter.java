/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.DurationValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.ListValue;
import api.web.gw2.mapping.core.MapValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.v2.characters.CharacterGender;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.characters.CharacterRace;
import api.web.gw2.mapping.v2.characters.id.crafting.CharacterCrafting;
import api.web.gw2.mapping.v2.characters.id.equipment.CharacterEquipment;
import api.web.gw2.mapping.v2.characters.id.equipment_pvp.CharacterEquipmentPvP;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventoryBag;
import api.web.gw2.mapping.v2.characters.id.skills.CharacterSkillSet;
import api.web.gw2.mapping.v2.characters.id.specializations.CharacterSpecialization;
import api.web.gw2.mapping.v2.characters.id.specializations.CharacterSpecializationGameType;
import api.web.gw2.mapping.v2.characters.id.training.CharacterTraining;
import api.web.gw2.mapping.v2.characters.id.wvw_abilities.CharacterAbility;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Default JSON-P implementation of a character.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacter implements api.web.gw2.mapping.v2.characters.Character {

    @IdValue(flavor = IdValue.Flavor.STRING)
    private String name = IdValue.DEFAULT_STRING_ID;
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
    @DurationValue
    private Duration age = DurationValue.DEFAULT;
    @QuantityValue
    private int deaths = QuantityValue.DEFAULT;
    @ListValue
    private List<CharacterEquipment> equipment = Collections.EMPTY_LIST;
    @ListValue
    private List<CharacterInventoryBag> bags = Collections.EMPTY_LIST;
    @SetValue
    private Set<CharacterCrafting> crafting = Collections.EMPTY_SET;
    @MapValue
    @SetValue
    private Map<CharacterSpecializationGameType, Set<CharacterSpecialization>> specializations = Collections.EMPTY_MAP;
    @SetValue
    @IdValue
    private Set<Integer> recipes = Collections.EMPTY_SET;
    @MapValue
    private Map<CharacterSpecializationGameType, CharacterSkillSet> skills = Collections.EMPTY_MAP;
    @SetValue
    @IdValue
    private Set<Integer> backstory = Collections.EMPTY_SET;
    @OptionalValue
    @IdValue
    private OptionalInt title = OptionalInt.empty();
    @SetValue
    private Set<CharacterTraining> training = Collections.EMPTY_SET;
    @OptionalValue
    private Optional<CharacterEquipmentPvP> equipmentPvp = Optional.empty();
    @SetValue
    private Set<CharacterAbility> wvwAbilities = Collections.EMPTY_SET;

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
    public Duration getAge() {
        return age;
    }

    @Override
    public int getDeaths() {
        return deaths;
    }

    @Override
    public List<CharacterEquipment> getEquipment() {
        return equipment;
    }

    @Override
    public List<CharacterInventoryBag> getBags() {
        return bags;
    }

    @Override
    public Set<CharacterCrafting> getCrafting() {
        return crafting;
    }

    @Override
    public Map<CharacterSpecializationGameType, Set<CharacterSpecialization>> getSpecializations() {
        return specializations;
    }

    @Override
    public Set<Integer> getRecipes() {
        return recipes;
    }

    @Override
    public Map<CharacterSpecializationGameType, CharacterSkillSet> getSkills() {
        return skills;
    }

    @Override
    public Set<Integer> getBackstory() {
        return backstory;
    }

    @Override
    public OptionalInt getTitle() {
        return title;
    }

    @Override
    public Set<CharacterTraining> getTraining() {
        return training;
    }

    @Override
    public Optional<CharacterEquipmentPvP> getEquipmentPvp() {
        return equipmentPvp;
    }

    @Override
    public Set<CharacterAbility> getWvwAbilities() {
        return wvwAbilities;
    }
}
