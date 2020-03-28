package algo4j.timeseries;

import java.time.LocalDateTime;

public class ExampleTimeSeries<V> implements TimeSeries<String, ExampleTimeSeries<V>> {
    @Override
    public ExampleTimeSeries<V> at(int index) {
        return null;
    }

    @Override
    public String value(int index) {
        return null;
    }

    @Override
    public LocalDateTime datetime(int index) {
        return null;
    }
}
