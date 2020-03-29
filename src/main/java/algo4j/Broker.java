package algo4j;

/**
 * Represents a trading broker allowing trading operations.
 *
 * <p>
 * Implementations can operate for real on trading accounts.<br>
 * On the other end, a specific implementation is used during testing of strategies to evaluate them.
 * </p>
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public interface Broker {

    void enterOrder(Order newOrder);

    Orders openOrders(ISIN isin);
}
