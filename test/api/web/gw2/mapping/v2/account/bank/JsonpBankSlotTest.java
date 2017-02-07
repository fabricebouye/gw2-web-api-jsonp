/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.bank;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
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
public final class JsonpBankSlotTest {

    public JsonpBankSlotTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpBankSlot instance;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        instance = new JsonpBankSlot();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 1);
        final Field countField = instance.getClass().getDeclaredField("count"); // NOI18N.
        countField.setAccessible(true);
        countField.setInt(instance, 250);
        final Field skinField = instance.getClass().getDeclaredField("skin"); // NOI18N.
        skinField.setAccessible(true);
        skinField.set(instance, OptionalInt.of(1984));
        final Field upgradesField = instance.getClass().getDeclaredField("upgrades"); // NOI18N.
        upgradesField.setAccessible(true);
        upgradesField.set(instance, Optional.of(Collections.unmodifiableList(Arrays.asList(10))));
        final Field infusionsField = instance.getClass().getDeclaredField("infusions"); // NOI18N.
        infusionsField.setAccessible(true);
        infusionsField.set(instance, Optional.of(Collections.unmodifiableList(Arrays.asList(100))));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JsonpBankSlot.
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
     * Test of getCount method, of class JsonpBankSlot.
     */
    @Test
    public void testGetCount() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getCount");
        final Field countField = instance.getClass().getDeclaredField("count"); // NOI18N.
        countField.setAccessible(true);
        final int expResult = countField.getInt(instance);
        final int result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSkin method, of class JsonpBankSlot.
     */
    @Test
    public void testGetSkin() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getSkin");
        final Field skinField = instance.getClass().getDeclaredField("skin"); // NOI18N.
        skinField.setAccessible(true);
        final OptionalInt expResult = (OptionalInt) skinField.get(instance);
        final OptionalInt result = instance.getSkin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUpgrades method, of class JsonpBankSlot.
     */
    @Test
    public void testGetUpgrades() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getUpgrades");
        final Field upgradesField = instance.getClass().getDeclaredField("upgrades"); // NOI18N.
        upgradesField.setAccessible(true);
        final List<Integer> expResult = (List<Integer>) upgradesField.get(instance);
        final List<Integer> result = instance.getUpgrades();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInfusions method, of class JsonpBankSlot.
     */
    @Test
    public void testGetInfusions() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getInfusions");
        final Field infusionsField = instance.getClass().getDeclaredField("infusions"); // NOI18N.
        infusionsField.setAccessible(true);
        final List<Integer> expResult = (List<Integer>) infusionsField.get(instance);
        final List<Integer> result = instance.getInfusions();
        assertEquals(expResult, result);
    }
}
