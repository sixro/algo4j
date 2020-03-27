package algo4j.indicator;

import algo4j.SimpleBar;
import algo4j.SimpleTimeSeries;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static java.math.BigDecimal.*;
import static org.junit.Assert.*;

public class SMATest {

    @Test public void calculate_expected_value() {
        SimpleTimeSeries ts = new SimpleTimeSeries();
        ts.add(new SimpleBar(TEN, TEN, TEN, ONE), ZonedDateTime.now());
        ts.add(new SimpleBar(TEN, TEN, TEN, ONE), ZonedDateTime.now());

        SMA sma = new SMA(2);
        assertEquals(ONE, sma.value(ts, 0));
    }

    @Test public void calculate_in_the_right_order() {
        SimpleTimeSeries ts = new SimpleTimeSeries();
        ts.add(new SimpleBar(TEN, TEN, TEN, ONE), ZonedDateTime.now());
        ts.add(new SimpleBar(TEN, TEN, TEN, ONE), ZonedDateTime.now());
        ts.add(new SimpleBar(TEN, TEN, TEN, TEN), ZonedDateTime.now());

        SMA sma = new SMA(2);
        assertEquals(new BigDecimal("5.5"), sma.value(ts, 0));
    }

    @Test public void calculate_at_specified_index() {
        SimpleTimeSeries ts = new SimpleTimeSeries();
        ts.add(new SimpleBar(TEN, TEN, TEN, ONE), ZonedDateTime.now());
        ts.add(new SimpleBar(TEN, TEN, TEN, ONE), ZonedDateTime.now());
        ts.add(new SimpleBar(TEN, TEN, TEN, TEN), ZonedDateTime.now());

        SMA sma = new SMA(2);
        assertEquals(ONE, sma.value(ts, 1));
    }

    @Test public void calculate_on_median_price() {
        SimpleTimeSeries ts = new SimpleTimeSeries();
        ts.add(new SimpleBar(TEN, ZERO, ZERO, ONE), ZonedDateTime.now());
        ts.add(new SimpleBar(TEN, ONE, BigDecimal.valueOf(4), ONE), ZonedDateTime.now());
        ts.add(new SimpleBar(TEN, TEN, BigDecimal.valueOf(20), TEN), ZonedDateTime.now());

        final BigDecimal _2 = BigDecimal.valueOf(2);
        SMA sma = new SMA(2, bar -> (bar.high().add(bar.low()).divide(_2)));
        assertEquals(new BigDecimal("8.75"), sma.value(ts, 0));
    }

}
