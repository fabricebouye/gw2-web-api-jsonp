/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.tokeninfo;

import api.web.gw2.mapping.v2.tokeninfo.TokenInfoPermission;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test.
 *
 * @author Fabrice Bouyé
 */
public class JsonpTokenInfoTest {

    public JsonpTokenInfoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private JsonpTokenInfo instance;

    @BeforeEach
    public void setUp() throws Exception {
        instance = new JsonpTokenInfo();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.set(instance, "testId"); // NOI18N.
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        nameField.set(instance, "Test Key"); // NOI18N.
        final Field permissionsField = instance.getClass().getDeclaredField("permissions"); // NOI18N.
        permissionsField.setAccessible(true);
        permissionsField.set(instance, Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(TokenInfoPermission.ACCOUNT))));
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getId method, of class JsonpTokenInfo.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId");
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        final String expResult = (String) idField.get(instance);
        final String result = instance.getId();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class JsonpTokenInfo.
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

    /**
     * Test of getPermissions method, of class JsonpTokenInfo.
     */
    @Test
    public void testGetPermissions() throws Exception {
        System.out.println("getPermissions");
        final Field permissionsdield = instance.getClass().getDeclaredField("permissions"); // NOI18N.
        permissionsdield.setAccessible(true);
        final Set<TokenInfoPermission> expResult = (Set<TokenInfoPermission>) permissionsdield.get(instance);
        final Set<TokenInfoPermission> result = instance.getPermissions();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

}
