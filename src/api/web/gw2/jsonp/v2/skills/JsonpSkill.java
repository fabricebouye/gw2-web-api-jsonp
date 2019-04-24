/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.skills;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.items.ItemWeaponType;
import api.web.gw2.mapping.v2.professions.ProfessionElementalistAttunement;
import api.web.gw2.mapping.v2.skills.*;

import java.util.Collections;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of a skill.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpSkill implements Skill {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @LocalizedResource
    private String name = LocalizedResource.DEFAULT;
    @LocalizedResource
    @OptionalValue
    private Optional<String> description = Optional.empty();
    @URLValue
    private URLReference icon = URLReference.empty();
    private String chatLink = LocalizedResource.DEFAULT;
    @EnumValue
    private SkillType type = SkillType.UNKNOWN;
    @EnumValue
    private SkillWeaponType weaponType = SkillWeaponType.UNKNOWN;
    @SetValue
    @EnumValue
    private Set<CharacterProfession> professions = Collections.EMPTY_SET;
    @EnumValue
    private SkillSlot slot = SkillSlot.UNKNOWN;
    @SetValue
    private Set<SkillFact> facts = Collections.EMPTY_SET;
    @SetValue
    private Set<SkillTraitedFact> traitedFacts = Collections.EMPTY_SET;
    @SetValue
    private Set<SkillCategory> categories = Collections.EMPTY_SET;
    @OptionalValue
    @EnumValue
    private Optional<ProfessionElementalistAttunement> attunement = Optional.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt cost = OptionalInt.empty();
    @OptionalValue
    @EnumValue
    private Optional<ItemWeaponType> dualWield = Optional.empty();
    @OptionalValue
    @IdValue
    private OptionalInt flipSkill = OptionalInt.empty();
    @OptionalValue
    @QuantityValue
    private OptionalInt initiative = OptionalInt.empty();
    @OptionalValue
    @IdValue
    private OptionalInt nextChain = OptionalInt.empty();
    @OptionalValue
    @IdValue
    private OptionalInt prevChain = OptionalInt.empty();
    @SetValue
    @IdValue
    private Set<Integer> transformSkills = Collections.EMPTY_SET;
    @SetValue
    @IdValue
    private Set<Integer> bundleSkills = Collections.EMPTY_SET;
    @OptionalValue
    @IdValue
    private OptionalInt toolbeltSkill = OptionalInt.empty();
    @SetValue
    private Set<?> flags = Collections.EMPTY_SET;

    /**
     * Creates a new empty instance.
     */
    public JsonpSkill() {
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
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public String getChatLink() {
        return chatLink;
    }

    @Override
    public SkillType getType() {
        return type;
    }

    @Override
    public SkillWeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public Set<CharacterProfession> getProfessions() {
        return professions;
    }

    @Override
    public SkillSlot getSlot() {
        return slot;
    }

    @Override
    public Set<SkillFact>
    getFacts() {
        return facts;
    }

    @Override
    public Set<SkillTraitedFact> getTraitedFacts() {
        return traitedFacts;
    }

    @Override
    public Set<SkillCategory>
    getCategories() {
        return categories;
    }

    @Override
    public Optional<ProfessionElementalistAttunement> getAttunement() {
        return attunement;
    }

    @Override
    public OptionalInt getCost() {
        return cost;
    }

    @Override
    public Optional<ItemWeaponType> getDualWield() {
        return dualWield;
    }

    @Override
    public OptionalInt getFlipSkill() {
        return flipSkill;
    }

    @Override
    public OptionalInt getInitiative() {
        return initiative;
    }

    @Override
    public OptionalInt getNextChain() {
        return nextChain;
    }

    @Override
    public OptionalInt getPrevChain() {
        return prevChain;
    }

    @Override
    public Set<Integer>
    getTransformSkills() {
        return transformSkills;
    }

    @Override
    public Set<Integer> getBundleSkills() {
        return bundleSkills;
    }

    @Override
    public OptionalInt getToolbeltSkill() {
        return toolbeltSkill;
    }

    @Override
    public Set<?> getFlags() {
        return flags;
    }
}
