package algo4j.indicator;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.ListNumerical;
import algo4j.timeseries.Numerical;

import java.math.BigDecimal;
import java.util.List;

// TODO impl
public class RSI extends ListNumerical {
    private RSI(List<DataPoint<BigDecimal>> list) {
        super(list);
    }

    public static RSI of(int periods, Numerical timeSeries) {
        return null;
    }

}
