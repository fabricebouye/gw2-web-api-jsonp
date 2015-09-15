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
import api.web.gw2.mapping.v2.colors.ColorDye;
import api.web.gw2.mapping.v2.quaggans.*;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import jdk.nashorn.internal.AssertsEnabled;
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
    public void testLoadObject_Quaggan() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/quaggans/quaggan1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final Quaggan value = instance.loadObject(Quaggan.class, url);
        assertNotNull(value);
        assertEquals(value.getId(), "box"); // NOI18N.
        assertEquals(value.getUrl(), "https://static.staticwars.com/quaggans/box.jpg"); // NOI18N.
    }

    @Test
    public void testLoadObject_Account() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/account/account1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final Account value = instance.loadObject(Account.class, url);
        assertNotNull(value);
        assertEquals(value.getId(), "b8169418-1c11-405f-91bb-e2b29d602b8a"); // NOI18N.
        assertEquals(value.getName(), "ExampleAccount.1234"); // NOI18N.
        assertEquals(value.getWorld(), 1007);
        assertEquals(value.getGuilds(), Collections.unmodifiableSet(new HashSet(Arrays.asList("75FD83CF-0C45-4834-BC4C-097F93A487AF")))); // NOI18N.
    }

    @Test
    public void testLoadObject_CurrencyAmount() throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println("loadObject"); // NOI18N.
        final URL url = getClass().getResource("/api/web/gw2/mapping/v2/account/wallet/currency_amount1.json"); // NOI18N.
        final JsonpContext instance = JsonpContext.INSTANCE;
        final CurrencyAmount value = instance.loadObject(CurrencyAmount.class, url);
        assertNotNull(value);
        assertEquals(value.getId(), 1);
        assertEquals(value.getValue(), 100001);
    }

    @Test
    public void testLoadPage() throws IOException {
        System.out.println("loadPage"); // NOI18N.
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
                        final PageResult page = instance.loadPage(aClass, new URL(path));
                        assertNotNull(page);
                    } catch (IOException ex) {
                        fail(ex.getMessage());
                    }
                });
    }
}
