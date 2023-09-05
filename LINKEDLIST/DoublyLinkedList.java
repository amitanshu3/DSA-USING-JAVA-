//USING STATIC KEYWORD

public class DoublyLinkedList {
    static int size = 0;

    static class Node {
        int data;
        Node next;
        Node prev; // New field for previous node

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null; // Initialize prev to null
        }
    }

    static Node head;
    static Node tail;

    // Function to add a node to the beginning of the doubly linked list
    static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode; // Set the previous node of the current head
            head = newNode;
        }
    }

    // Function to add a node to the end of the doubly linked list
    static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail; // Set the previous node of the new tail
            tail = newNode;
        }
    }

    // Function to add a node at a given index in the doubly linked list
    static void addMiddle(int data, int index) {
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
        temp.next.prev = newNode; // Update the previous node of the next node
        newNode.prev = temp;
        temp.next = newNode;
        size++;
    }

    // Function to display the doubly linked list
    static void display() {
        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            System.out.println("Node no " + i + " value is " + temp.data);
            temp = temp.next;
            i++;
        }
        System.out.println("Successfully printed all the doubly linked list");
    }

    // Function to remove the first node from the doubly linked list
    static int removeFirst() {
        if (size == 0) {
            System.out.println("Doubly linked list is empty");
            return 0;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return 0;
        }
        int val = head.data;
        head = head.next;
        head.prev = null; // Remove the reference to the previous node
        size--;
        return val;
    }

    // Function to remove the last node from the doubly linked list
    static int removeLast() {
        if (size == 0) {
            System.out.println("Doubly linked list is empty");
            return 0;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return 0;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null; // Remove the reference to the next node
        size--;
        return val;
    }

    // Function to remove a node at a given index from the doubly linked list
    static int removeMiddle(int index) {
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
        temp.prev.next = temp.next; // Update the next node's previous reference
        temp.next.prev = temp.prev; // Update the previous node's next reference
        size--;
        return val;
    }

    // Function to reverse the doubly linked list
    static void reverseList() {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev; // Swap prev and next references
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node
        }
        if (temp != null) {
            head = temp.prev; // Update the new head
        }
    }

    public static void main(String[] args) {
        addFirst(33);
        addFirst(66);
        addFirst(44);
        addFirst(99);
        addLast(100);
        addLast(101);
        addLast(102);
        addLast(103);
        addMiddle(401, 0);
        addMiddle(501, 1);
        addFirst(444);
        addLast(888);
        display();

        System.out.println(removeFirst());
        System.out.println(removeLast());
        display();
        System.out.println(removeMiddle(1));

        reverseList();
        display();
    }
}









//WITHOUT USING STATIC KEYWORD

public class DoublyLinkedList {
    private int size = 0;
    private Node head;
    private Node tail;

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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

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

    public void display() {
        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            System.out.println("Node no " + i + " value is " + temp.data);
            temp = temp.next;
            i++;
        }
        System.out.println("Successfully printed all the doubly linked list");
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Doubly linked list is empty");
            return 0;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return 0;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Doubly linked list is empty");
            return 0;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return 0;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

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

    public void reverseList() {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
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

