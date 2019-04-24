/*
 * Copyright (C) 2015-2017 Fabrice Bouyé
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD license.  See the LICENSE file for details.
 */
package api.web.gw2.jsonp.v2.commerce.transactions;

import api.web.gw2.mapping.core.CoinAmount;
import api.web.gw2.mapping.core.CoinValue;
import api.web.gw2.mapping.core.DateValue;
import api.web.gw2.mapping.core.IdValue;
import api.web.gw2.mapping.core.OptionalValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.commerce.transactions.Transaction;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Default JSON-P implementation of a transaction.
 *
 * @author Fabrice Bouyé
 */
final class JsonpTransaction implements Transaction {

    @IdValue
    private int id = IdValue.DEFAULT_INTEGER_ID;
    @IdValue
    private int itemId = IdValue.DEFAULT_INTEGER_ID;
    @CoinValue
    private CoinAmount price = CoinAmount.ZERO;
    @QuantityValue
    private int quantity = QuantityValue.DEFAULT;
    @DateValue
    private ZonedDateTime created = DateValue.DEFAULT;
    @DateValue
    @OptionalValue
    private Optional<ZonedDateTime> purchased = Optional.empty();

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getItemId() {
        return itemId;
    }

    @Override
    public CoinAmount getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public ZonedDateTime getCreated() {
        return created;
    }

    @Override
    public Optional<ZonedDateTime> getPurchased() {
        return purchased;
    }
}
