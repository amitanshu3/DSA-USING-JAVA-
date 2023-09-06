import java.util.*;

public class Solution {
    public static String postfixToPrefix(String exp) {
        Stack<String> s = new Stack<>(); // Create a stack to hold operands and intermediate prefix expressions.

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i); // Get the current character in the expression.

            if (isOperand(c)) {
                // If the character is an operand (letter or digit), push it onto the stack.
                s.push(c + "");
            } else {
                // If the character is an operator, pop the top two operands from the stack.
                String op2 = s.pop();
                String op1 = s.pop();

                // Create a prefix expression by placing the operator in front of the operands.
                String ans = c + op1 + op2;

                // Push the resulting prefix expression back onto the stack.
                s.push(ans);
            }
        }

        return s.pop(); // The final prefix expression is on top of the stack.
    }

    static boolean isOperand(char c) {
        // Helper function to check if a character is an operand (letter or digit).
        return Character.isLetterOrDigit(c);
    }
}
