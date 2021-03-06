package algo4j.timeseries;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a time series maintaining the same value every time.
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public class HorizontalLine implements Numerical {

    private final BigDecimal value;

    private HorizontalLine(BigDecimal value) {
        this.value = value;
    }

    public static HorizontalLine at(BigDecimal value) {
        return new HorizontalLine(value);
    }

    @Override
    public Numerical at(int index) {
        return this;
    }

    @Override
    public BigDecimal value(int index) {
        return value;
    }

    @Override
    public LocalDateTime datetime(int index) {
        throw new UnsupportedOperationException("no datetime for an horizontal line. Review your TA");
    }

    @Override
    public int length() {
        throw new UnsupportedOperationException("unsupported... because infinite. Review your TA");
    }

    @Override
    public boolean crossesOver(Numerical series) {
        // TODO impl
        return false;
    }

    @Override
    public boolean crossesUnder(Numerical series) {
        // TODO impl
        return false;
    }

    @Override
    public Numerical highest(int periods) {
        return this;
    }

    @Override
    public Numerical lowest(int periods) {
        return this;
    }

    @Override
    public boolean higher(Numerical series) {
        // TODO impl
        return false;
    }

    @Override
    public boolean lower(Numerical series) {
        // TODO impl
        return false;
    }
}
