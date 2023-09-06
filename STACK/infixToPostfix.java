import java.util.*;

class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        StringBuilder sb = new StringBuilder(""); // Create a StringBuilder to build the postfix expression.
        Stack<Character> s = new Stack<>(); // Create a stack to help with the conversion.

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(') {
                s.push(c); // If an opening parenthesis is encountered, push it onto the stack.
            } else if (Character.isLetterOrDigit(c)) {
                sb.append(c); // If a letter or digit is encountered, add it to the output.
            } else if (c == ')') {
                // If a closing parenthesis is encountered, pop and append operators from the stack
                // to the output until an opening parenthesis is encountered, then pop the opening parenthesis.
                while (!s.isEmpty() && s.peek() != '(') {
                    sb.append(s.pop());
                }
                if (!s.isEmpty() && s.peek() == '(') {
                    s.pop(); // Pop the opening parenthesis.
                }
            } else if (isOperator(c)) {
                // If an operator is encountered, pop and append operators from the stack to the output
                // while they have higher or equal precedence compared to the current operator, then push
                // the current operator onto the stack.
                while (!s.isEmpty() && precedence(c) <= precedence(s.peek())) {
                    sb.append(s.pop());
                }
                s.push(c); // Push the current operator onto the stack.
            }
        }

        // After processing the input expression, pop and append any remaining operators from the stack to the output.
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.toString(); // Convert the StringBuilder to a String and return the postfix expression.
    }

    // Function to check if a character is an operator.
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Function to determine the precedence of an operator.
    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1; // Return -1 for characters that are not operators.
        }
    }
}
