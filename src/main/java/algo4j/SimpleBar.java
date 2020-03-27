package algo4j;

import java.math.BigDecimal;
import java.util.Optional;

public class SimpleBar implements Bar {

    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal volume;

    public SimpleBar(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = null;
    }

    public SimpleBar(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
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
    public Optional<BigDecimal> volume() {
        return Optional.ofNullable(volume);
    }

    @Override
    public String toString() {
        return "<O=" + open +
                ", H=" + high +
                ", L=" + low +
                ", C=" + close +
                ", V=" + volume +
                '>';
    }
}
