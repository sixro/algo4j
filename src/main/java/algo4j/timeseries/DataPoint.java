package algo4j.timeseries;

import java.time.LocalDateTime;

/**
 * Represents a data point in a time series.
 *
 * <p>
 * Used mainly internally by implementations of {@link TimeSeries}.<br>
 * </p>
 *
 * @param <T> type of value
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public class DataPoint<T> {

    private final T value;
    private final LocalDateTime datetime;

    private DataPoint(T value, LocalDateTime datetime) {
        this.value = value;
        this.datetime = datetime;
    }

    public static <T> DataPoint<T> of(T value, LocalDateTime datetime) {
        return new DataPoint<>(value, datetime);
    }

    public T value() {
        return value;
    }

    public LocalDateTime datetime() {
        return datetime;
    }

    @Override
    public String toString() {
        return "{" + value + ", datetime=" + datetime + '}';
    }
}
