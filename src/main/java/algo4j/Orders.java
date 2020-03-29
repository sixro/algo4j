package algo4j;

public interface Orders {

    /**
     * Returns the number of orders in this set.
     *
     * @return number of orders in this set
     */
    int count();

    /**
     * Close all open orders found in this set.
     *
     * <p>
     * Does nothing if the orders inside this set are not closeable.
     * </p>
     */
    void close();
}
