package algo4j;

public class RecordingTradingInstrument implements TradingInstrument {

    private final String isin;

    public RecordingTradingInstrument(String isin) {
        this.isin = isin;
    }

    @Override
    public String isin() {
        return isin;
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

    @Override
    public Orders allOrders() {
        return null;
    }

}
