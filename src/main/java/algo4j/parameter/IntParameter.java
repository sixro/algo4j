package algo4j.parameter;

import algo4j.Parameter;

public class IntParameter extends FixedParameter<Integer> {

    private IntParameter(Integer value) {
        super(value);
    }

    public static IntParameter of(int value) {
        // TODO we could cache a number of values to improve performances considering that low numbers (0-20) are the most used in algotrading
        return new IntParameter(value);
    }

}
