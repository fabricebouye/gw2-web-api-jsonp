/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.quaggans;

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
public class JsonpQuagganTest {
    
    public JsonpQuagganTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private JsonpQuaggan instance;
    
    @Before
    public void setUp() {
        instance = new JsonpQuaggan();
        instance.id = "testId"; // NOI18N.
        instance.url = "testUrl"; // NOI18N.
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpQuaggan.
     */
    @Test
    public void testGetId() {
        System.out.println("getId"); // NOI18N.
        final JsonpQuaggan instance = this.instance;
        final String expResult = "testId"; // NOI18N.
        final String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUrl method, of class JsonpQuaggan.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl"); // NOI18N.
        final JsonpQuaggan instance = this.instance;
        final String expResult = "testUrl"; // NOI18N.
        final String result = instance.getUrl();
        assertEquals(expResult, result);
    }
    
}
