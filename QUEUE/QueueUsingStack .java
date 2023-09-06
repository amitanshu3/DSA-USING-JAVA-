import java.util.Stack;

// Define a class named MyQueue for implementing a queue using two stacks
class MyQueue {
    Stack<Integer> s1;  // Stack 1 for enqueue operations
    Stack<Integer> s2;  // Stack 2 for dequeue operations

    // Constructor to initialize the two stacks
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Method to push an element into the queue
    public void push(int x) {
        // To enqueue, we first transfer all elements from s1 to s2 (reversing the order)
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        // Push the new element to s1, making it the front of the queue
        s1.push(x);
        // Transfer the elements back to s1 to maintain the correct order
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Method to pop (remove and return) the front element from the queue
    public int pop() {
        if (s1.isEmpty()) {
            // If s1 is empty, the queue is empty, so return -1 (an indicator of an empty queue)
            return -1;
        }
        return s1.pop();  // Pop and return the front element from s1
    }

    // Method to peek (view) the front element of the queue without removing it
    public int peek() {
        if (!s1.isEmpty()) {
            // If s1 is not empty, return the front element
            return s1.peek();
        }
        return -1;  // If s1 is empty, return -1 (an indicator of an empty queue)
    }

    // Method to check if the queue is empty
    public boolean empty() {
        return s1.isEmpty();  // Check if s1 (the main stack) is empty
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);          // Enqueue an element 'x'
 * int param_2 = obj.pop();   // Dequeue the front element and get its value
 * int param_3 = obj.peek();  // Peek at the front element without removing it
 * boolean param_4 = obj.empty();  // Check if the queue is empty
 */
