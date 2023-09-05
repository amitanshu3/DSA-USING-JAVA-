import java.util.ArrayList;
import java.util.List;

public class QueueUsingArrayList {
    private List<Integer> list; // Create a list to hold the queue elements
    private int front; // Index of the front element
    private int rear;  // Index of the rear element

    // Constructor to initialize the queue
    public QueueUsingArrayList() {
        list = new ArrayList<>(); // Initialize the list as an ArrayList
        front = 0; // Initialize the front index to 0
        rear = -1; // Initialize the rear index to -1 (empty queue)
    }

    // Method to enqueue (add) an element to the rear of the queue
    public void enqueue(int data) {
        list.add(data); // Add the element to the list
        rear++; // Increment the rear index
    }

    // Method to dequeue (remove) an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty"); // Print a message if the queue is empty
            return -1; // Return -1 to indicate an empty queue
        }
        int value = list.get(front); // Get the front element
        front++; // Increment the front index to remove the element
        return value; // Return the removed element
    }

    // Method to peek (view) the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty"); // Print a message if the queue is empty
            return -1; // Return -1 to indicate an empty queue
        }
        return list.get(front); // Return the front element
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front > rear; // If the front index is greater than the rear index, the queue is empty
    }

    // Method to display the elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty"); // Print a message if the queue is empty
            return;
        }
        System.out.println("Queue elements:");
        for (int i = front; i <= rear; i++) {
            System.out.println(list.get(i)); // Iterate through the elements and print them
        }
    }

    public static void main(String[] args) {
        QueueUsingArrayList queue = new QueueUsingArrayList(); // Create a new queue
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i); // Enqueue elements from 0 to 9
        }
        for (int i = 0; i < 9; i++) {
            queue.dequeue(); // Dequeue elements (remove 9 elements)
        }
        queue.enqueue(22); // Enqueue an element (adding 22)
        queue.display(); // Display the remaining elements in the queue
    }
}
