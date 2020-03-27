package algo4j;

/**
 * Represents a trading strategy.
 */
public interface Strategy {

    /**
     * Execute the strategy in the market on the specified trading instrument.
     *
     * <p>
     * It will execute on the last data provided by the market.
     * </p>
     *
     * @param market the market
     * @param tradingInstrument a trading instrument
     */
    void run(Parameters parameters, Market market, TradingInstrument tradingInstrument);

}
