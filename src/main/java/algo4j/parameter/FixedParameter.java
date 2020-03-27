package algo4j.parameter;

import algo4j.Parameter;

public abstract class FixedParameter<T extends Comparable<T>> implements Parameter<T> {

    protected final T value;

    protected FixedParameter(T value) {
        this.value = value;
    }

    @Override
    public T value() {
        return value;
    }

}
