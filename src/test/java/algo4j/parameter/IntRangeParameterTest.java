package algo4j.parameter;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntRangeParameterTest {

    @Test public void next() {
        IntRangeParameter p = new IntRangeParameter(1, 5, 2);
        assertEquals(Integer.valueOf(1), p.value());

        p.next();
        assertEquals(Integer.valueOf(3), p.value());
    }

    @Test public void reset() {
        IntRangeParameter p = new IntRangeParameter(1, 5, 2);
        p.next();
        assertEquals(Integer.valueOf(3), p.value());

        p.reset();
        assertEquals(Integer.valueOf(1), p.value());
    }

}