package unit;

public class DayOfWeek extends BaseUnit {

    public DayOfWeek(String expression) {
        super(expression);
        super.setMin(1);
        super.setMax(7);
    }

    @Override
    public String getOutput() {
        return String.format("%-14s", "Day of Week") + super.getOutput();
    }
}
