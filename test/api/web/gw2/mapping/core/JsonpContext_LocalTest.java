/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import api.web.gw2.mapping.v2.account.Account;
import api.web.gw2.mapping.v2.account.wallet.CurrencyAmount;
import api.web.gw2.mapping.v2.achievements.Achievement;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievement;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievementLevelRange;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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
}
