package algo4j;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SMA implements TimeSeries<BigDecimal> {

    private final TimeSeries<BigDecimal> input;
    private final int periods;

    public SMA(TimeSeries<BigDecimal> input, int periods) {
        this.input = input;
        this.periods = periods;
    }

    @Override
    public BigDecimal at(int index) {
        return StreamSupport.stream(spliterator(), false)
            .skip(index)
            .limit(1)
            .findFirst()
            .get();
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        List<BigDecimal> buffer = StreamSupport.stream(input.spliterator(), false)
            .limit(periods -1)
            .collect(Collectors.toList());

        return StreamSupport.stream(input.spliterator(), false)
            .skip(periods -1)
            .peek(it -> { buffer.add(it); if (buffer.size() > periods) buffer.remove(0); })
            .map(ignore -> {
                BigDecimal sum = BigDecimal.ZERO;
                for (BigDecimal each: buffer) sum = sum.add(each);
                return sum.divide(BigDecimal.valueOf(buffer.size()));
            })
            .iterator();
    }

}
