/* 
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.account.bank;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Unit test.
 * @author Fabrice Bouyé
 */
public final class JsonpBankSlotTest {

    public JsonpBankSlotTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpAccountBankSlot instance;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        instance = new JsonpAccountBankSlot();
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
        upgradesField.set(instance, Collections.unmodifiableList(Arrays.asList(10)));
        final Field infusionsField = instance.getClass().getDeclaredField("infusions"); // NOI18N.
        infusionsField.setAccessible(true);
        infusionsField.set(instance, Collections.unmodifiableList(Arrays.asList(100)));
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JsonpAccountBankSlot.
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
     * Test of getCount method, of class JsonpAccountBankSlot.
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
     * Test of getSkin method, of class JsonpAccountBankSlot.
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
     * Test of getUpgrades method, of class JsonpAccountBankSlot.
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
     * Test of getInfusions method, of class JsonpAccountBankSlot.
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
