package algo4j.timeseries;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class LazyNumericalTimeSeries extends AbstractNumericalTimeSeries {

    private final SortedMap<Integer, DataPoint<BigDecimal>> cached;

    protected LazyNumericalTimeSeries() {
        this.cached = new TreeMap<>();
    }

    protected LazyNumericalTimeSeries(SortedMap<Integer, DataPoint<BigDecimal>> cached) {
        this.cached = new TreeMap<>(cached);
    }

    protected abstract NumericalTimeSeries createCopy(int index, SortedMap<Integer, DataPoint<BigDecimal>> cached);

    protected abstract DataPoint<BigDecimal> evaluateDataPoint(int index);

    @Override
    public NumericalTimeSeries at(int index) {
        System.out.println("at " + index);
        SortedMap<Integer, DataPoint<BigDecimal>> c = (cached.isEmpty())
            ? Collections.emptySortedMap()
            : this.cached.subMap(index, this.cached.lastKey());
        return createCopy(index, c);
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
