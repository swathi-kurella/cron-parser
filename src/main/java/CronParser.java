import java.util.ArrayList;
import java.util.List;

public class CronParser {

    public static void main(String[] args) {
        CronParser parser = new CronParser();
        parser.evaluateExpression(args[0]);
    }

    private void evaluateExpression(String expression) {
        String[] cronArgs = expression.split(Constants.SPACE);
        String minute = cronArgs[0];
        String hour = cronArgs[1];
        String dayOfMonth = cronArgs[2];
        String month = cronArgs[3];
        String dayOfWeek = cronArgs[4];
        String command = cronArgs[5];


        //minute parser
        List<Integer> minuteValues = parser(minute, Constants.MINUTE_END);
        //hour parser
        List<Integer> hourValues = parser(hour, Constants.HOUR_END);
        //dayOfMonth parser
        List<Integer> domValues = parser(dayOfMonth, Constants.DAY_OF_MONTH_END);
        //month parser
        List<Integer> monthValues = parser(month, Constants.MONTH_END);
        //dayOfWeek parser
        List<Integer> dowValues = parser(dayOfWeek, Constants.DAY_OF_WEEK_END);

        System.out.println("minute " + toString(minuteValues));
        System.out.println("hour " + toString(hourValues));
        System.out.println("day of month " + toString(domValues));
        System.out.println("month " + toString(monthValues));
        System.out.println("day of week " + toString(dowValues));
        System.out.println("command " + command);
    }

    public List<Integer> parser(String expression, int maxValue) {
        List<Integer> result = new ArrayList<>();
        String[] range = expression.split(Constants.RANGE);
        if (range.length > 1) {
            int rangeStart = Integer.parseInt(range[0]);
            int rangeEnd = Integer.parseInt(range[1]);
            return range(rangeStart, rangeEnd);
        }
        String[] values = expression.split(Constants.MULTIPLE);
        if (values.length > 1) {
            return multiple(values);
        }
        if (expression.equals(Constants.ANY)) {
            return range(1, maxValue);
        }

        String[] mod = expression.split(Constants.MOD);
        if (mod.length > 1) {
            int denominator = Integer.parseInt(mod[1]);
            return mod(denominator, maxValue);
        }

        result.add(Integer.parseInt(expression));
        return result;
    }

    private List<Integer> range(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(i);
        }

        return result;
    }

    private List<Integer> multiple(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String each : values) {
            int val = Integer.parseInt(each);
            result.add(val);
        }
        return result;
    }

    private List<Integer> mod(int denominator, int maxValue) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        while (start < maxValue) {
            result.add(start);
            start += denominator;
        }

        return result;
    }

    private String toString(List<Integer> numbers) {
        if (numbers == null)
            return "null";

        int iMax = numbers.size() - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(numbers.get(i));
            if (i == iMax)
                return b.toString();
            b.append(" ");
        }

    }
}
