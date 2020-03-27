package algo4j;

import java.util.Iterator;
import java.util.List;

public class OHLCTimeSeries implements TimeSeries<OHLC> {

    private final List<OHLC> list;

    public OHLCTimeSeries(List<OHLC> OHLCS) {
        this.list = OHLCS;
    }

    @Override
    public OHLC at(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<OHLC> iterator() {
        return list.iterator();
    }

}
