/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.web.gw2.jsonp.v2.worlds;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test.
 *
 * @author FabriceB
 */
public class JsonpWorldTest {

    public JsonpWorldTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpWorld instance;

    @BeforeEach
    public void setUp() throws Exception {
        instance = new JsonpWorld();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 1); // NOI18N.
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        nameField.set(instance, "Test World"); // NOI18N.
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpWorld.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId");
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        final int expResult = idField.getInt(instance);
        final int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class JsonpWorld.
     */
    @Test
    public void testGetName() throws Exception {
        System.out.println("getName");
        final Field nameFdield = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameFdield.setAccessible(true);
        final String expResult = (String) nameFdield.get(instance);
        final String result = instance.getName();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

}
