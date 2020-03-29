package algo4j.indicator;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.ListNumericalTimeSeries;
import algo4j.timeseries.NumericalTimeSeries;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static java.math.BigDecimal.*;

public class SMATest {

    @Test public void value() {
        DataPoint<BigDecimal> a1 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> a2 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> a3 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-18T00:00:00"));

        ListNumericalTimeSeries ts = new ListNumericalTimeSeries(Arrays.asList(a1, a2, a3));
        SMA sma2 = SMA.of(2, ts);

        Assert.assertEquals(5, sma2.value(0).intValue());
        Assert.assertEquals(a1.datetime(), sma2.datetime(0));
        Assert.assertEquals(0.5d, sma2.value(1).doubleValue(), 0.01);
    }

    @Test public void at() {
        DataPoint<BigDecimal> a1 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> a2 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> a3 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-18T00:00:00"));

        ListNumericalTimeSeries ts = new ListNumericalTimeSeries(Arrays.asList(a1, a2, a3));
        SMA sma2 = SMA.of(2, ts);

        SMA sma2_1 = (SMA) sma2.at(1);
        Assert.assertEquals(0.5d, sma2_1.value(0).doubleValue(), 0.01);
        Assert.assertEquals(a2.datetime(), sma2_1.datetime(0));
    }

    @Test public void at_with_cached() {
        DataPoint<BigDecimal> a1 = DataPoint.of(TEN, LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> a2 = DataPoint.of(ZERO, LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> a3 = DataPoint.of(ONE, LocalDateTime.parse("2020-03-18T00:00:00"));

        ListNumericalTimeSeries ts = new ListNumericalTimeSeries(Arrays.asList(a1, a2, a3));
        SMA sma2 = SMA.of(2, ts);
        Assert.assertEquals(0.5d, sma2.value(1).doubleValue(), 0.01);

        SMA sma2_1 = (SMA) sma2.at(1);
        Assert.assertEquals(0.5d, sma2_1.value(0).doubleValue(), 0.01);
    }

}