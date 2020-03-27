package algo4j.parameter;

import static org.junit.Assert.*;

import algo4j.Parameter;
import org.junit.Test;

public class IntParameterTest {

    @Test
    public void creation() {
        Parameter<Integer> p = IntParameter.of(1);
        assertEquals(Integer.valueOf(1), p.value());
    }

}
