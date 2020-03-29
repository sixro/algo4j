package algo4j.strategy;

import algo4j.*;
import algo4j.indicator.SMA;
import algo4j.timeseries.Numerical;
import algo4j.timeseries.OHLC;

/**
 * Represents a {@code Strategy} using 2 simple moving averages crossing.
 *
 * <p>
 * It is just an example to show how a algo4j user can create his own strategies.
 * </p>
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
public class SmaCxStrategy implements Strategy {

    private final ISIN isin;

    public SmaCxStrategy(ISIN isin) {
        this.isin = isin;
    }

    @Override
    public void run(Parameters parameters, Market market, Broker broker) {
        int fastMaNum = parameters.get("fastMA", Integer.class);
        int slowMaNum = parameters.get("slowMA", Integer.class);

        OHLC ohlc = market.ohlc(isin);
        Numerical close = ohlc.close();
        SMA fastMA = SMA.of(fastMaNum, close);
        SMA slowMA = SMA.of(slowMaNum, close);
        Orders openOrders = broker.openOrders(isin);
        if (openOrders.count() == 0) {
            if (fastMA.crossesOver(slowMA))
                broker.enterOrder(Order.newOrder(isin, 100, Order.Direction.LONG, Order.Type.atMarket()));
        } else {
            if (fastMA.crossesUnder(slowMA))
                openOrders.close();
        }
    }
}
