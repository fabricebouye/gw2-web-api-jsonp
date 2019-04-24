/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.core;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit test.
 *
 * @author Fabrice Bouyé
 */
public class ServicesTest {

    public ServicesTest() {
    }

    private static Set<String> CLASS_LIST;

    @BeforeAll
    public static void setUpClass() throws IOException {
        final var hostDir = Paths.get("res/META-INF/services");
        assertTrue(Files.exists(hostDir));
        assertTrue(Files.isDirectory(hostDir));
        assertTrue(Files.isReadable(hostDir));
        CLASS_LIST = Files.list(hostDir)
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toUnmodifiableSet());
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

    /**
     * Tests that existing services can be resolved and properly loaded.
     */
    @Test
    public void testServiceResolutionAndLoad() {
        System.out.println("testServiceResolutionAndLoad"); // NOI18N.
        CLASS_LIST.stream()
                .forEach(className -> {
                    System.out.printf("\t%s%n", className);
                    try {
                        final var aClass = Class.forName(className);
                        final var serviceLoader = ServiceLoader.load(aClass);
                        final var iterator = serviceLoader.iterator();
                        Object result = null;
                        while (iterator.hasNext()) {
                            if (result == null) {
                                result = iterator.next();
                            }
                        }
                        assertNotNull(result);
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                        fail(ex);
                    }
                });
    }
}
