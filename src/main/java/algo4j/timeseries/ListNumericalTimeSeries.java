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
public class ListNumericalTimeSeries extends AbstractNumericalTimeSeries {

    private final List<DataPoint<BigDecimal>> list;

    public ListNumericalTimeSeries(List<DataPoint<BigDecimal>> list) {
        this.list = list;
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

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public String toString() {
        return "{" + list + '}';
    }
}
