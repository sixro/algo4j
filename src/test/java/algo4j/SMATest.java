package algo4j;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;

import static java.math.BigDecimal.*;
import static java.math.BigDecimal.valueOf;
import static org.junit.Assert.*;

public class SMATest {

    @Test public void iterate() {
        SimpleOHLC ohlc1 = new SimpleOHLC(ONE, valueOf(4), ZERO, valueOf(2), ZERO);
        SimpleOHLC ohlc2 = new SimpleOHLC(valueOf(2), valueOf(8), ZERO, valueOf(4), ZERO);
        OHLCTimeSeries ohlc = new OHLCTimeSeries(Arrays.asList(ohlc2, ohlc1));
        Close c = new Close(ohlc);
        SMA sma2 = new SMA(c, 2);

        Iterator<BigDecimal> it = sma2.iterator();
        assertEquals(valueOf(3), it.next());
    }

    @Test public void at() {
        SimpleOHLC ohlc1 = new SimpleOHLC(ONE, valueOf(4), ZERO, valueOf(2), ZERO);
        SimpleOHLC ohlc2 = new SimpleOHLC(valueOf(2), valueOf(8), ZERO, valueOf(4), ZERO);
        SimpleOHLC ohlc3 = new SimpleOHLC(valueOf(4), valueOf(7), valueOf(3), valueOf(5), ZERO);
        OHLCTimeSeries ohlc = new OHLCTimeSeries(Arrays.asList(ohlc3, ohlc2, ohlc1));
        Close c = new Close(ohlc);
        SMA sma2 = new SMA(c, 2);

        assertEquals(valueOf(4.5d), sma2.at(0));
        assertEquals(valueOf(3), sma2.at(1));
    }

}
