package algo4j.timeseries;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a numeric time series based on a list.
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public class ListNumericalTimeSeries implements NumericalTimeSeries {

    public static final int HIGHER = 1;
    public static final int LOWER = -1;
    private final List<DataPoint<BigDecimal>> list;

    public ListNumericalTimeSeries(List<DataPoint<BigDecimal>> list) {
        this.list = list;
    }

    @Override
    public boolean crossesOver(NumericalTimeSeries series) {
        return value(0).compareTo(series.value(0)) == HIGHER
            && value(1).compareTo(series.value(1)) == LOWER;
    }

    @Override
    public boolean crossesUnder(NumericalTimeSeries series) {
        return value(0).compareTo(series.value(0)) == LOWER
            && value(1).compareTo(series.value(1)) == HIGHER;
    }

    @Override
    public NumericalTimeSeries highest(int periods) {
        // TODO impl
        return null;
    }

    @Override
    public NumericalTimeSeries lowest(int periods) {
        // TODO impl
        return null;
    }

    @Override
    public boolean higher(NumericalTimeSeries series) {
        return value(0).compareTo(series.value(0)) == HIGHER;
    }

    @Override
    public boolean lower(NumericalTimeSeries series) {
        return value(0).compareTo(series.value(0)) == LOWER;
    }

    @Override
    public NumericalTimeSeries at(int index) {
        return new ListNumericalTimeSeries(list.subList(index, list.size()));
    }

    @Override
    public BigDecimal value(int index) {
        return list.get(index).value();
    }

    @Override
    public LocalDateTime datetime(int index) {
        return list.get(index).datetime();
    }
}
