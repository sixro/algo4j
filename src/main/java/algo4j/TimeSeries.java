package algo4j;

import java.time.ZonedDateTime;

public interface TimeSeries<D, T> extends Iterable<D> {

    void add(D datum, T time);

}
