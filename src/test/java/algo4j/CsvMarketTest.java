package algo4j;

import algo4j.timeseries.OHLC;
import org.junit.Test;

import static org.junit.Assert.*;

public class CsvMarketTest {

    @Test
    public void load() {
        Market market = CsvMarket.fromClasspath("/csv-market");
        OHLC ts = market.ohlc(ISIN.of("IE00BKM4GZ66"));
        assertTrue(ts.length() >= 1);
        System.out.println(ts);
    }

}