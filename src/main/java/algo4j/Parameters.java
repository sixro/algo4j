package algo4j;

/**
 * Represents a set of parameters.
 */
public interface Parameters {

    <T extends Comparable<T>> T value(String name, Class<T> type);

}
