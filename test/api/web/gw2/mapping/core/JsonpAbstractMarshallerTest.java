/* 
 * Copyright (C) 2015-2016 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.IntStream;
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
public class JsonpAbstractMarshallerTest {
    
    public JsonpAbstractMarshallerTest() {
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
        final Class aClass = JsonpAbstractMarshaller.class;
        final Method method = aClass.getDeclaredMethod("jsonKeyToJavaFieldName", String.class); // NOI18N.
        method.setAccessible(true);
        IntStream.range(0, values.length)
                .forEach(index -> {
                    try {
                        final String value = values[index];
                        final String expResult = expResults[index];
                        final String result = (String) method.invoke(null, value);
                        assertEquals(expResult, result);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        fail(ex.getMessage());
                    }
                });
    }    
}
