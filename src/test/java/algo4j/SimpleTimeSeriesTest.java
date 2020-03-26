package algo4j;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleTimeSeriesTest {

    @Test public void iterable() {
        TimeSeries<Integer, LocalDate> t = new SimpleTimeSeries<>();
        t.add(1, LocalDate.parse("2019-02-01"));
        t.add(2, LocalDate.parse("2019-02-02"));

        Iterator<Integer> it = t.iterator();
        assertEquals(1, it.next().intValue());
        assertEquals(2, it.next().intValue());
        assertFalse(it.hasNext());
    }

}