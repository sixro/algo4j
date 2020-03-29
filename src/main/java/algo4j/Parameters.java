package algo4j;

/**
 * Represents a set of parameters to be used in a strategy.
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public interface Parameters {

    <T> T get(String name, Class<T> expectedType);

}
