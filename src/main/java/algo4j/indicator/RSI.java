package algo4j.indicator;

import algo4j.Indicator;
import algo4j.TimeSeries;

import java.math.BigDecimal;

public class RSI implements Indicator {

    private final int periods;

    public RSI(int periods) {
        this.periods = periods;
    }

    @Override
    public BigDecimal value(TimeSeries timeSeries, int index) {
        return null;
    }
}
