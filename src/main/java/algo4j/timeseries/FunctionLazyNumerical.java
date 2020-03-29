package algo4j.timeseries;

import java.math.BigDecimal;
import java.util.SortedMap;
import java.util.function.Function;

/**
 * Represents a lazy numerical time series evaluating values at a specific index using the specified function.
 *
 * @param <I> type of input value
 * @param <E> time series extending this
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public class FunctionLazyNumerical<I, E extends TimeSeries<I, E>> extends LazyNumerical {

    private final TimeSeries<I, E> origin;
    private final Function<I, BigDecimal> function;

    public FunctionLazyNumerical(TimeSeries<I, E> origin, Function<I, BigDecimal> function) {
        this.origin = origin;
        this.function = function;
    }

    public FunctionLazyNumerical(SortedMap<Integer, DataPoint<BigDecimal>> cached, TimeSeries<I, E> origin, Function<I, BigDecimal> function) {
        super(cached);
        this.origin = origin;
        this.function = function;
    }

    @Override
    protected Numerical createCopy(int index, SortedMap<Integer, DataPoint<BigDecimal>> cached) {
        return new FunctionLazyNumerical<>(cached, origin.at(index), function);
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
