package LinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertAtFirst(int val) {
        if (size == 0) {
            head = new Node(val);
            size++;
            tail = head;
            return;
        }
        Node temp = new Node(val);
        temp.next = head;
        head.prev = temp;
        head = temp;
        size++;
    }

    public void insertAtLast(int val) {
        Node temp = new Node(val);
        tail.next = temp;
        temp.prev = tail;
        size++;
    }

    public void insertAtIndex(int val, int index) throws Exception {
        if (index == 0) {
            insertAtFirst(val);
            return;
        }
        if (index == size) {
            insertAtLast(val);
            return;
        }
        if (index >= size) {
            throw new Exception("Index is out of limit");
        }
        Node node = get(index);

        Node newnode = new Node(val);
        newnode.prev = node.prev;
        newnode.next = node;
        node.prev.next = newnode;
        size++;

    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void updateValueAtIndex(int value, int index) {
        if (index == size) {
            tail.value = value;
        }
        Node temp = head;
        if (index < size) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.value = value;
        }
    }

    public void swapValues(int i, int j) {
        int val=4;
        if (i < j) {
            val = get(j).value;
        }
        Node node = head;
        int iValue=4;

        for (int k = 0; k < Math.max(i, j)+1; k++) {
            if (k == i) {
                iValue = node.value;
                System.out.println("ival "+iValue);
                node.value =val;
            }
            if(k==j){
                node.value =iValue;
            }
            node = node.next;

        }
    }

    public Node find(int val){
        Node node = head;
        for (int i = 0; i < size; i++) {
            if(node.value==val){
                return  node;
            }
            node = node.next;
        }
        return  null;
    }
    public void display() {
        Node node = head;
        for (int i = 0; i < size; i++) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("END");
        System.out.println();
    }

}


