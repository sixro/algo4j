package algo4j.parameter;

import static org.junit.Assert.assertEquals;

import algo4j.Parameter;
import java.math.BigDecimal;
import org.junit.Test;

public class BigDecimalParameterTest {

    @Test
    public void creation() {
        Parameter<BigDecimal> p = BigDecimalParameter.of(BigDecimal.TEN);
        assertEquals(new BigDecimal("10"), p.value());
    }

}
