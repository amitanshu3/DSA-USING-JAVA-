public class QueueUsingArray {
    static int[] arr;
    static int front;
    static int rear;

    // Constructor to initialize the queue with a specified size
    QueueUsingArray(int size) {
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    // Method to enqueue (add) an element to the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Sorry, cannot add element because the queue is full");
            return;
        }
        rear = rear + 1;
        arr[rear] = data;
    }

    // Method to dequeue (remove) an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Sorry, the queue is empty");
            return -1;
        }
        int value = arr[front];
        front = front + 1;
        return value;
    }

    // Method to peek (view) the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Sorry, the queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Method to check if the queue is full
    public boolean isFull() {
        if (rear + 1 == arr.length) {
            return true;
        }
        return false;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        if (rear == -1) {
            return true;
        }
        return false;
    }

    // Method to display the elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Sorry, the queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        QueueUsingArray ob = new QueueUsingArray(10);
        for (int i = 0; i < 10; i++) {
            ob.enqueue(i);
        }
        for (int i = 0; i < 9; i++) {
            ob.dequeue();
        }
        ob.enqueue(22);
        ob.display();
    }
}
