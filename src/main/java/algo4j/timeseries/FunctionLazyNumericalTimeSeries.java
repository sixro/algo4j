package algo4j.timeseries;

import java.math.BigDecimal;
import java.util.SortedMap;
import java.util.function.Function;

public class FunctionLazyNumericalTimeSeries<I, E extends TimeSeries<I, E>> extends LazyNumericalTimeSeries {

    private final TimeSeries<I, E> origin;
    private final Function<I, BigDecimal> function;

    public FunctionLazyNumericalTimeSeries(TimeSeries<I, E> origin, Function<I, BigDecimal> function) {
        this.origin = origin;
        this.function = function;
    }

    public FunctionLazyNumericalTimeSeries(SortedMap<Integer, DataPoint<BigDecimal>> cached, TimeSeries<I, E> origin, Function<I, BigDecimal> function) {
        super(cached);
        this.origin = origin;
        this.function = function;
    }

    @Override
    protected NumericalTimeSeries createCopy(int index, SortedMap<Integer, DataPoint<BigDecimal>> cached) {
        return new FunctionLazyNumericalTimeSeries<>(cached, origin.at(index), function);
    }

    @Override
    protected DataPoint<BigDecimal> evaluateDataPoint(int index) {
        return DataPoint.of(function.apply(origin.value(index)), origin.datetime(index));
    }

    @Override
    public int length() {
        return origin.length();
    }
}
