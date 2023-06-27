package unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfMonthTest {

    @Test
    void testOutput() {
        BaseUnit dom = new DayOfMonth("1,15");
        assertEquals("Day of Month  1 15", dom.evaluate().getOutput());
    }

}