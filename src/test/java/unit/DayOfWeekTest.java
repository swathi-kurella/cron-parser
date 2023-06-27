package unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfWeekTest {

    @Test
    void testOutput() {
        BaseUnit dow = new DayOfWeek("1-5");
        assertEquals("Day of Week   1 2 3 4 5", dow.evaluate().getOutput());
    }

}