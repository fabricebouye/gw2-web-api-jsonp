/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.wallet;

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
public class JsonpCurrentyAmountTest {

    public JsonpCurrentyAmountTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private JsonpCurrencyAmount instance;

    @Before
    public void setUp() throws Exception {
        instance = new JsonpCurrencyAmount();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 58);
        final Field valueField = instance.getClass().getDeclaredField("value"); // NOI18N.
        valueField.setAccessible(true);
        valueField.setInt(instance, 450);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpCurrentyAmount.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId"); // NOI18N.
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        final int expResult = idField.getInt(instance);
        final int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class JsonpCurrentyAmount.
     */
    @Test
    public void testGetValue() throws Exception {
        System.out.println("getValue"); // NOI18N.
        final Field valueField = instance.getClass().getDeclaredField("value"); // NOI18N.
        valueField.setAccessible(true);
        final int expResult = valueField.getInt(instance);
        final int result = instance.getValue();
        assertEquals(expResult, result);
    }
}
