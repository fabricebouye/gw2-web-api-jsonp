/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.v2.characters;

import api.web.gw2.mapping.core.JsonUtils;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import javax.json.JsonObject;
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
public class JsonCharactersUtilsTest {

    public JsonCharactersUtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private void testCharacter(final JsonObject jsonObject, final Character result) {
        assertNotNull(jsonObject);
        assertNotNull(result);
        assertEquals(jsonObject.getString("name"), result.getName()); // NOI18N.
        assertEquals(CharactersUtils.findCharacterGender(jsonObject.getString("gender")), result.getGender()); // NOI18N.
        assertEquals(CharactersUtils.findCharacterProfession(jsonObject.getString("profession")), result.getProfession()); // NOI18N.
        assertEquals(CharactersUtils.findCharacterRace(jsonObject.getString("race")), result.getRace()); // NOI18N.
        assertEquals(jsonObject.getInt("level"), result.getLevel()); // NOI18N.
        assertEquals(jsonObject.getInt("age"), result.getAge()); // NOI18N.
        assertEquals(jsonObject.getInt("deaths"), result.getDeaths()); // NOI18N.        
        assertEquals(Optional.ofNullable(jsonObject.getString("guild")), result.getGuild()); // NOI18N.
        assertEquals(LocalDate.parse(jsonObject.getString("created")), result.getCreated()); // NOI18N.        
    }

    /**
     * Test of getCharacterFactory method, of class JsonCharactersUtils.
     */
    @Test
    public void testGetCharacterFactory() throws IOException {
        System.out.println("getCharacterFactory"); // NOI18N.
        final CharacterFactory factory = JsonCharactersUtils.getCharacterFactory();
        assertNotNull(factory);
        final URL url = getClass().getResource("character1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonObject jsonObject = JsonUtils.asJsonObject(basecode);
        final Character result = factory.create(basecode);
        testCharacter(jsonObject, result);
    }

    /**
     * Test of jsonObjectToCharacter method, of class JsonCharactersUtils.
     */
    @Test
    public void testJsonObjectToCharacter() throws IOException {
        System.out.println("jsonObjectToCharacter"); // NOI18N.
        final URL url = getClass().getResource("character1.json"); // NOI18N.
        final String basecode = url.toExternalForm();
        final JsonObject jsonObject = JsonUtils.asJsonObject(basecode);
        final Character result = JsonCharactersUtils.INSTANCE.jsonObjectToCharacter(jsonObject);
        testCharacter(jsonObject, result);
    }
}
