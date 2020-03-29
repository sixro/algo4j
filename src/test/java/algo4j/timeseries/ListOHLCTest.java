package algo4j.timeseries;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static java.math.BigDecimal.*;

public class ListOHLCTest {

    @Test public void close_value() {
        DataPoint<ListOHLC.SimpleOHLCValue> _1 = DataPoint.of(ListOHLC.SimpleOHLCValue.of(ZERO, ZERO, ZERO, ONE), LocalDateTime.parse("2020-03-28T00:00:00"));
        DataPoint<ListOHLC.SimpleOHLCValue> _2 = DataPoint.of(ListOHLC.SimpleOHLCValue.of(ZERO, ZERO, ZERO, TEN), LocalDateTime.parse("2020-03-27T00:00:00"));
        ListOHLC ohlc = new ListOHLC(Arrays.asList(_1, _2));
        NumericalTimeSeries close = ohlc.close();
        Assert.assertEquals(ONE, close.value(0));
        Assert.assertEquals(TEN, close.value(1));
    }

    @Test public void close_at() {
        DataPoint<ListOHLC.SimpleOHLCValue> _1 = DataPoint.of(ListOHLC.SimpleOHLCValue.of(ZERO, ZERO, ZERO, ONE), LocalDateTime.parse("2020-03-28T00:00:00"));
        DataPoint<ListOHLC.SimpleOHLCValue> _2 = DataPoint.of(ListOHLC.SimpleOHLCValue.of(ZERO, ZERO, ZERO, TEN), LocalDateTime.parse("2020-03-27T00:00:00"));
        ListOHLC ohlc = new ListOHLC(Arrays.asList(_1, _2));
        NumericalTimeSeries close = ohlc.close();
        Assert.assertEquals(TEN, close.at(1).value(0));
    }

}