package unit;

public class Hour extends BaseUnit {

    public Hour(String expression) {
        super(expression);
        super.setMin(1);
        super.setMax(24);
    }

    @Override
    public String getOutput() {
        return String.format("%-14s", "Hour") + super.getOutput();
    }
}
