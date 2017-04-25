/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import api.web.gw2.mapping.v2.account.Account;
import api.web.gw2.mapping.v2.account.AccountAccessType;
import api.web.gw2.mapping.v2.account.bank.BankSlot;
import api.web.gw2.mapping.v2.account.finishers.FinisherUnlock;
import api.web.gw2.mapping.v2.account.home.cats.Cat;
import api.web.gw2.mapping.v2.account.inventory.SharedInventory;
import api.web.gw2.mapping.v2.account.wallet.CurrencyAmount;
import api.web.gw2.mapping.v2.achievements.Achievement;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievement;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievementLevelRange;
import api.web.gw2.mapping.v2.backstory.answers.BackstoryAnswer;
import api.web.gw2.mapping.v2.backstory.questions.BackstoryQuestion;
import api.web.gw2.mapping.v2.characters.Character;
import api.web.gw2.mapping.v2.characters.id.crafting.CharacterCrafting;
import api.web.gw2.mapping.v2.characters.CharacterProfession;
import api.web.gw2.mapping.v2.characters.id.core.CharacterCore;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventoryBinding;
import api.web.gw2.mapping.v2.continents.Continent;
import api.web.gw2.mapping.v2.currencies.Currency;
import api.web.gw2.mapping.v2.finishers.Finisher;
import api.web.gw2.mapping.v2.guild.id.Guild;
import api.web.gw2.mapping.v2.guild.id.log.LogEvent;
import api.web.gw2.mapping.v2.guild.id.stash.Stash;
import api.web.gw2.mapping.v2.guild.id.teams.Team;
import api.web.gw2.mapping.v2.guild.id.treasury.Treasury;
import api.web.gw2.mapping.v2.guild.upgrades.Upgrade;
import api.web.gw2.mapping.v2.items.Item;
import api.web.gw2.mapping.v2.items.ItemDetails;
import api.web.gw2.mapping.v2.items.ItemType;
import api.web.gw2.mapping.v2.itemstats.Itemstats;
import api.web.gw2.mapping.v2.legends.Legend;
import api.web.gw2.mapping.v2.maps.Map;
import api.web.gw2.mapping.v2.materials.MaterialStorage;
import api.web.gw2.mapping.v2.minis.Mini;
import api.web.gw2.mapping.v2.pets.Pet;
import api.web.gw2.mapping.v2.professions.Profession;
import api.web.gw2.mapping.v2.pvp.amulets.Amulet;
import api.web.gw2.mapping.v2.pvp.games.Game;
import api.web.gw2.mapping.v2.pvp.seasons.Season;
import api.web.gw2.mapping.v2.pvp.seasons.leaderboards.LeaderboardEntry;
import api.web.gw2.mapping.v2.pvp.standings.Standing;
import api.web.gw2.mapping.v2.pvp.stats.Stat;
import api.web.gw2.mapping.v2.recipes.Recipe;
import api.web.gw2.mapping.v2.recipes.RecipeCraftingDiscipline;
import api.web.gw2.mapping.v2.skins.JsonpSkinArmorDetails;
import api.web.gw2.mapping.v2.skins.Skin;
import api.web.gw2.mapping.v2.skins.SkinFlag;
import api.web.gw2.mapping.v2.skins.SkinType;
import api.web.gw2.mapping.v2.specializations.Specialization;
import api.web.gw2.mapping.v2.stories.Story;
import api.web.gw2.mapping.v2.stories.seasons.StorySeason;
import api.web.gw2.mapping.v2.titles.Title;
import api.web.gw2.mapping.v2.traits.Trait;
import api.web.gw2.mapping.v2.traits.TraitFact;
import api.web.gw2.mapping.v2.worlds.World;
import api.web.gw2.mapping.v2.worlds.WorldPopulation;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import api.web.gw2.mapping.v2.characters.id.equipment.CharacterEquipment;
import api.web.gw2.mapping.v2.characters.id.inventory.CharacterInventoryBag;
import api.web.gw2.mapping.v2.characters.id.sab.CharacterSabResponse;
import api.web.gw2.mapping.v2.dungeons.Dungeon;
import api.web.gw2.mapping.v2.gliders.Glider;
import api.web.gw2.mapping.v2.mailcarriers.MailCarrier;
import api.web.gw2.mapping.v2.pvp.ranks.PvpRank;
import api.web.gw2.mapping.v2.races.Race;
import api.web.gw2.mapping.v2.raids.Raid;
import api.web.gw2.mapping.v2.wvw.ranks.WvwRank;
import api.web.gw2.mapping.v2.wvw.objectives.WvwObjective;
import api.web.gw2.mapping.v2.wvw.matches.WvwMatch;

/**
 * Unit test.
 * @author Fabrice Bouyé
 */
public final class JsonpContext_SAX_LocalTest {

    public JsonpContext_SAX_LocalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    final JsonpContext instance = JsonpContext.SAX;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLoadObject_World_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(World local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/worlds/"; // NOI18N.
        final String filename = "world1.json"; // NOI18N.
        final URL url = getClass().getResource(basecode + filename);
        assertNotNull(url);
        final World value = instance.loadObject(World.class, url);
        assertNotNull(value);
        assertEquals(1001, value.getId());
        assertEquals("Anvil Rock", value.getName()); // NOI18N.
        assertEquals(WorldPopulation.MEDIUM, value.getPopulation());
    }

    @Test
    public void testLoadObject_Account_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Account local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/account/"; // NOI18N.
        final String filename = "account1.json"; // NOI18N.
        final URL url = getClass().getResource(basecode + filename);
        assertNotNull(url);
        final Account value = instance.loadObject(Account.class, url);
        assertNotNull(value);
        assertEquals("b8169418-1c11-405f-91bb-e2b29d602b8a", value.getId()); // NOI18N.
        assertEquals("ExampleAccount.1234", value.getName()); // NOI18N.
        assertEquals(1007, value.getWorld());
        assertEquals(Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList("75FD83CF-0C45-4834-BC4C-097F93A487AF"))), value.getGuilds()); // NOI18N.
        assertEquals(AccountAccessType.GUILD_WARS_2, value.getAccess());
        assertEquals(64, value.getFractalLevel());
    }

    @Test
    public void testLoadObject_CurrencyAmount_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(CurrencyAmount local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/account/wallet/"; // NOI18N.
        final String filename = "currency_amount1.json"; // NOI18N.
        final URL url = getClass().getResource(basecode + filename);
        assertNotNull(url);
        final CurrencyAmount value = instance.loadObject(CurrencyAmount.class, url);
        assertNotNull(value);
        assertEquals(1, value.getId());
        assertEquals(100001, value.getValue());
    }

    @Test
    public void testLoadObject_Mini_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Mini local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/minis/"; // NOI18N.
        final String filename = "mini1.json"; // NOI18N.
        final URL url = getClass().getResource(basecode + filename);
        assertNotNull(url);
        final Mini value = instance.loadObject(Mini.class, url);
        assertNotNull(value);
        assertEquals(1, value.getId());
        assertEquals("Mini-Rytlock", value.getName()); // NOI18N.
        assertEquals(Optional.empty(), value.getUnlock());
        assertEquals(URLReference.of("https://render.guildwars2.com/file/795ED1B945A29EC3E3066797DF57FFB25ABAA631/340551.png"), value.getIcon()); // NOI18N.
        assertEquals(1, value.getOrder());
        assertEquals(21047, value.getItemId());
    }

    @Test
    public void testLoadObject_Specialization_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Specialization local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/specializations/"; // NOI18N.
        final String filename = "specialization1.json"; // NOI18N.
        final URL url = getClass().getResource(basecode + filename);
        assertNotNull(url);
        final Specialization value = instance.loadObject(Specialization.class, url);
        assertNotNull(value);
        assertEquals(1, value.getId());
        assertEquals("Dueling", value.getName()); // NOI18N.
        assertEquals(CharacterProfession.MESMER, value.getProfession());
        assertEquals(false, value.isElite());
    }

    @Test
    public void testLoadObject_Trait_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Trait local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/traits/"; // NOI18N.
        final String[] filenames = {
            "trait1.json", // NOI18N.
            "trait2.json" // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Trait value = instance.loadObject(Trait.class, url);
                        assertNotNull(value);
                        assertEquals(214, value.getId());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Character_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Character local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/characters/"; // NOI18N.
        final String[] filenames = {
            "character1.json", // NOI18N.
            "character2.json" // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Character value = instance.loadObject(Character.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_CharacterCore_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(CharacterCore local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/characters/id/core/"; // NOI18N.
        final String[] filenames = {
            "charactercore1.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final CharacterCore value = instance.loadObject(CharacterCore.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_CharacterCrafting_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(CharacterCrafting local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/characters/id/crafting/"; // NOI18N.
        final String filename = "charactercrafting1.json"; // NOI18N.
        final URL url = getClass().getResource(basecode + filename);
        assertNotNull(url);
        final CharacterCrafting value = instance.loadObject(CharacterCrafting.class, url);
        assertNotNull(value);
        assertEquals(RecipeCraftingDiscipline.ARTIFICER, value.getDiscipline());
        assertEquals(500, value.getRating());
        assertEquals(true, value.isActive());
    }

    @Test
    public void testLoadObject_CharacterSab_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(CharacterSab local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/characters/id/sab/"; // NOI18N.
        final String[] filenames = {"sab1.json"}; // NOI18N.
        final int[] expZoneNumbers = {18};
        final int[] expUnlockNumbers = {17};
        final int[] expSongNumbers = {3};
        assertEquals(filenames.length, expZoneNumbers.length);
        assertEquals(filenames.length, expUnlockNumbers.length);
        assertEquals(filenames.length, expSongNumbers.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final CharacterSabResponse value = instance.loadObject(CharacterSabResponse.class, url);
                        assertNotNull(value);
                        final int expZoneNumber = expZoneNumbers[index];
                        assertEquals(expZoneNumber, value.getZones().size());
                        final int expUnlockNumber = expUnlockNumbers[index];
                        assertEquals(expUnlockNumber, value.getUnlocks().size());
                        final int expSongNumber = expSongNumbers[index];
                        assertEquals(expSongNumber, value.getSongs().size());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Equipment_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Equipment local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/characters/id/equipment/"; // NOI18N.
        final String[] filenames = {
            "equipment1.json", // NOI18N.
            "equipment2.json", // NOI18N.
            "equipment3.json", // NOI18N.
            "equipment4.json" // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final CharacterEquipment value = instance.loadObject(CharacterEquipment.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_InventoryBag_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(InventoryBag local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/characters/id/inventory/"; // NOI18N.
        final String[] filenames = {
            "inventorybag1.json", // NOI18N.
            "inventorybag2.json" // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final CharacterInventoryBag value = instance.loadObject(CharacterInventoryBag.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_MaterialStorage_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(MaterialStorage local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/materials/"; // NOI18N.
        final String filename = "materialstorage1.json"; // NOI18N.
        final URL url = getClass().getResource(basecode + filename);
        assertNotNull(url);
        final MaterialStorage value = instance.loadObject(MaterialStorage.class, url);
        assertNotNull(value);
        assertEquals(38, value.getId());
        assertEquals("Festive Materials", value.getName()); // NOI18N.
        assertEquals(Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(36060, 36061, 36059, 36041, 38130, 38131, 38132, 38133, 38134, 38135, 43319, 47909, 48807, 48805, 48806))), value.getItems());
    }

    @Test
    public void testLoadObject_Achievement_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Achievement local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/achievements/"; // NOI18N.
        final String[] files = {
            "achievement1.json", // NOI18N.
            "achievement2.json", // NOI18N.
            "achievement3.json" // NOI18N.
        };
        final int[] expIds = {
            1840,
            910,
            2258
        };
        assertEquals(files.length, expIds.length);
        IntStream.range(0, files.length).forEach(index -> {
            final String file = files[index];
            final URL url = getClass().getResource(basecode + file);
            assertNotNull(url);
            try {
                final Achievement value = instance.loadObject(Achievement.class, url);
                assertNotNull(value);
                final int expId = expIds[index];
                assertEquals(expId, value.getId());
            } catch (IOException ex) {
                fail(ex.getMessage());
            }
        });
    }

    @Test
    public void testLoadObject_DailyAchievement_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(DailyAchievement local)"); // NOI18N.
        final String baseCode = "/api/web/gw2/mapping/v2/achievements/daily/";// NOI18N.
        final String[] files = {
            "achievement1.json", // NOI18N.
            "achievement2.json" // NOI18N.
        };
        final int[] expIds = {
            1984,
            1931
        };
        final DailyAchievementLevelRange[] expLevels = {
            DailyAchievementLevelRange.ALL_LEVELS,
            new DailyAchievementLevelRange() {
                @Override
                public boolean equals(Object obj) {
                    return equals((DailyAchievementLevelRange) obj);
                }

                @Override
                public int getMin() {
                    return 11;
                }

                @Override
                public int getMax() {
                    return 80;
                }
            }};
        assertEquals(files.length, expIds.length);
        assertEquals(files.length, expLevels.length);
        IntStream.range(0, files.length).forEach(index -> {
            final String file = files[index];
            final URL url = getClass().getResource(baseCode + file);
            assertNotNull(url);
            try {
                final DailyAchievement value = instance.loadObject(DailyAchievement.class, url);
                assertNotNull(value);
                final int expId = expIds[index];
                assertEquals(expId, value.getId());
                final DailyAchievementLevelRange expLevel = expLevels[index];
                assertEquals(expLevel, value.getLevel());
            } catch (IOException ex) {
                fail(ex.getMessage());
            }
        });
    }

    @Test
    public void testLoadObject_AccountAchievement_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(AccountAchievement local)"); // NOI18N.
        final String baseCode = "/api/web/gw2/mapping/v2/account/achievements/";// NOI18N.
        final String[] files = {
            "achievement1.json", // NOI18N.
            "achievement2.json", // NOI18N.
            "achievement3.json" // NOI18N.
        };
        final int[] expIds = {
            1,
            202,
            1653
        };
        final OptionalInt[] expCurrents = {
            OptionalInt.of(1),
            OptionalInt.empty(),
            OptionalInt.of(4)
        };
        final OptionalInt[] expMaxs = {
            OptionalInt.of(1000),
            OptionalInt.empty(),
            OptionalInt.of(30)
        };
        final boolean[] expDones = {
            false,
            true,
            false
        };
        final Set[] expBits = {
            Collections.EMPTY_SET,
            Collections.EMPTY_SET,
            Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(2, 3, 4, 5)))
        };
        assertEquals(files.length, expIds.length);
        assertEquals(files.length, expCurrents.length);
        assertEquals(files.length, expMaxs.length);
        assertEquals(files.length, expDones.length);
        assertEquals(files.length, expBits.length);
        IntStream.range(0, files.length).forEach(index -> {
            final String file = files[index];
            final URL url = getClass().getResource(baseCode + file);
            assertNotNull(url);
            try {
                final api.web.gw2.mapping.v2.account.achievements.Achievement value = instance.loadObject(api.web.gw2.mapping.v2.account.achievements.Achievement.class, url);
                assertNotNull(value);
                final int expId = expIds[index];
                assertEquals(expId, value.getId());
                final OptionalInt expCurrent = expCurrents[index];
                assertEquals(expCurrent, value.getCurrent());
                final OptionalInt expMax = expMaxs[index];
                assertEquals(expMax, value.getMax());
                final boolean expDone = expDones[index];
                assertEquals(expDone, value.isDone());
                final Set<Integer> expBit = expBits[index];
                assertEquals(expBit, value.getBits());
            } catch (IOException ex) {
                fail(ex.getMessage());
            }
        });
    }

    @Test
    public void testLoadPage_Integer_Local() throws IOException {
        System.out.println("loadPage(integer local)"); // NOI18N.
        final int expPageTotal = 1;
        final int expPageSize = 10;
        final int expResultCount = expPageSize;
        final int expResultTotal = expPageSize;
        final URL url = getClass().getResource("test_page1.json"); // NOI18N.
        assertNotNull(url);
        final PageResult<Integer> value = instance.loadPage(Integer.class, url);
        assertNotNull(value);
        assertEquals(expPageTotal, value.getPageTotal());
        assertEquals(expPageSize, value.getPageSize());
        assertEquals(expResultCount, value.getResultCount());
        assertEquals(expResultTotal, value.getResultTotal());
        final Iterator<Integer> iterator = value.iterator();
        IntStream.range(0, expPageSize).forEach(index -> {
            final int expResult = index;
            final int result = iterator.next();
            assertEquals(expResult, result);
        });
    }

    @Test
    public void testLoadPage_BankSlot_Local() throws IOException {
        System.out.println("loadPage(BankSlot local)"); // NOI18N.
        final boolean[] expIsNulls = {
            false,
            true,
            true,
            false,
            true,
            false
        };
        final String baseCode = "/api/web/gw2/mapping/v2/account/bank/"; // NOI18N.
        String filename = "bankresponse.json"; // NOI18N.
        final URL url = getClass().getResource(baseCode + filename);
        assertNotNull(url);
        final PageResult<BankSlot> value = instance.loadPage(BankSlot.class, url);
//        value.stream().forEach(System.out::println);
        assertNotNull(value);
        final int expPageSize = expIsNulls.length;
        assertEquals(expPageSize, value.getResultCount());
        final Iterator<BankSlot> iterator = value.iterator();
        IntStream.range(0, expPageSize).forEach(index -> {
            final BankSlot result = iterator.next();
            final boolean expIsNull = expIsNulls[index];
            final boolean isNull = result == null;
            assertEquals(expIsNull, isNull);
        });
    }

    @Test
    public void testLoadRuntimeObject_TraitFact_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(TraitFact local)"); // NOI18N.
        final String baseCode = "/api/web/gw2/mapping/v2/traits/";// NOI18N.
        final String[] files = {
            "fact-attributeadjust.json", // NOI18N.
            "fact-buff.json", // NOI18N.
            "fact-buffconversion.json", // NOI18N.
            "fact-combofield.json", // NOI18N.
            "fact-combofinisher.json", // NOI18N.
            "fact-damage.json", // NOI18N.
            "fact-distance.json", // NOI18N.
            "fact-nodata.json", // NOI18N.
            "fact-number.json", // NOI18N.
            "fact-percent.json", // NOI18N.
            "fact-prefixedbuff.json", // NOI18N.
            "fact-radius.json", // NOI18N.
            "fact-range.json", // NOI18N.
            "fact-recharge.json", // NOI18N.
            "fact-time.json", // NOI18N.
            "fact-unblockable.json", // NOI18N.
        };
        IntStream.range(0, files.length).forEach(index -> {
            System.out.println(files[index]);
            final String file = files[index];
            final URL url = getClass().getResource(baseCode + file);
            assertNotNull(url);
            try {
                final TraitFact value = instance.loadRuntimeObject("type", "api.web.gw2.mapping.v2.traits.Trait%sFact", url);
                assertNotNull(value);
            } catch (IOException ex) {
                fail(ex.getMessage());
            }
        });
    }

    @Test
    public void testLoadObject_Skin_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Skin local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/skins/"; // NOI18N.
        final String[] filenames = {
            "skin1.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Skin value = instance.loadObject(Skin.class, url);
                        assertNotNull(value);
                        assertEquals(10, value.getId());
                        assertEquals("Seer Pants", value.getName());
                        assertEquals(SkinType.ARMOR, value.getType());
                        assertEquals(URLReference.of("https://render.guildwars2.com/file/1920ACA302E656B60C38605521760351F147809D/61088.png"), value.getIcon());
                        assertEquals(Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(SkinFlag.SHOW_IN_WARDROBE))), value.getFlags());
                        assertTrue(value.getDetails().isPresent());
                        assertEquals(JsonpSkinArmorDetails.class, value.getDetails().get().getClass());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_WvwObjective_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(WvwObjective local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/wvw/objectives/"; // NOI18N.
        final String[] filenames = {
            "objective1.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final WvwObjective value = instance.loadObject(WvwObjective.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_WvwMatch_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(WvwMatch local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/wvw/matches/"; // NOI18N.
        final String[] filenames = {
            "match1.json", // NOI18N.
        };
        final String[] expIds = {
            "1-3" // NOI18N.
        };
        assertEquals(filenames.length, expIds.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final WvwMatch value = instance.loadObject(WvwMatch.class, url);
                        assertNotNull(value);
                        final String expId = expIds[index];
                        assertEquals(expId, value.getId());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Recipe_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Recipe local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/recipes/"; // NOI18N.
        final String[] filenames = {
            "recipe1.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Recipe value = instance.loadObject(Recipe.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadRuntimeObject_ItemDetails_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(ItemDetails local)"); // NOI18N.
        final String classPattern = "api.web.gw2.mapping.v2.items.Item%sDetails";
        final String baseCode = "/api/web/gw2/mapping/v2/items/";// NOI18N.    
        // @todo Need more test files.
        final String[] files = {
            "details-armor.json", // NOI18N.
            "details-back.json", // NOI18N.
            "details-bag.json", // NOI18N.
            "details-consumable.json", // NOI18N.
            "details-container.json", // NOI18N.
            "details-gathering.json", // NOI18N.
            "details-gizmo.json", // NOI18N.
            //"details-minipet.json", // NOI18N.
            "details-tool.json", // NOI18N.
            "details-trinket.json", // NOI18N.
            "details-upgradecomponent.json", // NOI18N.
            "details-weapon.json", // NOI18N.
        };
        // As the type is determined in the parent object we cannot use loadRuntimeObject() for this test.
        final ItemType[] expItemTypes = {
            ItemType.ARMOR,
            ItemType.BACK,
            ItemType.BAG,
            ItemType.CONSUMABLE,
            ItemType.CONTAINER,
            ItemType.GATHERING,
            ItemType.GIZMO,
            //ItemType.MINI_PET,
            ItemType.TOOL,
            ItemType.TRINKET,
            ItemType.UPGRADE_COMPONENT,
            ItemType.WEAPON
        };
        assertEquals(files.length, expItemTypes.length);
        IntStream.range(0, files.length).forEach(index -> {
            System.out.println(files[index]);
            final String file = files[index];
            final URL url = getClass().getResource(baseCode + file);
            assertNotNull(url);
            final ItemType expItemType = expItemTypes[index];
            final String token = JsonpUtils.INSTANCE.javaEnumToJavaClassName(expItemType);
            final String className = String.format(classPattern, token);
            try {
                final Class<? extends ItemDetails> detailsClass = (Class<? extends ItemDetails>) Class.forName(className);
                final ItemDetails value = instance.loadObject(detailsClass, url);
                assertNotNull(value);
                assertEquals(expItemType, value.getItemType());
            } catch (Exception ex) {
                fail(ex.getMessage());
            }
        });
    }

    @Test
    public void testLoadObject_Currency_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Currency local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/currencies/"; // NOI18N.
        final String[] filenames = {
            "currency1.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Currency value = instance.loadObject(Currency.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Continent_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Continent local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/continents/"; // NOI18N.
        final String[] filenames = {
            "continent1.json", // NOI18N.
            "continent2.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Continent value = instance.loadObject(Continent.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Map_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Map local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/maps/"; // NOI18N.
        final String[] filenames = {
            "map1.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Map value = instance.loadObject(Map.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Item_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Item local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/items/"; // NOI18N.
        final String[] filenames = {
            "item01.json", // NOI18N.
            "item02.json", // NOI18N.
            "item03.json", // NOI18N.
            "item04.json", // NOI18N.
            "item05.json", // NOI18N.
            "item06.json", // NOI18N.
            "item07.json", // NOI18N.
            "item08.json", // NOI18N.
            "item09.json", // NOI18N.
            "item10.json", // NOI18N.
            "item11.json", // NOI18N.
            "item12.json", // NOI18N.
            "item13.json", // NOI18N.
            "item14.json", // NOI18N.
            "item15.json", // NOI18N.
            "item16.json", // NOI18N.
            "item17.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Item value = instance.loadObject(Item.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Game_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Game local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/pvp/games/"; // NOI18N.
        final String[] filenames = {
            "game01.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Game value = instance.loadObject(Game.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Stat_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Stat local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/pvp/stats/"; // NOI18N.
        final String[] filenames = {
            "stat01.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Stat value = instance.loadObject(Stat.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Season_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Season local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/pvp/seasons/"; // NOI18N.
        final String[] filenames = {
            "season01.json", // NOI18N.
            "season02.json", // NOI18N.
            "season05.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Season value = instance.loadObject(Season.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_LeaderboardEntry_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(LeaderboardEntry local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/pvp/seasons/leaderboards/"; // NOI18N.
        final String[] filenames = {
            "leaderboard01.json", // NOI18N.
            "leaderboard02.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final LeaderboardEntry value = instance.loadObject(LeaderboardEntry.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Standing_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Standing local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/pvp/standings/"; // NOI18N.
        final String[] filenames = {
            "standing01.json", // NOI18N.
            "standing02.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Standing value = instance.loadObject(Standing.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_LogEvent_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(LogEvent local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/guild/id/log/"; // NOI18N.
        final String[] filenames = {
            "eventlog01.json", // NOI18N.
            "eventlog02.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final LogEvent value = instance.loadObject(LogEvent.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Stash_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Stash local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/guild/id/stash/"; // NOI18N.
        final String[] filenames = {
            "stash01.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Stash value = instance.loadObject(Stash.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Treasury_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Treasury local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/guild/id/treasury/"; // NOI18N.
        final String[] filenames = {
            "treasury01.json", // NOI18N.
            "treasury02.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Treasury value = instance.loadObject(Treasury.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Team_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Team local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/guild/id/teams/"; // NOI18N.
        final String[] filenames = {
            "team01.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Team value = instance.loadObject(Team.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_SharedInventory_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(SharedInventory local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/account/inventory/"; // NOI18N.
        final String[] filenames = {
            "inventories.json", // NOI18N.
        };
        final int[] expectedIds = {44602, 20321};
        final int[] expectedCounts = {1, 1};
        assertEquals(expectedIds.length, expectedCounts.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Collection<SharedInventory> value = instance.loadObjectArray(SharedInventory.class, url);
                        assertEquals(expectedIds.length, value.size());
                        final Iterator<SharedInventory> it = value.iterator();
                        IntStream.range(0, expectedIds.length)
                                .forEach(i -> {
                                    final SharedInventory sharedInventory = it.next();
                                    assertEquals(expectedIds[i], sharedInventory.getId());
                                    assertEquals(expectedCounts[i], sharedInventory.getCount());
                                    assertEquals(CharacterInventoryBinding.ACCOUNT, sharedInventory.getBinding());
                                });
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Upgrade_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Upgrade local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/guild/upgrades/"; // NOI18N.
        final String[] filenames = {
            "upgrade01.json", // NOI18N.
            "upgrade02.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Upgrade value = instance.loadObject(Upgrade.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Profession_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Profession local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/professions/"; // NOI18N.
        final String[] filenames = {
            "profession01.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Profession value = instance.loadObject(Profession.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_TitlesLocal() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Titles local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/titles/"; // NOI18N.
        final String[] filenames = {
            "titles.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Collection<Title> value = instance.loadObjectArray(Title.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_LegendsLocal() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Legends local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/legends/"; // NOI18N.
        final String[] filenames = {
            "legends.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Collection<Legend> value = instance.loadObjectArray(Legend.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_AmuletsLocal() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Amulets local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/pvp/amulets/"; // NOI18N.
        final String[] filenames = {
            "amulets.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Collection<Amulet> value = instance.loadObjectArray(Amulet.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_ItemstatsLocal() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Itemstats local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/itemstats/"; // NOI18N.
        final String[] filenames = {
            "itemstats.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Collection<Itemstats> value = instance.loadObjectArray(Itemstats.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Finisher() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Finisher local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/finishers/"; // NOI18N.
        final String[] filenames = {
            "finisher01.json", // NOI18N.
            "finisher02.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Finisher value = instance.loadObject(Finisher.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_FinisherUnlock() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(FinisherUnlock local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/account/finishers/"; // NOI18N.
        final String[] filenames = {
            "finisherunlocks.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Collection<FinisherUnlock> value = instance.loadObjectArray(FinisherUnlock.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_BackstoryAnswer() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(BackstoryAnswer local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/backstory/answers/"; // NOI18N.
        final String[] filenames = {
            "answer1.json", // NOI18N.
            "answer2.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final BackstoryAnswer value = instance.loadObject(BackstoryAnswer.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_BackstoryQuestion() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(BackstoryQuestion local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/backstory/questions/"; // NOI18N.
        final String[] filenames = {
            "question1.json", // NOI18N.
            "question2.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final BackstoryQuestion value = instance.loadObject(BackstoryQuestion.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Pet() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Pet local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/pets/"; // NOI18N.
        final String[] filenames = {
            "pet1.json", // NOI18N.
            "pet2.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Pet value = instance.loadObject(Pet.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Story() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Story local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/stories/"; // NOI18N.
        final String[] filenames = {
            "story1.json", // NOI18N.
            "story2.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Story value = instance.loadObject(Story.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_StorySeason() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(StorySeason local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/stories/seasons/"; // NOI18N.
        final String[] filenames = {
            "season1.json", // NOI18N.
            "season2.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final StorySeason value = instance.loadObject(StorySeason.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_WvwRank() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(WvwRank local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/wvw/ranks/"; // NOI18N.
        final String[] filenames = {
            "rank01.json", // NOI18N.
            "rank02.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final WvwRank value = instance.loadObject(WvwRank.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Guild() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Guild local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/guild/id/"; // NOI18N.
        final String[] filenames = {
            "guild01.json", // NOI18N.
            "guild02.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Guild value = instance.loadObject(Guild.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Cat() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Cat)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/account/home/cats/"; // NOI18N.
        final String[] filenames = {
            "cat01.json", // NOI18N.
            "cat27.json", // NOI18N.
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Cat value = instance.loadObject(Cat.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Dungeon() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Dungeon)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/dungeons/"; // NOI18N.
        final String[] filenames = {
            "dungeon01.json", // NOI18N.
        };
        final String[] expIds = {"caudecus_manor"}; // NOI18N.
        assertEquals(filenames.length, expIds.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Dungeon value = instance.loadObject(Dungeon.class, url);
                        assertNotNull(value);
                        final String expId = expIds[index];
                        assertEquals(expId, value.getId());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Glider() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Glider)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/gliders/"; // NOI18N.
        final String[] filenames = {
            "glider01.json", // NOI18N.
        };
        final int[] expIds = {1};
        assertEquals(filenames.length, expIds.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Glider value = instance.loadObject(Glider.class, url);
                        assertNotNull(value);
                        final int expId = expIds[index];
                        assertEquals(expId, value.getId());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_PvpRank() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(PvpRank)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/pvp/ranks/"; // NOI18N.
        final String[] filenames = {
            "rank01.json", // NOI18N.
            "rank02.json", // NOI18N.
        };
        final int[] expIds = {
            2,
            4,};
        assertEquals(filenames.length, expIds.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final PvpRank value = instance.loadObject(PvpRank.class, url);
                        assertNotNull(value);
                        final int expId = expIds[index];
                        assertEquals(expId, value.getId());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Race() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Race)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/races/"; // NOI18N.
        final String[] filenames = {
            "race01.json", // NOI18N.
        };
        final String[] expIds = {
            "Asura",};
        assertEquals(filenames.length, expIds.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Race value = instance.loadObject(Race.class, url);
                        assertNotNull(value);
                        final String expId = expIds[index];
                        assertEquals(expId, value.getId());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Raid() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Raid)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/raids/"; // NOI18N.
        final String[] filenames = {
            "raid01.json", // NOI18N.
            "raid02.json", // NOI18N.
        };
        final String[] expIds = {
            "forsaken_thicket", // NOI18N.
            "bastion_of_the_penitent",}; // NOI18N.
        assertEquals(filenames.length, expIds.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final Raid value = instance.loadObject(Raid.class, url);
                        assertNotNull(value);
                        final String expId = expIds[index];
                        assertEquals(expId, value.getId());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_MailCarrier() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(MailCarrier)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/mailcarriers/"; // NOI18N.
        final String[] filenames = {
            "mailcarrier01.json", // NOI18N.
            "mailcarrier02.json", // NOI18N.
            "mailcarrier03.json", // NOI18N.
        };
        final int[] expIds = {
            4,
            1,
            14,};
        assertEquals(filenames.length, expIds.length);
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    final String filename = filenames[index];
                    final URL url = getClass().getResource(basecode + filename);
                    assertNotNull(url);
                    try {
                        final MailCarrier value = instance.loadObject(MailCarrier.class, url);
                        assertNotNull(value);
                        final int expId = expIds[index];
                        assertEquals(expId, value.getId());
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }
}
