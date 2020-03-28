package algo4j.indicator;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.ListNumericalTimeSeries;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Arrays;

import static algo4j.testing.BigDecimalAsserts.assertBigDecimalEquals;

public class EMATest {

    /*
     * Data provided by https://www.dummies.com/personal-finance/investing/stocks-trading/how-to-calculate-exponential-moving-average-in-trading/
     */
    @Test public void calc() {
        DataPoint<BigDecimal> a01 = DataPoint.of(new BigDecimal("23.49"), LocalDateTime.parse("2020-03-21T00:00:00"));
        DataPoint<BigDecimal> a02 = DataPoint.of(new BigDecimal("23.41"), LocalDateTime.parse("2020-03-20T00:00:00"));
        DataPoint<BigDecimal> a03 = DataPoint.of(new BigDecimal("23.29"), LocalDateTime.parse("2020-03-19T00:00:00"));
        DataPoint<BigDecimal> a04 = DataPoint.of(new BigDecimal("23.02"), LocalDateTime.parse("2020-03-18T00:00:00"));
        DataPoint<BigDecimal> a05 = DataPoint.of(new BigDecimal("23.05"), LocalDateTime.parse("2020-03-17T00:00:00"));
        DataPoint<BigDecimal> a06 = DataPoint.of(new BigDecimal("22.83"), LocalDateTime.parse("2020-03-16T00:00:00"));
        DataPoint<BigDecimal> a07 = DataPoint.of(new BigDecimal("23.23"), LocalDateTime.parse("2020-03-15T00:00:00"));
        DataPoint<BigDecimal> a08 = DataPoint.of(new BigDecimal("22.91"), LocalDateTime.parse("2020-03-14T00:00:00"));
        DataPoint<BigDecimal> a09 = DataPoint.of(new BigDecimal("23.09"), LocalDateTime.parse("2020-03-13T00:00:00"));
        DataPoint<BigDecimal> a10 = DataPoint.of(new BigDecimal("22.81"), LocalDateTime.parse("2020-03-12T00:00:00"));

        ListNumericalTimeSeries ts = new ListNumericalTimeSeries(Arrays.asList(a01, a02, a03, a04, a05, a06, a07, a08, a09, a10));
        EMA ema9 = EMA.of(9, ts);

        assertBigDecimalEquals(new BigDecimal("23.18"), ema9.value(0), 2, RoundingMode.HALF_UP);
        assertBigDecimalEquals(new BigDecimal("23.10"), ema9.value(1), 2, RoundingMode.HALF_UP);
    }

}