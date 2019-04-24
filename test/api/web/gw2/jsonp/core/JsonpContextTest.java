/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.core;

import api.web.gw2.mapping.core.PageResult;
import api.web.gw2.mapping.core.URLReference;
import api.web.gw2.mapping.v2.account.Account;
import api.web.gw2.mapping.v2.account.wallet.AccountCurrencyAmount;
import api.web.gw2.mapping.v2.guild.id.ranks.GuildRank;
import api.web.gw2.mapping.v2.guild.permissions.GuildPermission;
import api.web.gw2.mapping.v2.guild.permissions.GuildPermissionId;
import api.web.gw2.mapping.v2.quaggans.Quaggan;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit test.
 *
 * @author Fabrice Bouyé
 */
public class JsonpContextTest {

    public JsonpContextTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testLoadObject_Quaggan_Remote() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Quaggan remote)"); // NOI18N.
        final String expId = "box"; // NOI18N.
        final URLReference expURL = URLReference.of(new URL("https://static.staticwars.com/quaggans/box.jpg")); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/quaggans/quaggan1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.SAX;
        final Quaggan value = instance.loadObject(Quaggan.class, url);
        assertNotNull(value);
        assertEquals(expId, value.getId());
        assertEquals(expURL, value.getUrl());
    }

    private String loadApplicationKey() throws IOException {
        System.out.println(System.getProperty("user.dir"));
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
        final Account result = JsonpContext.SAX.loadObject(Account.class, url);
        assertNotNull(result);
//        System.out.println(result.getId());
//        System.out.println(result.getName());
//        System.out.println(result.getWorld());
//        result.getGuilds().forEach(System.out::println);
//        System.out.println(result.getCreated());
    }

    @Test
    public void testLoadObject_Account_Permission_Rank_Remote() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(Account Permisson Rank remote)"); // NOI18N.
        final String appKey = loadApplicationKey();
        String path = String.format("https://api.guildwars2.com/v2/account?access_token=%s", appKey);
        URL url = new URL(path);
        final Account account = JsonpContext.SAX.loadObject(Account.class, url);
        assertNotNull(account);
        final String guildId = account.getGuilds().iterator().next();
        path = "https://api.guildwars2.com/v2/guild/permissions";
        url = new URL(path);
        final Collection<GuildPermissionId> permissionIds = JsonpContext.SAX.loadEnumArray(GuildPermissionId.class, url);
        assertNotNull(permissionIds);
        path = "https://api.guildwars2.com/v2/guild/permissions?ids=all";
        url = new URL(path);
        final Collection<GuildPermission> permissions = JsonpContext.SAX.loadObjectArray(GuildPermission.class, url);
        assertNotNull(permissions);
        path = String.format("https://api.guildwars2.com/v2/guild/%s/ranks?access_token=%s", guildId, appKey);
        url = new URL(path);
        final Collection<GuildRank> ranks = JsonpContext.SAX.loadObjectArray(GuildRank.class, url);
        assertNotNull(ranks);
    }

    @Test
    public void testLoadObject_CurrencyAmount() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject(CurrencyAmount)"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/account/wallet/currency_amount1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.SAX;
        final AccountCurrencyAmount value = instance.loadObject(AccountCurrencyAmount.class, url);
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
        final JsonpContext instance = JsonpContext.SAX;
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
        final JsonpContext instance = JsonpContext.SAX;
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
        final PageResult<String> result = JsonpContext.SAX.loadPage(String.class, url);
        assertNotNull(result);
        result.stream().forEach(characterName -> {
        });
    }
}
