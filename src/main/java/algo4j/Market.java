package algo4j;

import algo4j.timeseries.NumericalTimeSeries;
import algo4j.timeseries.OHLC;

public interface Market {

    OHLC ohlc(ISIN isin);

    NumericalTimeSeries close(ISIN isin);

}
