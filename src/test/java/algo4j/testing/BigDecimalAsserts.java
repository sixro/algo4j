package algo4j.testing;

import org.junit.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalAsserts {

    private BigDecimalAsserts() { }

    public static void assertBigDecimalEquals(BigDecimal expected, BigDecimal actual, int scale, RoundingMode roundingMode) {
        BigDecimal e = expected.setScale(scale, roundingMode);
        BigDecimal a = actual.setScale(scale, roundingMode);
        Assert.assertEquals("bigdecimal equals (expected " + e + ", got " + a + ")", e, a);
    }

}
