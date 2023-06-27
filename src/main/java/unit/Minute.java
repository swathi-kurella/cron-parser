package unit;

public class Minute extends BaseUnit {

    public Minute(String expression) {
        super(expression);
        super.setMin(0);
        super.setMax(60);
    }

    @Override
    public String getOutput() {
        return String.format("%-14s", "Minute") + super.getOutput();
    }
}
