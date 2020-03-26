package algo4j;

import java.time.ZonedDateTime;

/**
 * Represents a trading strategy.
 */
public interface Strategy {

    /**
     * Execute the strategy on the specified time series using specified broker.
     *
     * <p>
     * It will execute mainly on the last data provided in the time series.<br>
     * Subsequent calls will be made on every new data added to the time series.
     * </p>
     *
     * @param timeSeries a time series
     * @param broker a broker
     */
    void run(TimeSeries timeSeries, Broker broker);

}
