public class StackUsingLinkedList {
    // Node class to represent elements in the linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null; // Initialize the head of the linked list as null
    static int top = -1; // Initialize the top of the stack as -1

    // Function to push an element onto the stack
    void push(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (head == null) {
            head = newNode; // If the stack is empty, set the new node as the head
            return;
        }
        newNode.next = head; // Set the next of the new node to the current head
        head = newNode; // Update the head to the new node
    }

    // Function to pop an element from the stack
    int pop() {
        if (head == null) {
            System.out.println("Sorry, the stack is empty");
            return -1; // If the stack is empty, return -1
        }
        int value = head.data; // Get the data of the head node
        head = head.next; // Move the head to the next node
        return value;
    }

    // Function to peek at the top element of the stack
    int peek() {
        if (head == null) {
            System.out.println("Sorry, the stack is empty, and you cannot peek at an element");
            return -1; // If the stack is empty, return -1
        }
        return head.data; // Return the data of the head node
    }

    public static void main(String[] args) {
        StackUsingLinkedList ob = new StackUsingLinkedList(); // Create an instance of the StackUsingLinkedList class
        for (int i = 1; i <= 10; i++) {
            ob.push(i); // Push elements onto the stack
        }
        for (int i = 1; i <= 10; i++) {
            int value = ob.pop(); // Pop elements from the stack
            System.out.println("Popped value is " + value);
        }
        System.out.println(ob.pop()); // Attempt to pop from an empty stack
    }
}
