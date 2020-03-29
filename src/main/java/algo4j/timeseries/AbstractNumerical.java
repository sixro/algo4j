package algo4j.timeseries;

/**
 * Represents a base class for almost all numerical time series.
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public abstract class AbstractNumerical implements Numerical {

    private static final int HIGHER = 1;
    private static final int LOWER = -1;

    @Override
    public boolean crossesOver(Numerical series) {
        return value(0).compareTo(series.value(0)) == HIGHER
            && value(1).compareTo(series.value(1)) == LOWER;
    }

    @Override
    public boolean crossesUnder(Numerical series) {
        return value(0).compareTo(series.value(0)) == LOWER
            && value(1).compareTo(series.value(1)) == HIGHER;
    }

    @Override
    public Numerical highest(int periods) {
        // TODO impl
        return null;
    }

    @Override
    public Numerical lowest(int periods) {
        // TODO impl
        return null;
    }

    @Override
    public boolean higher(Numerical series) {
        return value(0).compareTo(series.value(0)) == HIGHER;
    }

    @Override
    public boolean lower(Numerical series) {
        return value(0).compareTo(series.value(0)) == LOWER;
    }

}
