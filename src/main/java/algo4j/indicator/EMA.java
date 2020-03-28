package algo4j.indicator;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.ListNumericalTimeSeries;
import algo4j.timeseries.NumericalTimeSeries;

import java.math.BigDecimal;
import java.util.List;

public class EMA extends ListNumericalTimeSeries {
    private EMA(List<DataPoint<BigDecimal>> list) {
        super(list);
    }

    public static EMA of(int periods, NumericalTimeSeries timeSeries) {
        return null;
    }

}
