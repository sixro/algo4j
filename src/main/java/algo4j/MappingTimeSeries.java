package algo4j;

import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.StreamSupport;

public class MappingTimeSeries<I, O> implements TimeSeries<O> {

    private final TimeSeries<I> input;
    private final Function<I, O> function;

    public MappingTimeSeries(TimeSeries<I> input, Function<I, O> function) {
        this.input = input;
        this.function = function;
    }

    @Override
    public O at(int index) {
        return StreamSupport.stream(spliterator(), false)
            .skip(index)
            .limit(1)
            .findFirst()
            .get();
    }

    @Override
    public Iterator<O> iterator() {
        return StreamSupport
            .stream(input.spliterator(), false)
            .map(function)
            .iterator();
    }

}
