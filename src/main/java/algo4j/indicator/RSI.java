package algo4j.indicator;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.ListNumericalTimeSeries;
import algo4j.timeseries.NumericalTimeSeries;

import java.math.BigDecimal;
import java.util.List;

// TODO impl
public class RSI extends ListNumericalTimeSeries {
    private RSI(List<DataPoint<BigDecimal>> list) {
        super(list);
    }

    public static RSI of(int periods, NumericalTimeSeries timeSeries) {
        return null;
    }

}
