package algo4j;

import java.math.BigDecimal;
import java.time.Duration;

public class SimpleBacktest implements Backtest {

    @Override
    public Backtest.Result test(Strategy strategy, String isin, Market market, /*Interval*/ String interval, Duration step, ObjectiveFunction objectiveFunction) {

        RecordingTradingInstrument tradingInstrument = new RecordingTradingInstrument(isin);
        TimeMachineMarket timeMachineMarket = new TimeMachineMarket(market);
        //for (int i = interval.from(); i > interval.to(); i.add(step)) {
        //    timeMachineMarket.atTime(interval.from() + i);
        //    strategy.run(timeMachineMarket, tradingInstrument);
        //}

        Orders orders = tradingInstrument.allOrders();
        BigDecimal evaluation = objectiveFunction.evaluate(orders);
        return null;
    }

}
