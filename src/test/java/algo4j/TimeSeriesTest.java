package algo4j;

import algo4j.TimeSeries.DataPointAddedEvent;
import algo4j.TimeSeries.Event;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.junit.Assert;
import org.junit.Test;

public class TimeSeriesTest implements Observer {

    private final List<TimeSeries.Event> events = new LinkedList<>();

    @Test public void add() {
        TimeSeries s = new TimeSeries<Integer>("ints");
        s.addObserver(this);

        s.add(1, ZonedDateTime.parse("2019-01-01T00:00:00.000Z"));

        Assert.assertEquals(1, events.size());
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o + ": " + arg);
        events.add((Event) arg);
    }
}