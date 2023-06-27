import unit.*;

public class CronParser {

    public static void main(String[] args) {
        CronParser parser = new CronParser();
        parser.evaluateExpression(args[0]);
    }

    private void evaluateExpression(String expression) {
        String[] cronArgs = expression.split(" ");

        System.out.println(new Minute(cronArgs[0]).evaluate().getOutput());
        System.out.println(new Hour(cronArgs[1]).evaluate().getOutput());
        System.out.println(new DayOfMonth(cronArgs[2]).evaluate().getOutput());
        System.out.println(new Month(cronArgs[3]).evaluate().getOutput());
        System.out.println(new DayOfWeek(cronArgs[4]).evaluate().getOutput());
        System.out.println(String.format("%-14s", "command") + cronArgs[5]);
    }

}
