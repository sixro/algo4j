package algo4j;

public class TestingBroker implements Broker {

    private TimeSeries timeSeries;

    public TestingBroker() {
    }

    @Override
    public boolean inMarket() {
        return false;
    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    /**
     * Update the inner time series to allow broker operations to be evaluated correctly.
     *
     * <p>
     * Of course a real {@link Broker} won't need this, it will enter/exit the market opening real positions.
     * </p>
     *
     * @param timeSeries a time series
     */
    public void updateTimeSeries(TimeSeries timeSeries) {

    }

    public Orders allOrders() {
        return null;
    }

}
