import java.util.ArrayList;

public class StackUsingArrayList {
    static ArrayList<Integer> list = new ArrayList<>();
    static int top = -1;

    // Function to push an element onto the stack
    static void push(int data) {
        ++top; // Increment top to point to the next position
        list.add(data); // Add the data to the ArrayList
    }

    // Function to pop an element from the stack
    static int pop() {
        if (top == -1) {
            System.out.println("Sorry the stack is empty");
            return -1; // If the stack is empty, return -1
        }

        int value = list.get(top); // Get the element at the top
        list.remove(top); // Remove the element from the ArrayList
        top--; // Decrement top to point to the new top
        return value;
    }

    // Function to peek at the top element of the stack
    static int peek() {
        if (top == -1) {
            System.out.println("Sorry the stack is empty you can not peek element");
            return -1; // If the stack is empty, return -1
        }
        int value = list.get(top); // Get the element at the top
        return value;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            push(i); // Push elements onto the stack
        }
        for (int i = 0; i < 10; i++) {
            int value = pop(); // Pop elements from the stack
            System.out.println("popped value is " + value);
        }
        System.out.println(peek()); // Peek at the top element of the stack
    }
}
