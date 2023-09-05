public class CircularQueue {
    static int[] arr;    // Array to store queue elements
    static int front;    // Index of the front of the queue
    static int rear;     // Index of the rear of the queue
    static int size;     // Maximum size of the queue

    // Constructor to initialize the circular queue
    CircularQueue(int n) {
        arr = new int[n];  // Create an array of size 'n'
        front = 0;         // Initialize front to 0
        rear = -1;         // Initialize rear to -1 (empty queue)
        size = n;          // Set the maximum size of the queue
    } 

    // Method to enqueue (add) an element to the queue
    public void enqueue(int data) {
        if (isFull()) {   // Check if the queue is full
            System.out.println("Sorry, the queue is full. Cannot add elements.");
            return;
        }
        rear = (rear + 1) % size;  // Move the rear pointer in a circular manner
        arr[rear] = data;         // Add 'data' to the rear of the queue
    }

    // Method to dequeue (remove) an element from the queue
    public int dequeue() {
        if (isEmpty()) {  // Check if the queue is empty
            System.out.println("Sorry, the queue is empty. Cannot remove elements.");
            return -1;
        }
        int value = arr[front];  // Get the element at the front of the queue
        if (front == rear) {     // If there was only one element in the queue
            front = 0;           // Reset front to 0
            rear = -1;           // Reset rear to -1 (empty queue)
        } else {
            front = (front + 1) % size;  // Move front in a circular manner
        }
        return value;  // Return the removed element
    }

    // Method to peek (view) the element at the front of the queue
    public int peek() {
        if (isEmpty()) {  // Check if the queue is empty
            System.out.println("Sorry, the queue is empty. Cannot peek.");
            return -1;
        }
        int value = arr[front];  // Get the element at the front of the queue
        return value;  // Return the front element
    }

    // Method to check if the queue is full
    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;  // Queue is full
        }
        return false;      // Queue is not full
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        if (front == 0 && rear == -1) {
            return true;  // Queue is empty
        }
        return false;      // Queue is not empty
    }

    public static void main(String[] args) {
        CircularQueue ob = new CircularQueue(5);  // Create a circular queue of size 5
        for (int i = 0; i < 5; i++) {
            ob.enqueue(i);  // Enqueue elements from 0 to 4
        }
        ob.enqueue(22);  // Try to enqueue 22 (will trigger resizing)
        while (!ob.isEmpty()) {
            System.out.println(ob.peek());  // Peek and print the front element
            ob.dequeue();                   // Dequeue and remove the front element
        }
    }
}
