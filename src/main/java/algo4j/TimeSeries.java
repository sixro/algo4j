package algo4j;

public interface TimeSeries<T> extends Iterable<T> {

    T at(int index);

}
