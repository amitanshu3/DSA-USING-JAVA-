public class CircularDoublyLinkedList {
    private int size = 0;

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    // Function to add a node to the beginning of the circular doubly linked list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            head = tail = newNode;
            head.next = head;
            head.prev = tail;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Function to add a node to the end of the circular doubly linked list
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            head = tail = newNode;
            head.next = head;
            head.prev = tail;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    // Function to add a node at a given index in the circular doubly linked list
    public void addMiddle(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
        size++;
    }

    // Function to display the circular doubly linked list
    public void display() {
        if (head == null) {
            System.out.println("Circular Doubly Linked List is empty");
            return;
        }
        Node current = head;
        int i = 0;
        do {
            System.out.println("Node no " + i + " value is " + current.data);
            current = current.next;
            i++;
        } while (current != head);
        System.out.println("Successfully printed all the Circular Doubly Linked List");
    }

    // Function to remove the first node from the circular doubly linked list
    public int removeFirst() {
        if (size == 0) {
            System.out.println("Circular Doubly Linked List is empty");
            return 0;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
        return val;
    }

    // Function to remove the last node from the circular doubly linked list
    public int removeLast() {
        if (size == 0) {
            System.out.println("Circular Doubly Linked List is empty");
            return 0;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
        return val;
    }

    // Function to remove a node at a given index from the circular doubly linked list
    public int removeMiddle(int index) {
        if (index == 0) {
            int val = removeFirst();
            return val;
        } else if (index == size - 1) {
            int val = removeLast();
            return val;
        }
        Node temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        int val = temp.data;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return val;
    }

    // Function to reverse the circular doubly linked list
    public void reverseList() {
        if (size < 2) {
            return; // No need to reverse for 0 or 1 elements
        }
        Node current = head;
        do {
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        } while (current != head);
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.addFirst(33);
        list.addFirst(66);
        list.addFirst(44);
        list.addFirst(99);
        list.addLast(100);
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);
        list.addMiddle(401, 0);
        list.addMiddle(501, 1);
        list.addFirst(444);
        list.addLast(888);
        list.display();

        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        list.display();
        System.out.println(list.removeMiddle(1));

        list.reverseList();
        list.display();
    }
}
