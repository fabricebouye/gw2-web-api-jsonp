/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.guild.upgrades;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.DurationValue;
import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.core.LocalizedResource;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.core.SetValue;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.core.URLValue;
import java.time.Duration;
import java.util.Collections;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Default JSON-P implementation of a guild upgrade.
 * @author Fabrice Bouyé
 */
public final class JsonpUpgrade implements Upgrade {

    @IdValue
    private int id = -1;
    @EnumValue
    private UpgradeType type = UpgradeType.UNKNOWN;
    @LocalizedResource
    private String name = ""; // NOI18N.
    @LocalizedResource
    private String description = ""; // NOI18N.
    @URLValue
    private URLReference icon = URLReference.empty();
    @DurationValue
    private Duration buildTime = Duration.ZERO;
    @LevelValue
    private int requiredLevel = 0;
    @QuantityValue
    private int experience = 0;
    @SetValue
    private Set<Integer> prerequisites = Collections.EMPTY_SET;
    @SetValue
    private Set<UpgradeCost> costs = Collections.EMPTY_SET;
    @QuantityValue
    @OptionalValue
    private OptionalInt bagMaxItems = OptionalInt.empty();
    @CoinValue
    @OptionalValue
    private Optional<CoinAmount> bagMaxCoins = Optional.empty();

    /**
     * Creates a new empty instance.
     */
    public JsonpUpgrade() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public UpgradeType getType() {
        return type;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public URLReference getIcon() {
        return icon;
    }

    @Override
    public Duration getBuildTime() {
        return buildTime;
    }

    @Override
    public int getRequiredLevel() {
        return requiredLevel;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public Set<Integer> getPrerequisites() {
        return prerequisites;
    }

    @Override
    public Set<UpgradeCost> getCosts() {
        return costs;
    }

    @Override
    public OptionalInt getBagMaxItems() {
        return bagMaxItems;
    }

    @Override
    public Optional<CoinAmount> getBagMaxCoins() {
        return bagMaxCoins;
    }
}
