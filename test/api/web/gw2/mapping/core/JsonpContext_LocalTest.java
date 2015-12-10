/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import api.web.gw2.mapping.v2.account.Account;
import api.web.gw2.mapping.v2.account.bank.BankSlot;
import api.web.gw2.mapping.v2.account.wallet.CurrencyAmount;
import api.web.gw2.mapping.v2.achievements.Achievement;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievement;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievementLevelRange;
import api.web.gw2.mapping.v2.characters.Character;
import api.web.gw2.mapping.v2.characters.CharacterCrafting;
import api.web.gw2.mapping.v2.characters.equipment.Equipment;
import api.web.gw2.mapping.v2.characters.inventory.InventoryBag;
import api.web.gw2.mapping.v2.materials.MaterialStorage;
import api.web.gw2.mapping.v2.minis.Mini;
import api.web.gw2.mapping.v2.recipes.RecipeCraftingDiscipline;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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

/**
 * Unit test.
 * @author Fabrice Bouyé
 */
public class JsonpContext_LocalTest {

    public JsonpContext_LocalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLoadObject_Account_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Account local)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/account/account1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final Account value = instance.loadObject(Account.class, url);
        assertNotNull(value);
        assertEquals("b8169418-1c11-405f-91bb-e2b29d602b8a", value.getId()); // NOI18N.
        assertEquals("ExampleAccount.1234", value.getName()); // NOI18N.
        assertEquals(1007, value.getWorld());
        assertEquals(Collections.unmodifiableSet(new HashSet(Arrays.asList("75FD83CF-0C45-4834-BC4C-097F93A487AF"))), value.getGuilds()); // NOI18N.
    }

    @Test
    public void testLoadObject_CurrencyAmount_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(CurrencyAmount local)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/account/wallet/currency_amount1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final CurrencyAmount value = instance.loadObject(CurrencyAmount.class, url);
        assertNotNull(value);
        assertEquals(1, value.getId());
        assertEquals(100001, value.getValue());
    }

    @Test
    public void testLoadObject_Mini_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Mini local)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/minis/mini1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final Mini value = instance.loadObject(Mini.class, url);
        assertNotNull(value);
        assertEquals(1, value.getId());
        assertEquals("Mini-Rytlock", value.getName()); // NOI18N.
        assertEquals(Optional.empty(), value.getUnlock());
        assertEquals(Optional.of(new URL("https://render.guildwars2.com/file/795ED1B945A29EC3E3066797DF57FFB25ABAA631/340551.png")), value.getIcon()); // NOI18N.
        assertEquals(1, value.getOrder());
        assertEquals(21047, value.getItemId());
    }

    @Test
    public void testLoadObject_Character_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Character local)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/characters/character1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final Character value = instance.loadObject(Character.class, url);
        assertNotNull(value);
    }

    @Test
    public void testLoadObject_CharacterCrafting_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(CharacterCrafting local)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/characters/charactercrafting1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final CharacterCrafting value = instance.loadObject(CharacterCrafting.class, url);
        assertNotNull(value);
        assertEquals(RecipeCraftingDiscipline.ARTIFICER, value.getDiscipline());
        assertEquals(500, value.getRating());
        assertEquals(true, value.isActive());
    }

    @Test
    public void testLoadObject_Equipment_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Equipment local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/characters/equipment/";
        final String[] filenames = {
            "equipment1.json",
            "equipment2.json",
            "equipment3.json",
            "equipment4.json"
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    try {
                        final String filename = filenames[index];
                        final URL url = getClass().getResource(basecode + filename); // NOI18N.
                        final JsonpContext instance = JsonpContext.INSTANCE;
                        final Equipment value = instance.loadObject(Equipment.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_InventoryBag_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(InventoryBag local)"); // NOI18N.
        final String basecode = "/api/web/gw2/mapping/v2/characters/inventory/";
        final String[] filenames = {
            "inventorybag1.json",
            "inventorybag2.json"
        };
        IntStream.range(0, filenames.length)
                .forEach(index -> {
                    try {
                        final String filename = filenames[index];
                        final URL url = getClass().getResource(basecode + filename); // NOI18N.
                        final JsonpContext instance = JsonpContext.INSTANCE;
                        final InventoryBag value = instance.loadObject(InventoryBag.class, url);
                        assertNotNull(value);
                    } catch (NullPointerException | IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_MaterialStorage_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(MaterialStorage local)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/materials/materialstorage1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final MaterialStorage value = instance.loadObject(MaterialStorage.class, url);
        assertNotNull(value);
        assertEquals(38, value.getId());
        assertEquals("Festive Materials", value.getName()); // NOI18N.
        assertEquals(Collections.unmodifiableSet(new HashSet(Arrays.asList(36060, 36061, 36059, 36041, 38130, 38131, 38132, 38133, 38134, 38135, 43319, 47909, 48807, 48805, 48806))), value.getItems());
    }

    @Test
    public void testLoadObject_Achievement_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Achievement local)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/achievements/achievement1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final Achievement value = instance.loadObject(Achievement.class, url);
        assertNotNull(value);
        assertEquals(1840, value.getId());
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
            try {
                final String file = files[index];
                final URL url = getClass().getResource(baseCode + file);
                final JsonpContext instance = JsonpContext.INSTANCE;
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
        final Optional[] expBits = {
            Optional.empty(),
            Optional.empty(),
            Optional.of(Collections.unmodifiableSet(new HashSet(Arrays.asList(2, 3, 4, 5)))),};
        assertEquals(files.length, expIds.length);
        assertEquals(files.length, expCurrents.length);
        assertEquals(files.length, expMaxs.length);
        assertEquals(files.length, expDones.length);
        assertEquals(files.length, expBits.length);
        IntStream.range(0, files.length).forEach(index -> {
            try {
                final String file = files[index];
                final URL url = getClass().getResource(baseCode + file);
                final JsonpContext instance = JsonpContext.INSTANCE;
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
                final Optional<Set<Integer>> expBit = expBits[index];
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
        final JsonpContext instance = JsonpContext.INSTANCE;
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
        String file = "bankresponse.json"; // NOI18N.
        final URL url = getClass().getResource(baseCode + file); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final PageResult<BankSlot> value = instance.loadPage(BankSlot.class, url);
        value.stream().forEach(System.out::println);
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
}
