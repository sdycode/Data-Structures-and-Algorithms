package LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.insertAtFirst(10);
        linkedList.insertAtFirst(20);
        linkedList.insertAtFirst(30);
        linkedList.insertAtFirst(40);
        linkedList.display();
        linkedList.insertAtIndex(35, 3);
        linkedList.display();
        linkedList. updateValueAtIndex(63,6);

        linkedList.display();
        linkedList.swapValues(1,3);
        linkedList.display();
        System.out.println(linkedList.find(45));
    }
}
