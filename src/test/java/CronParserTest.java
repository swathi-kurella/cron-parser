import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CronParserTest {
    CronParser cronParser = new CronParser();
    @Test
    void testParserModOperator() {
        List<Integer> results = cronParser.parser("*/15", Constants.MINUTE_END);
        Assertions.assertIterableEquals(Arrays.asList(0, 15, 30, 45), results);
    }

    @Test
    void testParserRangeOperator() {
        List<Integer> results = cronParser.parser("1-5", Constants.DAY_OF_WEEK_END);
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), results);
    }

    @Test
    void testParserAnyOperator() {
        List<Integer> results = cronParser.parser("*", Constants.DAY_OF_WEEK_END);
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), results);
    }

    @Test
    void testParserSelectOperator() {
        List<Integer> results = cronParser.parser("1,5", Constants.DAY_OF_WEEK_END);
        Assertions.assertIterableEquals(Arrays.asList(1, 5), results);
    }
}