/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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
public final class JsonpAccountTest {

    public JsonpAccountTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpAccount instance;

    @Before
    public void setUp() throws Exception {
        instance = new JsonpAccount();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.set(instance, "testId"); // NOI18N.
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        nameField.set(instance, "Test.1234"); // NOI18N.
        final Field worldField = instance.getClass().getDeclaredField("world"); // NOI18N.
        worldField.setAccessible(true);
        worldField.setInt(instance, 10);
        final Field guildsField = instance.getClass().getDeclaredField("guilds"); // NOI18N.
        guildsField.setAccessible(true);
        guildsField.set(instance, Collections.unmodifiableSet(new HashSet<>(Arrays.asList("test-guild")))); // NOI18N.
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpAccount.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId"); // NOI18N.
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        final String expResult = (String) idField.get(instance);
        final String result = instance.getId();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class JsonpAccount.
     */
    @Test
    public void testGetName() throws Exception {
        System.out.println("getName"); // NOI18N.
        final Field nameFdield = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameFdield.setAccessible(true);
        final String expResult = (String) nameFdield.get(instance);
        final String result = instance.getName();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWorld method, of class JsonpAccount.
     */
    @Test
    public void testGetWorld() throws Exception {
        System.out.println("getWorld"); // NOI18N.
        final Field worldField = instance.getClass().getDeclaredField("world"); // NOI18N.
        worldField.setAccessible(true);
        final int expResult = worldField.getInt(instance);
        final int result = instance.getWorld();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGuilds method, of class JsonpAccount.
     */
    @Test
    public void testGetGuilds() throws Exception {
        System.out.println("getGuilds"); // NOI18N.
        final Field guildsField = instance.getClass().getDeclaredField("guilds"); // NOI18N.
        guildsField.setAccessible(true);
        final Set<String> expResult = (Set<String>) guildsField.get(instance);
        final Set<String> result = instance.getGuilds();
        assertNotNull(result);
        assertEquals(expResult, result);
    }
}
