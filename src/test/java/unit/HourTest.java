package unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourTest {

    @Test
    void testOutput() {
        BaseUnit hour = new Hour("0");
        assertEquals("Hour          0", hour.evaluate().getOutput());
    }

}