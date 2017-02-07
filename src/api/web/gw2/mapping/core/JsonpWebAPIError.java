/* 
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.mapping.core;

/**
 * JSON-P implementation of a Web API error.
 * @author Fabrice Bouyé
 */
public final class JsonpWebAPIError implements WebAPIError {

    private String text = "";

    /**
     * Creates a new empty instance.
     */
    public JsonpWebAPIError() {
    }

    @Override
    public String getText() {
        return text;
    }
}
