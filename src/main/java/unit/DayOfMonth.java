package unit;

public class DayOfMonth extends BaseUnit {

    public DayOfMonth(String expression) {
        super(expression);
        super.setMin(1);
        super.setMax(31);
    }

    @Override
    public String getOutput() {
        return String.format("%-14s", "Day of Month") + super.getOutput();
    }
}
