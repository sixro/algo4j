package algo4j.parameter;

public class IntRangeParameter implements RangeParameter<Integer, Integer> {

    private final Integer from;
    private final Integer to;
    private final Integer step;
    private Integer value;

    public IntRangeParameter(Integer from, Integer to, Integer step) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.value = from;
    }

    @Override
    public Integer from() {
        return from;
    }

    @Override
    public Integer to() {
        return to;
    }

    @Override
    public boolean hasNext() {
        return value + step < to;
    }

    @Override
    public void next() {
        value += step;
    }

    @Override
    public void reset() {
        value = from;
    }

    @Override
    public Integer value() {
        return value;
    }
}
