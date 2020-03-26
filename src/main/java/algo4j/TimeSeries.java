package algo4j;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

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
        notifyObservers(new DataPointAddedEvent<>(this, dataPoint));
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

    public static class DataPointAddedEvent<T> extends EventObject {
        private final DataPoint<T> dataPoint;

        public DataPointAddedEvent(Object source, DataPoint<T> dataPoint) {
            super(source);
            this.dataPoint = dataPoint;
        }

        public DataPoint<T> getDataPoint() {
            return dataPoint;
        }

        @Override
        public String toString() {
            return "DataPointAddedEvent{" +
                    "dataPoint=" + dataPoint +
                    '}';
        }
    }
}
