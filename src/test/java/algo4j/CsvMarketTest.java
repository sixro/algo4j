package algo4j;

import org.junit.Test;

import static org.junit.Assert.*;

public class CsvMarketTest {

    @Test public void load() {
        CsvMarket market = CsvMarket.fromClasspath("/csv-market");
        TimeSeries ts = market.timeSeries("IE00BKM4GZ66", TimeFrame.DAILY);
        assertTrue(ts.length() >= 1);
        System.out.println(ts);
    }

}