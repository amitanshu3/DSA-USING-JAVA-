class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // Create a stack to store opening brackets.

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if the current character is an opening bracket (parenthesis).
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // Push it onto the stack.
            } 
            // Check if the current character is a closing bracket.
            else if (ch == ')') {
                // Check if the stack is empty, indicating a closing bracket without a matching opening bracket.
                if (stack.isEmpty()) {
                    return false;
                } 
                // Check if the top element of the stack is a matching opening bracket.
                else if (stack.peek() != '(') {
                    return false;
                } 
                else {
                    stack.pop(); // Pop the matching opening bracket from the stack.
                }
            } 
            else if (ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } 
            else if (ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        // After processing all characters, check if there are any unmatched opening brackets left on the stack.
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true; // If the stack is empty, all brackets are matched and the string is valid.
        }
    }
}
