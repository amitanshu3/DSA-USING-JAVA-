public class StackUsingArray {

    static int[] arr; // Array to store stack elements
    static int top = -1; // Initialize top of the stack as -1 to represent an empty stack

    // Constructor to create a stack with a given size
    StackUsingArray(int size) {
        arr = new int[size]; // Initialize the stack array with the given size
    }

    // Function to push an element onto the stack
    static void push(int data) {
        if (top == arr.length - 1) {
            System.out.println("SORRY STACK IS FULL"); // Check if the stack is full
            return;
        }
        arr[++top] = data; // Increment top and add the data to the stack
    }

    // Function to pop an element from the stack
    static int pop() {
        if (top == -1) {
            System.out.println("Sorry the stack is empty you can not pop element"); // Check if the stack is empty
            return -1;
        }
        int value = arr[top--]; // Get the element at the top and decrement top
        return value;
    }

    // Function to peek at the top element of the stack
    static int peek() {
        if (top == -1) {
            System.out.println("Sorry the stack is empty you can not peek element"); // Check if the stack is empty
            return -1;
        }
        int value = arr[top]; // Get the element at the top
        return value;
    }

    // Function to print the elements of the stack
    static void print() {
        if (top == -1) {
            System.out.println("Sorry the stack is completely empty you can not print");;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
        return;
    }

    public static void main(String[] args) {

        StackUsingArray ob = new StackUsingArray(10); // Create a stack with a size of 10
        for (int i = 0; i < 10; i++) {
            push(i); // Push elements onto the stack
        }
        print(); // Print the stack

        // push(99); // Uncommenting this line would try to push an element onto a full stack

        for (int i = 0; i < arr.length; i++) {
            int value = pop(); // Pop elements from the stack
            System.out.println("popped value is " + value);
        }
        print(); // Print the stack after popping all elements
    }
}
