package algo4j.strategy;

import algo4j.CsvMarket;
import algo4j.Orders;
import algo4j.RecordingTradingInstrument;
import algo4j.parameter.IntParameter;
import algo4j.MapParameters;
import org.junit.Test;

import static org.junit.Assert.*;

public class MAsCxStrategyTest {

    @Test public void enter() {
        MapParameters params = new MapParameters();
        params.add("fastMA", IntParameter.of(5));
        params.add("slowMA", IntParameter.of(20));

        CsvMarket market = CsvMarket.fromClasspath("/csv-market");

        RecordingTradingInstrument instrument = new RecordingTradingInstrument("");

        MAsCxStrategy s = new MAsCxStrategy();
        s.run(params, market, instrument);

        Orders orders = instrument.allOrders();
        // TODO complex test: wait the other implementation of more simple objects
        //assertTrue(orders.containsPendingOrder());
    }

}