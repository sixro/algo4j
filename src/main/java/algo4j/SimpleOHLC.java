package algo4j;

import java.math.BigDecimal;

public class SimpleOHLC implements OHLC {

    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal volume;

    public SimpleOHLC(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
        this(open, high, low, close, BigDecimal.ZERO);
    }

    public SimpleOHLC(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    @Override
    public BigDecimal open() {
        return open;
    }

    @Override
    public BigDecimal high() {
        return high;
    }

    @Override
    public BigDecimal low() {
        return low;
    }

    @Override
    public BigDecimal close() {
        return close;
    }

    @Override
    public BigDecimal volume() {
        return volume;
    }

}
