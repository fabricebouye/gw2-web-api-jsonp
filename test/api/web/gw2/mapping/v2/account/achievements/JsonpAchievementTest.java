/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.achievements;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
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
public final class JsonpAchievementTest {

    public JsonpAchievementTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpAchievement instance;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        instance = new JsonpAchievement();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 1);
        final Field currentField = instance.getClass().getDeclaredField("current"); // NOI18N.
        currentField.setAccessible(true);
        currentField.set(instance, OptionalInt.of(50));
        final Field maxField = instance.getClass().getDeclaredField("max"); // NOI18N.
        maxField.setAccessible(true);
        maxField.set(instance, OptionalInt.of(100));
        final Field doneField = instance.getClass().getDeclaredField("done"); // NOI18N.
        doneField.setAccessible(true);
        doneField.setBoolean(instance, false);
        final Field bitsField = instance.getClass().getDeclaredField("bits"); // NOI18N.
        bitsField.setAccessible(true);
        bitsField.set(instance, Optional.of(Collections.unmodifiableSet(new HashSet(Arrays.asList(2, 5, 7)))));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JsonpAchievement.
     */
    @Test
    public void testGetId() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getId");
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        final int expResult = idField.getInt(instance);
        final int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrent method, of class JsonpAchievement.
     */
    @Test
    public void testGetCurrent() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getCurrent");
        final Field currentField = instance.getClass().getDeclaredField("current"); // NOI18N.
        currentField.setAccessible(true);
        final OptionalInt expResult = (OptionalInt) currentField.get(instance);
        final OptionalInt result = instance.getCurrent();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMax method, of class JsonpAchievement.
     */
    @Test
    public void testGetMax() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getMax");
        final Field maxField = instance.getClass().getDeclaredField("max"); // NOI18N.
        maxField.setAccessible(true);
        final OptionalInt expResult = (OptionalInt) maxField.get(instance);
        final OptionalInt result = instance.getMax();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDone method, of class JsonpAchievement.
     */
    @Test
    public void testIsDone() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("isDone");
        final Field doneField = instance.getClass().getDeclaredField("done"); // NOI18N.
        doneField.setAccessible(true);
        final boolean expResult = doneField.getBoolean(instance);
        final boolean result = instance.isDone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBits method, of class JsonpAchievement.
     */
    @Test
    public void testGetBits() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getBits");
        final Field bitsField = instance.getClass().getDeclaredField("bits"); // NOI18N.
        bitsField.setAccessible(true);
        final Optional<Set<Integer>> expResult = (Optional<Set<Integer>>) bitsField.get(instance);
        final Optional<Set<Integer>> result = instance.getBits();
        assertEquals(expResult, result);
    }
}
