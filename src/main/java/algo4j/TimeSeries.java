package algo4j;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Represents a <a href="https://en.wikipedia.org/wiki/Time_series" >time series</a>.
 *
 * @param <T> the type of value on each data point
 *
 * @author <a href="mailto:me@sixro.net">sixro</a>
 * @since 1.0
 */
public class TimeSeries<T> extends Observable {

    private final String name;
    private final List<DataPoint<T>> dataPoints;

    public TimeSeries(String name) {
        this(name, Collections.emptyList());
    }

    public TimeSeries(String name, Collection<DataPoint<T>> dataPoints) {
        this.name = name;
        this.dataPoints = new LinkedList<>(dataPoints);
    }

    public void add(T value, ZonedDateTime time) {
        DataPoint<T> dataPoint = new DataPoint<>(value, time);

        dataPoints.add(dataPoint);

        setChanged();
        notifyObservers(new DataPointAddedEvent<>(this, System.currentTimeMillis(), dataPoint));
    }

    @Override
    public String toString() {
        return TimeSeries.class.getSimpleName() + "(" + name + "){" + dataPoints.size() + "dp}";
    }

    public static class DataPoint<T> {
        private final T value;
        private final ZonedDateTime time;

        public DataPoint(T value, ZonedDateTime time) {
            this.value = value;
            this.time = time;
        }

        @Override
        public String toString() {
            return value + "@" + time;
        }
    }

    public static abstract class Event extends EventObject {

        protected final long timestamp;

        protected Event(Object source, long timestamp) {
            super(source);
            this.timestamp = timestamp;
        }

        public long getTimestamp() {
            return timestamp;
        }

    }

    public static class DataPointAddedEvent<T> extends Event {
        private final DataPoint<T> dataPoint;

        public DataPointAddedEvent(Object source, long timestamp, DataPoint<T> dataPoint) {
            super(source, timestamp);
            this.dataPoint = dataPoint;
        }

        public DataPoint<T> getDataPoint() {
            return dataPoint;
        }

        @Override
        public String toString() {
            return "DataPointAddedEvent{" +
                    "source=" + source +
                    ",timestamp=" + timestamp +
                    ",dataPoint=" + dataPoint +
                    '}';
        }
    }
}
