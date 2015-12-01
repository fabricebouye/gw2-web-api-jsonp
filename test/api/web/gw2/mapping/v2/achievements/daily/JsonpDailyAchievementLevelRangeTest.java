/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.achievements.daily;

import java.lang.reflect.Field;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test.
 * @author Fabrice Bouyé
 */
public final class JsonpDailyAchievementLevelRangeTest {

    public JsonpDailyAchievementLevelRangeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpDailyAchievementLevelRange instance;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        instance = new JsonpDailyAchievementLevelRange();
        final Field minField = instance.getClass().getDeclaredField("min"); // NOI18N.
        minField.setAccessible(true);
        minField.setInt(instance, 5);
        final Field maxField = instance.getClass().getDeclaredField("max"); // NOI18N.
        maxField.setAccessible(true);
        maxField.setInt(instance, 15);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMin method, of class JsonpDailyAchievementLevelRange.
     */
    @Test
    public void testGetMin() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getMin");
        final Field minField = instance.getClass().getDeclaredField("min"); // NOI18N.
        minField.setAccessible(true);
        int expResult = minField.getInt(instance);
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMax method, of class JsonpDailyAchievementLevelRange.
     */
    @Test
    public void testGetMax() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getMax");
        final Field maxField = instance.getClass().getDeclaredField("max"); // NOI18N.
        maxField.setAccessible(true);
        int expResult = maxField.getInt(instance);
        int result = instance.getMax();
        assertEquals(expResult, result);
    }
}
