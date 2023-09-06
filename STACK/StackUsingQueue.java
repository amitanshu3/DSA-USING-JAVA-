class MyStack {
    Queue<Integer> q1; // Queue 1
    Queue<Integer> q2; // Queue 2
    
    public MyStack() {
        q1 = new LinkedList<>(); // Initialize Queue 1
        q2 = new LinkedList<>(); // Initialize Queue 2
    }
    
    public void push(int x) {
        // Push an element onto the stack.
        
        // Case 1: If Queue 1 is not empty, add the element to Queue 1.
        if (!q1.isEmpty()) {
            q1.add(x);
        } 
        // Case 2: If Queue 1 is empty, add the element to Queue 2.
        else {
            q2.add(x);
        }
    }
    
    public int pop() {
        // Remove and return the top element from the stack.
        int value = -1; // Initialize the value to -1 (in case both queues are empty).
        
        // Case 1: If Queue 1 is not empty, move elements from Queue 1 to Queue 2
        // until there is only one element left in Queue 1 (the top element).
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                value = q1.remove(); // Remove an element from Queue 1.
                if (q1.isEmpty()) {
                    break;
                }
                q2.add(value); // Move the removed element to Queue 2.
            } 
        } 
        // Case 2: If Queue 1 is empty, do the same as in Case 1, but with Queue 2.
        else {
            while (!q2.isEmpty()) {
                value = q2.remove(); // Remove an element from Queue 2.
                if (q2.isEmpty()) {
                    break;
                }
                q1.add(value); // Move the removed element to Queue 1.
            } 
        }
        
        return value; // Return the removed element (the top element of the stack).
    }
    
    public int top() {
        // Return the top element of the stack without removing it.
        int value = -1; // Initialize the value to -1 (in case both queues are empty).
        
        // Similar to the pop() method, but we don't remove the top element here.
        
        // Case 1: If Queue 1 is not empty, move elements from Queue 1 to Queue 2
        // until there is only one element left in Queue 1 (the top element).
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                value = q1.remove(); // Remove an element from Queue 1.
                q2.add(value); // Move the removed element to Queue 2.
            }
        } 
        // Case 2: If Queue 1 is empty, do the same as in Case 1, but with Queue 2.
        else {
            while (!q2.isEmpty()) {
                value = q2.remove(); // Remove an element from Queue 2.
                q1.add(value); // Move the removed element to Queue 1.
            }
        }
        
        return value; // Return the top element (the last removed element).
    }
    
    public boolean empty() {
        // Check if both Queue 1 and Queue 2 are empty.
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);           // Push an element onto the stack.
 * int param_2 = obj.pop();   // Remove and return the top element from the stack.
 * int param_3 = obj.top();   // Return the top element of the stack without removing it.
 * boolean param_4 = obj.empty(); // Check if the stack is empty.
 */
