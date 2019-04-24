/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.achievements.daily;

import api.web.gw2.mapping.core.LevelValue;
import api.web.gw2.mapping.v2.achievements.daily.DailyAchievementLevelRange;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpDailyAchievementTest {

    public JsonpDailyAchievementTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpDailyAchievement instance;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        instance = new JsonpDailyAchievement();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 1);
        final Field levelField = instance.getClass().getDeclaredField("level"); // NOI18N.
        levelField.setAccessible(true);
        levelField.set(instance, new DailyAchievementLevelRange() {
            @Override
            public int getMin() {
                return LevelValue.MIN_LEVEL;
            }

            @Override
            public int getMax() {
                return LevelValue.MAX_LEVEL;
            }
        });
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JsonpDailyAchievement.
     */
    @Test
    public void testGetId() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getId");
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        int expResult = idField.getInt(instance);
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLevel method, of class JsonpDailyAchievement.
     */
    @Test
    public void testGetLevel() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getLevel");
        final Field levelField = instance.getClass().getDeclaredField("level"); // NOI18N.
        levelField.setAccessible(true);
        DailyAchievementLevelRange expResult = (DailyAchievementLevelRange) levelField.get(instance);
        DailyAchievementLevelRange result = instance.getLevel();
        assertEquals(expResult, result);
    }
}
