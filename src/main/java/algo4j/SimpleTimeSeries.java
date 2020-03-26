package algo4j;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleTimeSeries<D, T> implements TimeSeries<D, T> {

    private final List<DataPoint<D, T>> list;

    public SimpleTimeSeries() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(D datum, T time) {
        list.add(new DataPoint<>(datum, time));
    }

    @Override
    public Iterator<D> iterator() {
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
