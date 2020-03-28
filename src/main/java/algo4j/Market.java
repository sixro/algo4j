package algo4j;

import algo4j.timeseries.NumericalTimeSeries;
import algo4j.timeseries.OHLC;

/**
 * Represents the market providing timeseries and other data.
 */
public interface Market {

    OHLC ohlc(ISIN isin);

    NumericalTimeSeries close(ISIN isin);

}
