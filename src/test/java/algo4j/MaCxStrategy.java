package algo4j;

import algo4j.indicator.SMA;
import algo4j.timeseries.NumericalTimeSeries;
import algo4j.timeseries.OHLC;

import java.math.BigDecimal;

public class MaCxStrategy implements Strategy {

    private final ISIN isin;

    public MaCxStrategy(ISIN isin) {
        this.isin = isin;
    }

    @Override
    public void run(Market market) {
        OHLC ohlc = market.ohlc(isin);
        NumericalTimeSeries close = ohlc.close();
        SMA fastMA = SMA.of(5, close);
        SMA slowMA = SMA.of(20, close);
        if (fastMA.crossesOver(slowMA)) {
            //market.enterOrder();
        }

    }
}
