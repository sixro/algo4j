package algo4j.parameter;

import algo4j.Parameter;

public interface RangeParameter<T extends Comparable<T>, S> extends Parameter<T> {

    T from();

    T to();

    boolean hasNext();

    void next();

    void reset();

}
