package evaluator.arith;

import evaluator.IllegalPostfixExpressionException;
import evaluator.Evaluator;
import java.util.Stack;

public class ArithPostfixEvaluator implements Evaluator<Integer> {

    @Override
    public Integer evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else if (token.equals("+")) {
                checkStackForOperation(stack, 2);
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 + operand2);
            } else if (token.equals("-")) {
                checkStackForOperation(stack, 2);
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 - operand2);
            } else if (token.equals("*")) {
                checkStackForOperation(stack, 2);
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 * operand2);
            } else if (token.equals("/")) {
                checkStackForOperation(stack, 2);
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                if (operand2 == 0) {
                    throw new IllegalStateException("Division by zero.");
                }
                stack.push(operand1 / operand2); // Integer division
            } else if (token.equals("!")) {
                checkStackForOperation(stack, 1);
                stack.push(-stack.pop());
            } else {
                throw new IllegalPostfixExpressionException("Invalid token: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalPostfixExpressionException("Malformed expression.");
        }

        return stack.pop();
    }

    private boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void checkStackForOperation(Stack<Integer> stack, int requiredOperands) {
        if (stack.size() < requiredOperands) {
            throw new IllegalPostfixExpressionException("Not enough operands for operation.");
        }
    }
}
