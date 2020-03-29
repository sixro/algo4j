package algo4j.timeseries;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ListOHLC implements OHLC {

    private final List<DataPoint<Value>> list;

    public ListOHLC(List<DataPoint<Value>> list) {
        this.list = list;
    }

    @Override
    public Numerical open() {
        return new FunctionLazyNumerical<>(this, Value::open);
    }

    @Override
    public Numerical high() {
        return new FunctionLazyNumerical<>(this, Value::high);
    }

    @Override
    public Numerical low() {
        return new FunctionLazyNumerical<>(this, Value::low);
    }

    @Override
    public Numerical close() {
        return new FunctionLazyNumerical<>(this, Value::close);
    }

    @Override
    public Numerical volume() {
        return new FunctionLazyNumerical<>(this, Value::volume);
    }

    @Override
    public OHLC at(int index) {
        return new ListOHLC(list.subList(index, list.size()));
    }

    @Override
    public Value value(int index) {
        return list.get(index).value();
    }

    @Override
    public LocalDateTime datetime(int index) {
        return list.get(index).datetime();
    }

    @Override
    public int length() {
        return list.size();
    }

    public static class SimpleOHLCValue implements OHLC.Value {

        private final BigDecimal open;
        private final BigDecimal high;
        private final BigDecimal low;
        private final BigDecimal close;
        private final BigDecimal volume;

        private SimpleOHLCValue(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
            this.open = open;
            this.high = high;
            this.low = low;
            this.close = close;
            this.volume = volume;
        }

        public static SimpleOHLCValue of(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
            return new SimpleOHLCValue(open, high, low, close, volume);
        }

        public static SimpleOHLCValue of(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
            return new SimpleOHLCValue(open, high, low, close, BigDecimal.ZERO);
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

        @Override
        public String toString() {
            return "{" +
                    "o=" + open +
                    ", h=" + high +
                    ", l=" + low +
                    ", c=" + close +
                    ", v=" + volume +
                    '}';
        }
    }
}
