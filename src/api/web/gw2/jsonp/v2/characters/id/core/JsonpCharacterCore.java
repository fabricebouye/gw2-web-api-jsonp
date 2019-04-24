/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.characters.id.core;

import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.DurationValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.characters.CharacterGender;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.characters.CharacterRace;
import api.web.gw2.mapping.v2.characters.id.core.CharacterCore;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Default JSON-P implementation of a character core.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpCharacterCore implements CharacterCore {

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
    @OptionalValue
    @IdValue
    private OptionalInt title = OptionalInt.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpCharacterCore() {
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
    public OptionalInt getTitle() {
        return title;
    }
}
