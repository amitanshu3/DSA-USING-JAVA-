import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;    // Stack to store the main elements.
    private Stack<Integer> minStack; // Stack to keep track of the minimum element.

    public MinStack() {
        stack = new Stack<>();    // Initialize the main stack.
        minStack = new Stack<>(); // Initialize the minimum stack.
    }

    public void push(int val) {
        stack.push(val); // Push the value onto the main stack.

        // Check if the minimum stack is empty or if the new value is less than or equal
        // to the current minimum (top element) in the minimum stack.
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val); // If so, push the new value onto the minimum stack.
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            // If the value being popped from the main stack is equal to the current minimum
            // (top element) in the minimum stack, also pop it from the minimum stack.
            minStack.pop();
        }
        stack.pop(); // Always pop the top element from the main stack.
    }

    public int top() {
        return stack.peek(); // Return the top element of the main stack.
    }

    public int getMin() {
        return minStack.peek(); // Return the current minimum element from the minimum stack.
    }
}
