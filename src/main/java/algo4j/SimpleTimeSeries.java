package algo4j;

import java.time.ZonedDateTime;
import java.util.*;

public class SimpleTimeSeries implements TimeSeries {

    private final List<DataPoint> list;

    public SimpleTimeSeries() {
        this.list = new LinkedList<>();
    }

    private SimpleTimeSeries(List<DataPoint> list) {
        this.list = list;
    }

    @Override
    public void add(Bar bar, ZonedDateTime time) {
        list.add(new DataPoint(bar, time));
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
        ArrayList<DataPoint> clone = new ArrayList<>(list);
        Collections.reverse(clone);
        return clone
            .stream()
            .map((it) -> it.datum)
            .iterator();
    }

    @Override
    public String toString() {
        return "TS[" + list.toString() + "]";
    }

    private static class DataPoint {
        private final Bar datum;
        private final ZonedDateTime time;

        public DataPoint(Bar datum, ZonedDateTime time) {
            this.datum = datum;
            this.time = time;
        }

        @Override
        public String toString() {
            return "{" +
                    "datum=" + datum +
                    ", time=" + time +
                    '}';
        }
    }

}
