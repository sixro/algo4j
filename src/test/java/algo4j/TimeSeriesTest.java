package algo4j;

import java.time.ZonedDateTime;
import java.util.Observable;
import java.util.Observer;
import org.junit.Test;

public class TimeSeriesTest implements Observer {

    @Test public void add() {
        TimeSeries s = new TimeSeries<Integer>("ints");
        s.addObserver(this);

        s.add(1, ZonedDateTime.parse("2019-01-01T00:00:00.000Z"));
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o + ": " + arg);
    }
}