class MyQueue {
    Stack<Integer> s1; // Stack 1 for enqueue operations (push)
    Stack<Integer> s2; // Stack 2 for dequeue operations (pop and peek)

    public MyQueue() {
        s1 = new Stack<>(); // Initialize Stack 1 for enqueue
        s2 = new Stack<>(); // Initialize Stack 2 for dequeue
    }

    public void push(int x) {
        // Enqueue (push) an element into the queue.

        // Move all elements from Stack 1 to Stack 2, effectively reversing the order.
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push the new element into Stack 1 to maintain the queue order.
        s1.push(x);

        // Move the elements back from Stack 2 to Stack 1 to restore the original order.
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        // Dequeue (pop) and return the front element from the queue.

        if (s1.isEmpty()) {
            return -1; // If Stack 1 is empty, the queue is empty, return -1.
        }

        return s1.pop(); // Pop the top element from Stack 1 (front of the queue).
    }

    public int peek() {
        // Peek and return the front element of the queue without removing it.

        if (!s1.isEmpty()) {
            return s1.peek(); // Return the top element of Stack 1 (front of the queue).
        }

        return -1; // If Stack 1 is empty, the queue is empty, return -1.
    }

    public boolean empty() {
        // Check if the queue is empty.

        return s1.isEmpty(); // If Stack 1 is empty, the queue is empty.
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);           // Enqueue (push) an element into the queue.
 * int param_2 = obj.pop();   // Dequeue (pop) and return the front element from the queue.
 * int param_3 = obj.peek();  // Peek and return the front element of the queue without removing it.
 * boolean param_4 = obj.empty(); // Check if the queue is empty.
 */
