package algo4j.timeseries;

public abstract class AbstractNumericalTimeSeries implements NumericalTimeSeries {

    private static final int HIGHER = 1;
    private static final int LOWER = -1;

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

}
