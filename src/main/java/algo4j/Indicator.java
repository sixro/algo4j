package algo4j;

import java.math.BigDecimal;

public interface Indicator {

    /**
     * Returns the value of this indicator at the specified data point index on the specified time series.
     *
     * <p>
     * 0 index is considered the most recent data point in time series.
     * </p>
     *
     * @param timeSeries a time series
     * @param index an index
     * @return value of this indicator
     */
    BigDecimal value(TimeSeries timeSeries, int index);

}
