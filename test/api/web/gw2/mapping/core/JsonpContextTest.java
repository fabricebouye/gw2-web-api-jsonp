/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import api.web.gw2.mapping.v2.account.Account;
import api.web.gw2.mapping.v2.account.wallet.CurrencyAmount;
import api.web.gw2.mapping.v2.quaggans.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test.
 * @author Fabrice Bouyé
 */
public class JsonpContextTest {

    public JsonpContextTest() {
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

    @Test
    public void testJsonKeyToJavaFieldName() throws NoSuchMethodException {
        System.out.println("jsonKeyToJavaFieldName"); // NOI18N.
        final String[] values = {
            "demo",
            "demo_d",
            "demo_d_d",
            "demo_d_demo",
            "demo_demo",
            "demo_demo_d",
            "demo_demo_demo"
        };
        final String[] expResults = {
            "demo",
            "demoD",
            "demoDD",
            "demoDDemo",
            "demoDemo",
            "demoDemoD",
            "demoDemoDemo"
        };
        assertEquals(values.length, expResults.length);
        final Class aClass = JsonpContext.INSTANCE.getClass();
        final Method method = aClass.getDeclaredMethod("jsonKeyToJavaFieldName", String.class); // NOI18N.
        method.setAccessible(true);
        IntStream.range(0, values.length)
                .forEach(index -> {
                    try {
                        final String value = values[index];
                        final String expResult = expResults[index];
                        final String result = (String) method.invoke(JsonpContext.INSTANCE, value);
                        assertEquals(expResult, result);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadObject_Quaggan_Remote() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Quaggan remote)"); // NOI18N.
        final String expId = "box"; // NOI18N.
        final Optional<URL> expURL = Optional.of(new URL("https://static.staticwars.com/quaggans/box.jpg")); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/quaggans/quaggan1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final Quaggan value = instance.loadObject(Quaggan.class, url);
        assertNotNull(value);
        assertEquals(expId, value.getId());
        assertEquals(expURL, value.getUrl());
    }

    @Test
    public void testLoadObject_Account_Local() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Account local)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/account/account1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final Account value = instance.loadObject(Account.class, url);
        assertNotNull(value);
        assertEquals("b8169418-1c11-405f-91bb-e2b29d602b8a", value.getId()); // NOI18N.
        assertEquals("ExampleAccount.1234", value.getName()); // NOI18N.
        assertEquals(1007, value.getWorld());
        assertEquals(Collections.unmodifiableSet(new HashSet(Arrays.asList("75FD83CF-0C45-4834-BC4C-097F93A487AF"))), value.getGuilds()); // NOI18N.
    }

    private String loadApplicationKey() throws IOException {
        final Path configFile = Paths.get("settings.properties"); // NOI18N.
        assertTrue(Files.exists(configFile));
        assertTrue(Files.isRegularFile(configFile));
        assertTrue(Files.isReadable(configFile));
        final Properties settings = new Properties();
        try (final InputStream input = Files.newInputStream(configFile)) {
            settings.load(input);
        }
        final String appKey = settings.getProperty("app.key"); // NOI18N.
        assertNotNull(appKey);
        return appKey;
    }

    @Test
    public void testLoadObject_Account_Remote() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Account remote)"); // NOI18N.
        final String appKey = loadApplicationKey();
        final String path = String.format("https://api.guildwars2.com/v2/account?access_token=%s", appKey);
        final URL url = new URL(path);
        final Account result = JsonpContext.INSTANCE.loadObject(Account.class, url);
        assertNotNull(result);
//        System.out.println(result.getId());
//        System.out.println(result.getName());
//        System.out.println(result.getWorld());
//        result.getGuilds().forEach(System.out::println);
//        System.out.println(result.getCreated());
    }

    @Test
    public void testLoadObject_CurrencyAmount() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(CurrencyAmount)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/account/wallet/currency_amount1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final CurrencyAmount value = instance.loadObject(CurrencyAmount.class, url);
        assertNotNull(value);
        assertEquals(1, value.getId());
        assertEquals(100001, value.getValue());
    }

    @Test
    public void testLoadPage_Integer_Local() throws IOException {
        System.out.println("loadPage(integer local)"); // NOI18N.
        final int expPageTotal = 1;
        final int expPageSize = 10;
        final int expResultCount = expPageSize;
        final int expResultTotal = expPageSize;
        final URL url = getClass().getResource("test_page1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final PageResult<Integer> value = instance.loadPage(Integer.class, url);
        assertNotNull(value);
        assertEquals(expPageTotal, value.getPageTotal());
        assertEquals(expPageSize, value.getPageSize());
        assertEquals(expResultCount, value.getResultCount());
        assertEquals(expResultTotal, value.getResultTotal());
        final Iterator<Integer> iterator = value.iterator();
        IntStream.range(0, expPageSize).forEach(index -> {
            final int expResult = index;
            final int result = iterator.next();
            assertEquals(expResult, result);
        });
    }

    @Test
    public void testLoadPage_Quaggan_Remote() throws IOException {
        System.out.println("loadPage(Quaggan remote)"); // NOI18N.
        final int pageIndex = 1;
        final int pageSize = 10;
        final String[] urls = {
            "https://api.guildwars2.com/v2/quaggans"
        };
        final Class[] classes = {
            Quaggan.class
        };
        final JsonpContext instance = JsonpContext.INSTANCE;
        assertEquals(urls.length, classes.length);
        IntStream.range(0, urls.length)
                .forEach(index -> {
                    try {
                        final String url = urls[index];
                        final Class aClass = classes[index];
                        final String path = String.format("%s?page=%d&page_size=%d", url, pageIndex, pageSize);
                        System.out.println(path);
                        final PageResult page = instance.loadPage(aClass, new URL(path));
                        assertNotNull(page);
                    } catch (IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }

    @Test
    public void testLoadPage_Character_Remote() throws IOException {
        System.out.println("loadPage(Character remote)"); // NOI18N.
        final String appKey = loadApplicationKey();
        final String path = String.format("https://api.guildwars2.com/v2/characters?access_token=%s", appKey);
        final URL url = new URL(path);
        final PageResult<String> result = JsonpContext.INSTANCE.loadPage(String.class, url);
        assertNotNull(result);
        result.stream().forEach(characterName -> {
        });
    }
}
