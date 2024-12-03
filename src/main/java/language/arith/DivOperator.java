package language.arith;

import language.Operand;
import language.Operator;

public class DivOperator implements Operator<Integer> {

    private Operand<Integer> operand0;
    private Operand<Integer> operand1;

    @Override
    public void setOperand(int position, Operand<Integer> operand) {
        if (operand == null) {
            throw new NullPointerException("Operand cannot be null.");
        }
        if (position < 0 || position >= 2) {
            throw new IllegalArgumentException("Operand position must be 0 or 1.");
        }
        if (position == 0 && operand0 != null || position == 1 && operand1 != null) {
            throw new IllegalStateException("Operand position " + position + " has already been set.");
        }
        if (position == 1 && operand.getValue() == 0) {
            throw new IllegalStateException("Operator should not allow the denominator to be set to zero.");
        }
        if (position == 0) {
            operand0 = operand;
        } else {
            operand1 = operand;
        }
    }

    @Override
    public Operand<Integer> performOperation() {
        if (operand0 == null || operand1 == null) {
            throw new IllegalStateException("Both operands must be set before performing the operation.");
        }
        // Check for division by zero
        if (operand1.getValue() == 0) {
            throw new IllegalStateException("Cannot divide by zero.");
        }
        int result = operand0.getValue() / operand1.getValue();
        return new Operand<>(result);
    }

    @Override
    public int getNumberOfArguments() {
        return 2; // Division is a binary operation, so it requires two operands
    }
}
