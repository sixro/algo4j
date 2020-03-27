package algo4j;

/**
 * Represents a set of parameters used to run a strategy.
 *
 * <p>
 * Each parameter can be a value or a value range.<br>
 * This is the reason it is an {@link Iterable} or itself: allow to iterate on all combinations.
 * </p>
 *
 * <p>
 * Implementations must consider name as not case sensitive.
 * </p>
 */
public interface Parameters extends Iterable<Parameters> {

    <T extends Comparable<T>> T value(String name, Class<T> type);

    int combinations();

}
