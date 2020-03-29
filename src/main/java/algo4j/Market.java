package algo4j;

import algo4j.timeseries.OHLC;

/**
 * Represents the market providing timeseries and other data.
 */
public interface Market {

    /**
     * Returns an OHLC time series for the specified ISIN.
     *
     * @param isin an isin
     * @return an OHLC time series
     */
    OHLC ohlc(ISIN isin);

}
