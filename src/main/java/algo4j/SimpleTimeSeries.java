package algo4j;

import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleTimeSeries implements TimeSeries {

    private final List<DataPoint<Bar, ZonedDateTime>> list;

    public SimpleTimeSeries() {
        this.list = new LinkedList<>();
    }

    private SimpleTimeSeries(List<DataPoint<Bar, ZonedDateTime>> list) {
        this.list = list;
    }

    @Override
    public void add(Bar bar, ZonedDateTime time) {
        list.add(new DataPoint<>(bar, time));
    }

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public TimeSeries till(ZonedDateTime time) {
        return null;
    }

    @Override
    public Iterator<Bar> iterator() {
        return list.stream()
            .map((it) -> it.datum)
            .iterator();
    }

    private static class DataPoint<D, T> {
        private final D datum;
        private final T time;

        public DataPoint(D datum, T time) {
            this.datum = datum;
            this.time = time;
        }
    }

}
