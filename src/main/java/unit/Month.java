package unit;

public class Month extends BaseUnit {

    public Month(String expression) {
        super(expression);
        super.setMin(1);
        super.setMax(12);
    }

    @Override
    public String getOutput() {
        return String.format("%-14s", "Month")  + super.getOutput();
    }
}
