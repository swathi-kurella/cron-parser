package unit;

import java.util.ArrayList;
import java.util.List;


public class BaseUnit {
    private final String expression;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getOutput() {
        return formatOutput();
    }

    List<Integer> getRawOutput() {
        return this.output;
    }

    public String getExpression() {
        return expression;
    }

    private int min = 0;

    private int max = 0;

    private final List<Integer> output = new ArrayList<>();

    BaseUnit(String expression){
        this.expression = expression;
    }

    public BaseUnit evaluate() {
        if (hasOperator(Operator.RANGE)) {
            computeRange();
        } else if(hasOperator(Operator.SELECT)) {
            select();
        } else if (expression.equals(Operator.ANY)) {
            computeRange(this.min, this.max);
        } else if(hasOperator(Operator.MOD)) {
            computeMod();
        } else {
            pickSingle();
        }

        return this;
    }

    boolean hasOperator(String operator) {
        return expression.contains(operator);
    }

    void computeRange() {
        String[] range = expression.split(Operator.RANGE);
        //add range validations
        int rangeStart = Integer.parseInt(range[0]);
        int rangeEnd = Integer.parseInt(range[1]);
        computeRange(rangeStart, rangeEnd);
    }

    void computeRange(int start, int end) {
        for (int i = start; i <= end; i++) {
            output.add(i);
        }
    }

    void pickSingle() {
        output.add(Integer.parseInt(expression));
    }

    void select() {
        String[] values = expression.split(Operator.SELECT);
        for (String each : values) {
            int val = Integer.parseInt(each);
            output.add(val); //Add check if val falls in btw min and max
        }
    }

    void computeMod() {
        String[] mod = expression.split(Operator.MOD);
        int denominator = Integer.parseInt(mod[1]);
        int start = this.min;
        while (start < this.max) {
            output.add(start);
            start += denominator;
        }
    }

    String formatOutput() {

        int iMax = output.size() - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(output.get(i));
            if (i == iMax)
                return b.toString();
            b.append(" ");
        }

    }
}
