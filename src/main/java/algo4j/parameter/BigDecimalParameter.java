package algo4j.parameter;

import java.math.BigDecimal;

public class BigDecimalParameter extends FixedParameter<BigDecimal> {

    private BigDecimalParameter(BigDecimal value) {
        super(value);
    }

    public static BigDecimalParameter of(BigDecimal value) {
        // TODO cache?
        return new BigDecimalParameter(value);
    }
}
