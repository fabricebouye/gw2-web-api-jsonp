/*
 * Copyright (C) 2015-2019 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Unfortunately some parts of the API are a bit weird in the way objects are returned (ie: v2/traits or v2/items).
 * <br>In those rare cases, the real type of the object is determined by the response content instead of the object structure.
 * <br>This annotation attempts to provide a way to circumvent this issues.
 *
 * @author Fabrice Bouyé
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface RuntimeType {

    /**
     * @author Fabrice Bouyé
     */
    enum Source {
        PARENT, SELF
    }

    String selector() default ""; // NOI18N.

    String pattern() default ""; // NOI18N.

    Source source() default Source.SELF;
}
