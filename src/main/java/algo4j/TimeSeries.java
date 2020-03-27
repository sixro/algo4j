package algo4j;

import java.time.ZonedDateTime;

public interface TimeSeries extends Iterable<Bar> {

    void add(Bar bar, ZonedDateTime time);

    int length();

    TimeSeries sub(int index);

}
