package algo4j;

public interface Backtest {

    Backtest.Result test(Strategy strategy, TimeSeries timeSeries, ObjectiveFunction objectiveFunction);

    interface Result { }

}
