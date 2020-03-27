package algo4j;

// TODO I don't need single Parameter
/**
 * Represents a parameter used in a strategy.
 *
 * @param <T> type of parameter
 */
public interface Parameter<T extends Comparable<T>> {

    T value();

}
