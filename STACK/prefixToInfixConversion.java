import java.util.*;

public class Solution {
    public static String prefixToInfixConversion(String exp) {
        Stack<String> s = new Stack<>(); // Create a stack to hold operands and intermediate infix expressions.

        // Iterate through the prefix expression from right to left.
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i); // Get the current character in the expression.

            if (isOperand(c)) {
                // If the character is an operand (letter or digit), push it onto the stack.
                s.push(c + "");
            } else {
                // If the character is an operator, pop the top two operands from the stack.
                String op1 = s.pop();
                String op2 = s.pop();

                // Create an infix expression by placing the operator between the operands and enclosing them in parentheses.
                String ans = "(" + op1 + c + op2 + ")";

                // Push the resulting infix expression back onto the stack.
                s.push(ans);
            }
        }

        return s.pop(); // The final infix expression is on top of the stack.
    }

    static boolean isOperand(char c) {
        // Helper function to check if a character is an operand (letter or digit).
        return Character.isLetterOrDigit(c);
    }
}
