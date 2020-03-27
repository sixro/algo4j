package algo4j.indicator;

import algo4j.Bar;
import algo4j.Indicator;
import algo4j.TimeSeries;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.stream.StreamSupport;

public class SMA implements Indicator {

    private final int periods;
    private final Function<Bar, BigDecimal> function;

    public SMA(int periods) {
        this(periods, bar -> bar.close());
    }

    public SMA(int periods, Function<Bar, BigDecimal> function) {
        this.periods = periods;
        this.function = function;
    }

    @Override
    public BigDecimal value(TimeSeries timeSeries, int index) {
        BigDecimal sum = StreamSupport.stream(timeSeries.spliterator(), false)
                .skip(index)
                .map(function)
                .limit(periods)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(BigDecimal.valueOf(periods));
    }

}
