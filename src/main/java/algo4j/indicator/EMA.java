package algo4j.indicator;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.ListNumerical;
import algo4j.timeseries.Numerical;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents an exponential moving average.
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public class EMA extends ListNumerical implements Indicator {

    private EMA(List<DataPoint<BigDecimal>> list) {
        super(list);
    }

    public static EMA of(int periods, Numerical starting) {
        List<DataPoint<BigDecimal>> emas = new LinkedList<>();

        BigDecimal prevEma = starting.value(starting.length() -1);
        BigDecimal multiplier = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(periods +1));
        for (int i = starting.length() -2; i >= 0; i--) {
            BigDecimal v = starting.value(i);
            BigDecimal ema = v.subtract(prevEma).multiply(multiplier).add(prevEma);
            emas.add(DataPoint.of(ema, starting.datetime(i)));
            prevEma = ema;
        }

        Collections.reverse(emas);
        return new EMA(emas);
    }

}
