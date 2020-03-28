package learning;

import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class LocalDateTimeLearningTest {

    @Test public void test() {
        LocalDateTime datetime = LocalDateTime.parse("2020-03-28T01:23:45");
        DayOfWeek dayOfWeek = DayOfWeek.from(datetime);
        Assert.assertEquals(DayOfWeek.SATURDAY, dayOfWeek);
    }

}
