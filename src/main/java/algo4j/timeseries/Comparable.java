package algo4j.timeseries;

/**
 * Represents a time series made up of comparable values.
 *
 * @param <T> the type of each value
 * @param <E> the implementing class
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public interface Comparable<T extends java.lang.Comparable<T>, E extends Comparable<T, E>> extends TimeSeries<T, E> {

    boolean crossesOver(E series);
    boolean crossesUnder(E series);

    E highest(int periods);
    E lowest(int periods);

    boolean higher(E series);
    boolean lower(E series);

}
