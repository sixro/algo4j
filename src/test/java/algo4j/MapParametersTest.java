package algo4j;

import static org.junit.Assert.*;

import algo4j.MapParameters;
import algo4j.parameter.IntParameter;
import org.junit.Test;

public class MapParametersTest {

    @Test public void value_of_param() {
        MapParameters params = new MapParameters();
        params.add("periods", IntParameter.of(10));
        assertEquals(Integer.valueOf(10), params.value("periods", Integer.class));
    }

}