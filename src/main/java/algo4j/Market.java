package algo4j;

/**
 * Represents the market able to provied a time series for a specific instrument.
 */
public interface Market {

    // TODO use the new version of themissingobjects containing the vo ISIN
    TimeSeries timeSeries(String isin, TimeFrame timeFrame);

}
