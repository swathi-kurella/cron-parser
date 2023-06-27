package unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonthTest {

    @Test
    void testOutput() {
        BaseUnit month = new Month("*");
        assertEquals("Month         1 2 3 4 5 6 7 8 9 10 11 12", month.evaluate().getOutput());
    }

}