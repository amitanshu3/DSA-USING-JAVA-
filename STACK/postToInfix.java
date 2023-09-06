RULES:............................................MENTIONED BELOW ......................................................................

Initialize an empty stack to hold operands and operators.
Start scanning the postfix expression from left to right.
For each element in the postfix expression:
a. If the element is an operand (a variable or constant), push it onto the stack.
b. If the element is an operator (e.g., +, -, *, /, etc.), pop the top two operands from the stack.
c. Create a string that represents the infix expression by combining the popped operands and the operator. Place the operator between the two operands.
d. Push the resulting infix expression back onto the stack.
Continue scanning and applying the above steps until you have processed the entire postfix expression.
The final infix expression will be on the top of the stack.
Here's a step-by-step example to illustrate the process:

Postfix expression: "34+2*"
Stack:

Scan "3":
It's an operand, so push it onto the stack: Stack = ["3"]
Scan "4":
It's an operand, so push it onto the stack: Stack = ["3", "4"]
Scan "+":
It's an operator. Pop the top two operands ("4" and "3") and create the infix expression "3 + 4". Push it back onto the stack: Stack = ["3 + 4"]
Scan "2":
It's an operand, so push it onto the stack: Stack = ["3 + 4", "2"]
Scan "*":
It's an operator. Pop the top two operands ("2" and "3 + 4") and create the infix expression "(3 + 4) * 2". Push it back onto the stack: Stack = ["(3 + 4) * 2"]
End of expression.
The final infix expression is on top of the stack, which is "(3 + 4) * 2".
So, the infix expression corresponding to the postfix expression "34+2*" is "(3 + 4) * 2"



CODE .........................................................................................BELOW...........................................................





    

import java.util.*;

public class Solution {
    public static String postToInfix(String exp) {
        Stack<String> s = new Stack<>(); // Create a stack to hold operands and intermediate infix expressions.
        
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i); // Get the current character in the expression.
            
            if (isOperand(c)) {
                // If the character is an operand (letter or digit), push it onto the stack.
                s.push(c + "");
            } else {
                // If the character is an operator, pop the top two operands from the stack.
                String op1 = s.pop();
                String op2 = s.pop();
                
                // Create an infix expression by placing the operator between the operands and enclosing them in parentheses.
                String ans = "(" + op2 + c + op1 + ")";
                
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
