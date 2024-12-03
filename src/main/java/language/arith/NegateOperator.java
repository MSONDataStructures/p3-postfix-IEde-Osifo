package language.arith;

import language.Operand;
import language.Operator;

public class NegateOperator implements Operator<Integer> {

    private Operand<Integer> op0;
    private boolean isOperandSet = false;

    @Override
    public void setOperand(int i, Operand<Integer> operand) {
        if (i != 0) {
            throw new IllegalArgumentException("Unary operator should not accept input to position " + i);
        }

        if (operand == null) {
            throw new NullPointerException("Operator should not allow null arguments");
        }

        if (isOperandSet) {
            throw new IllegalStateException("Operator should not allow position 0 to be set more than once");
        }

        op0 = operand;
        isOperandSet = true;
    }

    @Override
    public Operand<Integer> performOperation() {
        if (!isOperandSet) {
            throw new IllegalStateException("Operator should not compute when all arguments have not been set.");
        }

        // Negate the operand value
        Integer negatedValue = -op0.getValue();
        return new Operand<>(negatedValue);
    }

    @Override
    public int getNumberOfArguments() {
        return 1; // Unary operator has only one operand
    }
}
