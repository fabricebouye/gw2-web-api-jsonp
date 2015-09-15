/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.account.wallet;

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

    private JsonpCurrentyAmount instance;

    @Before
    public void setUp() {
        instance = new JsonpCurrentyAmount();
        instance.id = 58;
        instance.value = 450;
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpCurrentyAmount.
     */
    @Test
    public void testGetId() {
        System.out.println("getId"); // NOI18N.
        final JsonpCurrentyAmount instance = this.instance;
        final int expResult = 58;
        final int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class JsonpCurrentyAmount.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue"); // NOI18N.
        final JsonpCurrentyAmount instance = this.instance;
        final int expResult = 450;
        final int result = instance.getValue();
        assertEquals(expResult, result);
    }
}
