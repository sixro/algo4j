package algo4j.timeseries;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static java.math.BigDecimal.*;
import static org.junit.Assert.*;

public class ListNumericalTimeSeriesTest {

    @Test public void value() {
        DataPoint<BigDecimal> _1 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> _2 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> _3 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-18T00:00:00"));
        ListNumerical timeSeries = new ListNumerical(Arrays.asList(_1, _2, _3));
        assertEquals(ONE, timeSeries.value(1));
    }

    @Test public void time() {
        DataPoint<BigDecimal> _1 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> _2 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> _3 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-18T00:00:00"));
        ListNumerical timeSeries = new ListNumerical(Arrays.asList(_1, _2, _3));
        assertEquals(LocalDateTime.parse("2020-03-19T00:00:00"), timeSeries.datetime(1));
    }

    @Test public void at() {
        DataPoint<BigDecimal> _1 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> _2 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> _3 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-18T00:00:00"));
        ListNumerical timeSeries = new ListNumerical(Arrays.asList(_1, _2, _3));
        Numerical timeSeries_2 = timeSeries.at(2);

        assertEquals(TEN, timeSeries_2.value(0));
        assertEquals(LocalDateTime.parse("2020-03-18T00:00:00"), timeSeries_2.datetime(0));
    }

    @Test public void lower() {
        DataPoint<BigDecimal> a1 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> a2 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> a3 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-18T00:00:00"));

        DataPoint<BigDecimal> b1 = DataPoint.of(BigDecimal.valueOf(2), LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> b2 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> b3 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-18T00:00:00"));

        ListNumerical ts1 = new ListNumerical(Arrays.asList(a1, a2, a3));
        ListNumerical ts2 = new ListNumerical(Arrays.asList(b1, b2, b3));

        assertTrue(ts1.lower(ts2));
        assertFalse(ts1.at(1).lower(ts2.at(1)));
    }

    @Test public void higher() {
        DataPoint<BigDecimal> a1 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> a2 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> a3 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-18T00:00:00"));

        DataPoint<BigDecimal> b1 = DataPoint.of(BigDecimal.valueOf(2), LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> b2 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> b3 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-18T00:00:00"));

        ListNumerical ts1 = new ListNumerical(Arrays.asList(a1, a2, a3));
        ListNumerical ts2 = new ListNumerical(Arrays.asList(b1, b2, b3));

        assertFalse(ts1.higher(ts2));
        assertTrue(ts1.at(1).higher(ts2.at(1)));
    }

    @Test public void crossesOver() {
        DataPoint<BigDecimal> a1 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> a2 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-19T00:00:00"));

        DataPoint<BigDecimal> b1 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> b2 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-19T00:00:00"));

        ListNumerical ts1 = new ListNumerical(Arrays.asList(a1, a2));
        ListNumerical ts2 = new ListNumerical(Arrays.asList(b1, b2));

        assertTrue(ts1.crossesOver(ts2));
    }

    @Test public void crossesUnder() {
        DataPoint<BigDecimal> a1 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> a2 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-19T00:00:00"));

        DataPoint<BigDecimal> b1 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> b2 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-19T00:00:00"));

        ListNumerical ts1 = new ListNumerical(Arrays.asList(a1, a2));
        ListNumerical ts2 = new ListNumerical(Arrays.asList(b1, b2));

        assertTrue(ts2.crossesUnder(ts1));
    }

}