package algo4j.indicator;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.LazyNumericalTimeSeries;
import algo4j.timeseries.NumericalTimeSeries;

import java.math.BigDecimal;
import java.util.SortedMap;

/**
 * Represents a simple moving average time series.
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public class SMA extends LazyNumericalTimeSeries implements Indicator {

    private final int periods;
    private final NumericalTimeSeries delegate;

    private SMA(int periods, NumericalTimeSeries delegate) {
        this.periods = periods;
        this.delegate = delegate;
    }

    private SMA(SortedMap<Integer, DataPoint<BigDecimal>> cached, int periods, NumericalTimeSeries delegate) {
        super(cached);
        this.periods = periods;
        this.delegate = delegate;
    }

    public static SMA of(int periods, NumericalTimeSeries timeSeries) {
        return new SMA(periods, timeSeries);
    }

    protected NumericalTimeSeries createCopy(int index, SortedMap<Integer, DataPoint<BigDecimal>> cached) {
        NumericalTimeSeries at = delegate.at(index);
        return new SMA(cached, periods, delegate.at(index));
    }

    protected DataPoint<BigDecimal> evaluateDataPoint(int index) {
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = index; i < index + periods; i++) {
            sum = sum.add(delegate.value(i));
        }
        BigDecimal value = sum.divide(BigDecimal.valueOf(periods));

        return DataPoint.of(value, delegate.datetime(index));
    }

    @Override
    public int length() {
        return delegate.length() -periods +1;
    }

}
