package algo4j;

import java.math.BigDecimal;

public class Close extends MappingTimeSeries<OHLC, BigDecimal> {
    public Close(TimeSeries<OHLC> input) {
        super(input, ohlc -> ohlc.close() );
    }
}
