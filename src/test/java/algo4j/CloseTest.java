package algo4j;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;

import static java.math.BigDecimal.*;
import static org.junit.Assert.assertEquals;

public class CloseTest {

    @Test public void value() {
        SimpleOHLC ohlc1 = new SimpleOHLC(ONE, valueOf(4), ZERO, valueOf(2), ZERO);
        SimpleOHLC ohlc2 = new SimpleOHLC(valueOf(2), valueOf(8), ZERO, valueOf(4), ZERO);
        OHLCTimeSeries ohlc = new OHLCTimeSeries(Arrays.asList(ohlc2, ohlc1));
        Close c = new Close(ohlc);
        assertEquals(valueOf(4), c.at(0));
        assertEquals(valueOf(2), c.at(1));
    }

    @Test public void iterate() {
        SimpleOHLC ohlc1 = new SimpleOHLC(ONE, valueOf(4), ZERO, valueOf(2), ZERO);
        SimpleOHLC ohlc2 = new SimpleOHLC(valueOf(2), valueOf(8), ZERO, valueOf(4), ZERO);
        OHLCTimeSeries ohlc = new OHLCTimeSeries(Arrays.asList(ohlc2, ohlc1));
        Close c = new Close(ohlc);
        Iterator<BigDecimal> it = c.iterator();
        assertEquals(valueOf(4), it.next());
        assertEquals(valueOf(2), it.next());
    }

}