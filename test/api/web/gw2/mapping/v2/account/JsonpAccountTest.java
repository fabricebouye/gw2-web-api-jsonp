/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account;

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
public class JsonpAccountTest {

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
    public void setUp() {
        instance = new JsonpAccount();
        instance.id = "testId"; // NOI18N.
        instance.name = "Test.1234"; // NOI18N.
        instance.world = 10;
        instance.guilds = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("test-guild"))); // NOI18N.
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpAccount.
     */
    @Test
    public void testGetId() {
        System.out.println("getId"); // NOI18N.
        final JsonpAccount instance = this.instance;
        final String expResult = "testId"; // NOI18N.
        final String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class JsonpAccount.
     */
    @Test
    public void testGetName() {
        System.out.println("getName"); // NOI18N.
        final JsonpAccount instance = this.instance;
        final String expResult = "Test.1234";// NOI18N.
        final String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWorld method, of class JsonpAccount.
     */
    @Test
    public void testGetWorld() {
        System.out.println("getWorld"); // NOI18N.
        final JsonpAccount instance = this.instance;
        final int expResult = 10;
        final int result = instance.getWorld();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGuilds method, of class JsonpAccount.
     */
    @Test
    public void testGetGuilds() {
        System.out.println("getGuilds"); // NOI18N.
        final JsonpAccount instance = this.instance;
        final Set<String> expResult = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("test-guild"))); // NOI18N.
        final Set<String> result = instance.getGuilds();
        assertEquals(expResult, result);
    }
}
