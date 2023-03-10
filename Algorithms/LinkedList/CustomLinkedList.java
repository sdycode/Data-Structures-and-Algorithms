package LinkedList;

public class CustomLinkedList {


    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertAtFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;

    }

    public void insertAtLast(int val) {
        if (tail == null) {
            insertAtFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int val, int index) {
        if (index == 0) {
            insertAtFirst(val);
            return;
        }
        if (index == size) {
            insertAtLast(val);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertWithRecursion(int value, int index) {
        head = insertAtIndex(value, index, head);
    }

    public Node insertAtIndex(int value, int index, Node headNode) {
        if (index == 0) {
            Node node = new Node(value, headNode);
            size++;
            return node;

        }
        headNode.next = insertAtIndex(value, index - 1, headNode);
        return headNode;
    }

    public int deleteFirst() {
        int deletedValue = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return deletedValue;
    }

    public int deleteLast() {
        int deletedvalue = tail.value;
        if (size <= 1) {
            tail = null;
            head = null;
        }
        Node secondLast = get(size - 2);
        tail = secondLast;
        secondLast.next = null;
        return deletedvalue;
    }

    public int deleteAtIndex(int index) {
        if (index == 0) {
            int v = head.value;
            deleteFirst();
            return v;
        }
        if (index == size - 1) {
            int v = tail.value;
            deleteLast();
            return v;
        }

        Node prevNode = get(index - 1);
        int deletedValue = prevNode.next.value;

        prevNode.next = prevNode.next.next;

        return deletedValue;

    }

    public Node findNodeForValue(int val) {
        Node temp = head;
        if (temp.value == val) {
            return temp;
        }
        while (temp != null) {
            if (temp.value == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public void displayLinkedList() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            System.out.print(temp.value + " ");
        }
    }

}
