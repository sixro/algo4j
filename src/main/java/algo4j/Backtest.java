package algo4j;

import java.time.Duration;

public interface Backtest {

    Backtest.Result test(Strategy strategy, String isin, Market market, /*Interval*/ String internal, Duration step, ObjectiveFunction objectiveFunction);

    interface Result { }

}
