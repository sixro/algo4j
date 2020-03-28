package algo4j.timeseries;

import java.time.LocalDateTime;

/**
 * Represents a time series.
 *
 * @param <T> type of values
 * @param <E> type of extending time series
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public interface TimeSeries<T, E extends TimeSeries<T, E>> {

    E at(int index);

    T value(int index);

    LocalDateTime datetime(int index);

    int length();

}
