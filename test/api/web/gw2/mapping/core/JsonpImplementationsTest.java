/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import api.web.gw2.mapping.v1.eventnames.EventName;
import api.web.gw2.mapping.v1.eventnames.JsonpEventName;
import api.web.gw2.mapping.v1.guilddetails.GuildDetails;
import api.web.gw2.mapping.v1.guilddetails.GuildDetailsEmblem;
import api.web.gw2.mapping.v1.guilddetails.JsonpGuildDetails;
import api.web.gw2.mapping.v1.guilddetails.JsonpGuildDetailsEmblem;
import api.web.gw2.mapping.v2.account.Account;
import api.web.gw2.mapping.v2.account.JsonpAccount;
import api.web.gw2.mapping.v2.account.wallet.CurrencyAmount;
import api.web.gw2.mapping.v2.account.wallet.JsonpCurrentyAmount;
import api.web.gw2.mapping.v2.colors.ColorDye;
import api.web.gw2.mapping.v2.colors.ColorMaterial;
import api.web.gw2.mapping.v2.colors.ColorRGB;
import api.web.gw2.mapping.v2.colors.JsonpColorDye;
import api.web.gw2.mapping.v2.colors.JsonpColorMaterial;
import api.web.gw2.mapping.v2.colors.JsonpColorRGB;
import api.web.gw2.mapping.v2.quaggans.JsonpQuaggan;
import api.web.gw2.mapping.v2.quaggans.Quaggan;
import java.util.Iterator;
import java.util.ServiceLoader;
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
public class JsonpImplementationsTest {

    public JsonpImplementationsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private final Class[] interfaces = {
        EventName.class,
        GuildDetails.class,
        GuildDetailsEmblem.class,
        Account.class,
        CurrencyAmount.class,
        ColorDye.class,
        ColorMaterial.class,
        ColorRGB.class,
        Quaggan.class
    };

    private final Class[] implementations = {
        JsonpEventName.class,
        JsonpGuildDetails.class,
        JsonpGuildDetailsEmblem.class,
        JsonpAccount.class,
        JsonpCurrentyAmount.class,
        JsonpColorDye.class,
        JsonpColorMaterial.class,
        JsonpColorRGB.class,
        JsonpQuaggan.class
    };

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testJsonpImplementations() {
        System.out.println("JsonpImplementations");
        assertEquals(interfaces.length, implementations.length);
        IntStream.range(0, interfaces.length)
                .forEach(index -> {
                    try {
                        final Class sourceInterface = interfaces[index];
                        System.out.print(sourceInterface.getName());
                        final Object instance = newEmptyInstance(sourceInterface);
                        assertNotNull(instance);
                        final Class expResult = implementations[index];
                        final Class result = instance.getClass();
                        assertNotNull(result);
                        assertEquals(expResult, result);
                        System.out.print(" -> " + expResult.getName());
                    } catch (Exception ex) {
                        fail(ex.getMessage());
                    } finally {
                        System.out.println();
                    }
                });
    }

    private Object newEmptyInstance(Class targetClass) throws Exception {
        // Get service loader for target class.
        final ServiceLoader serviceLoader = ServiceLoader.load(targetClass);
        // Get concrete instance for target class.
        final Iterator iterator = serviceLoader.iterator();
        Object result = null;
        while (iterator.hasNext()) {
            if (result == null) {
                result = iterator.next();
            }
        }
        return result;
    }
}
