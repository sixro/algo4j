package algo4j;

/**
 * Represents a trading broker.
 */
public interface Broker {

    boolean inMarket();

    void enter();

    void exit();

}
