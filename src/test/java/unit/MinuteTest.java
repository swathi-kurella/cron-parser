package unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinuteTest {

    @Test
    void testOutput() {
        BaseUnit minute = new Minute("*/15");
        assertEquals("Minute        0 15 30 45", minute.evaluate().getOutput());
    }

}