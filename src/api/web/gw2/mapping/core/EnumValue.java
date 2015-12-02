/* 
 * Copyright (C) 2015 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The JSON value defines an {@code Enum}.
 * @author Fabrice Bouyé
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface EnumValue {

    /**
     * Separates the method name from the class name, value is {@value}.
     */
    public static final String METHOD_SEPARATOR = "::"; // NOI18N.

    /**
     * The factory for this enum.
     * <br>If no factory is defined, the static method {@code valueOf()} of the enum class will be called.
     * @return A {@code String}, never {@code null}.
     */
    String factory() default "";
}
