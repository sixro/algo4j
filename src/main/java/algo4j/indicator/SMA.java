package algo4j.indicator;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.ListNumericalTimeSeries;
import algo4j.timeseries.NumericalTimeSeries;

import java.math.BigDecimal;
import java.util.List;

public class SMA extends ListNumericalTimeSeries {
    private SMA(List<DataPoint<BigDecimal>> list) {
        super(list);
    }

    public static SMA of(int periods, NumericalTimeSeries timeSeries) {
        return null;
    }

}
