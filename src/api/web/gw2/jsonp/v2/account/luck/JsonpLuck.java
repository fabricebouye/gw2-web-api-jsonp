package api.web.gw2.jsonp.v2.account.luck;

import api.web.gw2.mapping.core.EnumValue;
import api.web.gw2.mapping.core.QuantityValue;
import api.web.gw2.mapping.v2.account.luck.Luck;
import api.web.gw2.mapping.v2.account.luck.LuckId;

/**
 * Default JSON-P implementation of a account luck.
 *
 * @author Fabrice Bouyé
 */
public final class JsonpLuck implements Luck {
    @EnumValue
    private LuckId id = LuckId.UNKNOWN;
    @QuantityValue
    private int value = QuantityValue.DEFAULT;

    /**
     * Creates a new empty instance.
     */
    public JsonpLuck() {
    }

    @Override
    public LuckId getId() {
        return id;
    }

    @Override
    public int getValue() {
        return value;
    }
}
