package LinkedList;

public class CircularLinkedList {
    int size;
    Node head;
    Node tail;

    CircularLinkedList() {
        this.size = 0;

    }


    public void insertAfterTail(int val) {
        Node node = new Node(val);
        size++;
        if (head == null) {
            head = node;
            tail = node;
        }
        node.next = head;
        tail.next = node;
        tail = node;
    }

    public void insertAfterIndex(int index, int val) {
        if (index >= size) {
            return;
        }
        Node node = head;
        Node nextNode = head;
        for (int i = 0; i < index; i++) {
            node = node.next;


        }
        size++;
        nextNode = node.next;

        Node newNode = new Node(val);
        node.next = newNode;


        newNode.next = nextNode;

    }

    public void display() {
        Node temp = head;
        int count = 0;
        while (count < size) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
            count++;
        }
        System.out.println();
    }


    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
