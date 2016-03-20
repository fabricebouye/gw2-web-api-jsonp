/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.achievements;

import api.web.gw2.mapping.core.URLReference;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
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
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, MalformedURLException {
        instance = new JsonpAchievement();
        final Field idField = instance.getClass().getDeclaredField("id"); // NOI18N.
        idField.setAccessible(true);
        idField.setInt(instance, 1);
        final Field iconField = instance.getClass().getDeclaredField("icon"); // NOI18N.
        iconField.setAccessible(true);
        iconField.set(instance, URLReference.of("http://foo.foo.foo/foo.png")); // NOI18N.
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        nameField.set(instance, "Foo"); // NOI18N.
        final Field descriptionField = instance.getClass().getDeclaredField("description"); // NOI18N.
        descriptionField.setAccessible(true);
        descriptionField.set(instance, "Fuu"); // NOI18N.
        final Field requirementField = instance.getClass().getDeclaredField("requirement"); // NOI18N.
        requirementField.setAccessible(true);
        requirementField.set(instance, "Fii"); // NOI18N.
        final Field typeField = instance.getClass().getDeclaredField("type"); // NOI18N.
        typeField.setAccessible(true);
        typeField.set(instance, AchievementType.DEFAULT);
        final Field flagsField = instance.getClass().getDeclaredField("flags"); // NOI18N.
        flagsField.setAccessible(true);
        flagsField.set(instance, Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(
                AchievementFlag.PVP,
                AchievementFlag.MOVE_TO_TOP
        ))));
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
        final int expResult = (int) idField.get(instance);
        final int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIcon method, of class JsonpAchievement.
     */
    @Test
    public void testGetIcon() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getIcon");
        final Field iconField = instance.getClass().getDeclaredField("icon"); // NOI18N.
        iconField.setAccessible(true);
        final URLReference expResult = (URLReference) iconField.get(instance);
        final URLReference result = instance.getIcon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class JsonpAchievement.
     */
    @Test
    public void testGetName() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getName");
        final Field nameField = instance.getClass().getDeclaredField("name"); // NOI18N.
        nameField.setAccessible(true);
        final String expResult = (String) nameField.get(instance);
        final String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class JsonpAchievement.
     */
    @Test
    public void testGetDescription() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getDescription");
        final Field descriptionField = instance.getClass().getDeclaredField("description"); // NOI18N.
        descriptionField.setAccessible(true);
        String expResult = (String) descriptionField.get(instance);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequirement method, of class JsonpAchievement.
     */
    @Test
    public void testGetRequirement() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getRequirement");
        final Field requirementField = instance.getClass().getDeclaredField("requirement"); // NOI18N.
        requirementField.setAccessible(true);
        final String expResult = (String) requirementField.get(instance);
        final String result = instance.getRequirement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class JsonpAchievement.
     */
    @Test
    public void testGetType() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getType");
        final Field typeField = instance.getClass().getDeclaredField("type"); // NOI18N.
        typeField.setAccessible(true);
        final AchievementType expResult = (AchievementType) typeField.get(instance);
        final AchievementType result = instance.getType();
    }

    /**
     * Test of getFlags method, of class JsonpAchievement.
     */
    @Test
    public void testGetFlags() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getFlags");
        final Field flagsField = instance.getClass().getDeclaredField("flags"); // NOI18N.
        flagsField.setAccessible(true);
        final Set<AchievementFlag> expResult = (Set<AchievementFlag>) flagsField.get(instance);
        final Set<AchievementFlag> result = instance.getFlags();
        assertEquals(expResult, result);
    }
}
