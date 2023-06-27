package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BaseUnitTest {

    @Test
    void testParserModOperator() {
        BaseUnit minute = new Minute("*/15");
        List<Integer> results = minute.evaluate().getRawOutput();
        Assertions.assertIterableEquals(Arrays.asList(0, 15, 30, 45), results);
    }

    @Test
    void testParserRangeOperator() {
        BaseUnit dow = new DayOfWeek("1-5");
        List<Integer> results = dow.evaluate().getRawOutput();
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), results);
    }

    @Test
    void testParserAnyOperator() {
        BaseUnit dow = new DayOfWeek("*");
        List<Integer> results = dow.evaluate().getRawOutput();
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), results);
    }

    @Test
    void testParserSelectOperator() {
        BaseUnit dow = new DayOfWeek("1,5");
        List<Integer> results = dow.evaluate().getRawOutput();
        Assertions.assertIterableEquals(Arrays.asList(1, 5), results);
    }

    @Test
    void testParserReturnExpressionValueIfNoRegexIsProvided() {
        BaseUnit minute = new Minute("0");
        List<Integer> results = minute.evaluate().getRawOutput();
        Assertions.assertIterableEquals(List.of(0), results);
    }

}