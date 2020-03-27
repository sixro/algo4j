package algo4j;

public class SimpleBacktest implements Backtest {

    @Override
    public Backtest.Result test(Strategy strategy, TimeSeries timeSeries, ObjectiveFunction objectiveFunction) {

        TestingBroker broker = new TestingBroker();
        int length = timeSeries.length();
        for (int i = length; i > 0; i--) {
            TimeSeries sub = timeSeries.sub(i);
            broker.updateTimeSeries(sub);
            strategy.run(sub, broker);
        }

        Orders orders = broker.allOrders();
        return null;
    }

}
