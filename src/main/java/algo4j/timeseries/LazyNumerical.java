package algo4j.timeseries;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Represents a numerical time series evaluating values only when asked.
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public abstract class LazyNumerical extends AbstractNumerical {

    private final SortedMap<Integer, DataPoint<BigDecimal>> cached;

    protected LazyNumerical() {
        this.cached = new TreeMap<>();
    }

    protected LazyNumerical(SortedMap<Integer, DataPoint<BigDecimal>> cached) {
        this.cached = new TreeMap<>(cached);
    }

    protected abstract Numerical createCopy(int index, SortedMap<Integer, DataPoint<BigDecimal>> cached);

    protected abstract DataPoint<BigDecimal> evaluateDataPoint(int index);

    @Override
    public Numerical at(int index) {
        TreeMap<Integer, DataPoint<BigDecimal>> newCache = new TreeMap<>();
        SortedMap<Integer, DataPoint<BigDecimal>> subCache = cached.tailMap(index);
        subCache.forEach((idx, dp) -> newCache.put(idx.intValue() -index, dp));
        return createCopy(index, newCache);
    }

    @Override
    public BigDecimal value(int index) {
        DataPoint<BigDecimal> dataPoint = cached.get(index);
        if (dataPoint != null)
            return dataPoint.value();

        DataPoint<BigDecimal> dp = evaluateDataPoint(index);
        cached.put(index, dp);
        return dp.value();
    }

    @Override
    public LocalDateTime datetime(int index) {
        DataPoint<BigDecimal> dataPoint = cached.get(index);
        if (dataPoint != null)
            return dataPoint.datetime();

        DataPoint<BigDecimal> dp = evaluateDataPoint(index);
        cached.put(index, dp);
        return dp.datetime();
    }

}
