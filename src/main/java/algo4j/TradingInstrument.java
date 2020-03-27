package algo4j;

public interface TradingInstrument {

    // TODO use ISIN provided by themissingobjects
    String isin();

    boolean inMarket();

    void enter();

    void exit();

    Orders allOrders();

}
