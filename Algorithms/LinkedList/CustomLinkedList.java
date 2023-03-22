package LinkedList;

public class CustomLinkedList {


    public Node head;
    public Node tail;
    public int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        int getValue() {
            return this.value;
        }
    }


    public void removeDuplicates() {

        Node temp = head;

        while (temp.next != null) {
            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;

            }
        }
        tail = temp;
        tail.next = null;
    }

    public void removeDupliicatesFromUnsortedList() {
        Node inner = null;
        Node outer = head;
        while (outer != null && outer.next != null) {
            inner = outer;
            while (inner.next != null) {
                if (outer.value == inner.next.value) {
                    inner.next = inner.next.next;
                    size--;
                } else {
                    inner = inner.next;

                }
            }
            outer = outer.next;
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

    public void insertAtIndexTry1(int value, int index) {
        Node temp = head;
        if (index == 0) {
            insertAtFirst(value);
            return;
        }
        if (index == size) {
            insertAtLast(value);
            return;
        }
        for (int i = 0; i < index; i++) {
            if (i + 1 == index) {
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
                size++;

            } else {
                temp = temp.next;

            }

        }
    }

    public void insertWithRecTry1(int value, int index) {
        insertAtIndexWithActualRecursionTry1(value, index, head);
    }

    private void insertAtIndexWithActualRecursionTry1(int value, int index, Node node) {
        if (index == 0) {
            insertAtFirst(value);
            return;
        }
        if (index == size) {
            insertAtLast(value);
            return;
        }
        if (index == 1) {
            System.out.println("node @ " + index + "  " + node.value);
            Node newNode = new Node(value);
            newNode.next = node.next;
            node.next = newNode;
            size++;

            return;
        }

        insertAtIndexWithActualRecursionTry1(value, index - 1, node.next);
    }

    /*
     Node dummyHead =new Node();
        Node tail = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                tail = tail.next;
                list1= list1.next;
            }else{
                 tail.next = list2;
                tail = tail.next;
                list2= list2.next;
            }
            tail.next = list1 != null ? list1:list2;

        } return dummyHead.next;

     */
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
//        System.out.println("disp "+head.value);
////        using  size value
//
//        for (int i = 0; i < size; i++) {
//            System.out.print(temp.value + " ");
//            temp = temp.next;
//        }
//        System.out.println();


//        using while loop

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();

    }


    public static CustomLinkedList moveLastElementTo1st(CustomLinkedList l) {
        Node node = l.head;
        if (node == null) {
            return l;
        }
        while (node != null) {
            if (node.next.next == null) {
                Node tail = node.next;
                node.next = null;
                l.insertAtFirst(tail.value);
                return l;
            }
            node = node.next;
        }
        return l;
    }

    public Node sortLinkedListWithMergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        Node left = sortLinkedListWithMergeSort(head);
        Node right = sortLinkedListWithMergeSort(slow);
        return mergeTwoLists(left, right);

    }


    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.value < list2.value) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    private Node getMid(Node head) {
        Node s = head;
        Node f = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    public Node merge2SortedListRecursion(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.value < n2.value) {
            n1.next = merge2SortedListRecursion(n1.next, n2);
            return n1;
        } else {
            n1.next = merge2SortedListRecursion(n1.next, n2);
            return n1;

        }


    }

    public boolean isCyclic(Node headNode, int pos) {
        Node posNode = headNode;
        int count = 0;
        if (posNode.next == null) {
            return false;
        }
        if (posNode.next.next == headNode) {
            return true;
        }
        Node temp = headNode;
        while (temp != null) {
            count++;
            System.out.println("temp " + temp.value + "  " + count + "  pos" + pos);
            if (count == pos) {
                posNode = temp.next;
            }
            if (posNode == temp && count > pos + 1) {
                System.out.println("it is true " + posNode.value + " " + temp.value + " " + posNode + " " + temp);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    public boolean isCyclicUsingSlowFastPointer(Node head) {
        Node slow = head;
        Node fast = head;
        if (head.next == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int lengthOFCycle(Node head) {
//        Approach is when s and fast are equal then move slow pointer (and fast will be at same position)
//        until it comes again to fast and count the stepes
        int count = 0;
        boolean startCounting = false;
        Node slow = head;
        Node fast = head;
        if (head.next == null) {
            return 0;
        }
        while (fast != null && fast.next != null) {
            if (startCounting) {
                count++;
                if (slow == fast) {
                    return count;
                }
                slow = slow.next;
            } else {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    System.out.println("started @ " + slow.value);
                    startCounting = true;
                    slow = slow.next;
                }
            }
        }
        return 0;
    }

    public static Node getJunctionNodeInCycle(Node head) {
        int count = 0;
        boolean startCounting = false;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            if (startCounting) {
                count++;
                if (slow == fast) {
                    break;
                }
                slow = slow.next;
            } else {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    System.out.println("started @ " + slow.value);
                    startCounting = true;
                    slow = slow.next;
                }
            }
        }
        System.out.println("l is " + count);
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < count; i++) {
            p2 = p2.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;

        }
        System.out.println("juncion is " + p1.value);
        return p1;
    }

    public static int lengthOfCycleUsingRecursion(Node head) {
        int len = 0;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                len = lengthOfCycleUsingRecursion(slow.next);
                break;
            }
        }
        return len;
    }

    public static CustomLinkedList merge2SortedLList(CustomLinkedList l1, CustomLinkedList l2) {
        Node f = l1.head;
        Node s = l2.head;
        CustomLinkedList list = new CustomLinkedList();
//      First we will traverse through both list until one of them becomes emoty
        while (f != null && s != null) {
            if (f.value < s.value) {
                list.insertAtLast(f.value);
                f = f.next;
            } else {
                list.insertAtLast(s.value);
                s = s.next;
            }
        }

//        Now traverse throuh remeaining part of incomplete list
        while (f != null) {
            list.insertAtLast(f.value);
            f = f.next;
        }
        while (s != null) {
            list.insertAtLast(s.value);
            s = s.next;
        }
        return list;
    }

    public void reversLLWithRecur(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reversLLWithRecur(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public Node reversePartOfLinkedListWithPositions(Node head, int left, int right) {

        if (left == right) {
            return head;
        }
        Node prev = null;
        Node current = head;
        //  Here we will get new current (start of part of LL to be reversed) and prev which will be end of left part
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;
        // reverse between l and right
        Node next = current.next;

        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }


        }
    // Here prev will be new head of reversed part LL and current will be head of ( right part of  reversed part i.e end part )
        if (last != null) {
            last.next = prev;

        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

    public void reversePartOfLinkedList(Node node, int l, int r) {
        Node ltail = null;
        Node nHead = null;
        Node rHead = null;
        Node t = node;
        while (t != null) {
            if (t.next.value == l) {
                ltail = t;
                nHead = ltail.next;
            }
            if (t.value == r) {
                rHead = t.next;
                t.next = null;
            }
            t = t.next;
        }
        ltail.next = null;

        // show left list
        nHead = reversLLWithHeadIteration(nHead);
        System.out.println("left");
        showList(head);
        // show middle
        System.out.println("midddle");
        showList(nHead);
        System.out.println("right");
        // show right
        showList(rHead);

        ltail.next = nHead;
        Node tt = nHead;
        while (tt != null) {

            if (tt.next == null) {
                tt.next = rHead;
                break;
            }
            tt = tt.next;
        }
        System.out.println("final ");
        showList(node);
        head = node;
    }

    public void showList(Node head) {
        Node t = head;
        while (t != null) {
            System.out.print(t.value + " ");
            t = t.next;
        }
        System.out.println();
    }

    public Node reversLLWithHeadIteration(Node headNode) {
        Node prev = null;
        Node present = headNode;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
        return prev;
    }

    public boolean isPalindromeLinkedList(Node headnode) {
        Node startHead = headnode;
        Node mid = getMid(headnode);
        Node secondHead = reversLLWithHeadIteration(mid);

        // Now compare each element with second part

        Node rereverseHead = secondHead;
        while (headnode != null && secondHead != null) {
            if (headnode.value != secondHead.value) {
                break;
//                return false;
            }
            headnode = headnode.next;
            secondHead = secondHead.next;
        }

        reversLLWithHeadIteration(rereverseHead);

        head = startHead;
        if (headnode == null || secondHead == null) return true;
        return false;
    }

    public void reorderLinkedList(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node mid = getMid(head);
        Node hf = head;
        Node hs = reversLLWithHeadIteration(mid);

        while (hf != null && hs != null) {
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;
//
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if (hf != null) {
            hf.next = null;

        }
    }

    public static void main(String[] args) {
        CustomLinkedList list1 = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();
        list1.insertAtLast(1);
        list1.insertAtLast(8);
        list1.insertAtLast(4);
        list1.insertAtLast(2);
        list1.insertAtLast(5);

        list1.insertAtLast(12);
        list1.insertAtLast(43);

//        list1.tail.next = list1.get(3);
//

        list2.insertAtLast(3);
        list2.insertAtLast(4);
        list2.insertAtLast(6);
//        list2.insertAtLast(4);
        list2.insertAtLast(4);
        list2.insertAtLast(3);
//        list2.displayLinkedList();
//        System.out.println(list2.isPalindromeLinkedList(list2.head));
//        list1.reversePartOfLinkedList(list1.head, 4, 5);
//        list2.displayLinkedList();
//        Node n = list1.sortLinkedListWithMergeSort(list1.head);
//        list1.displayLinkedList();
        list1.reorderLinkedList(list1.head);
//        while (n != null) {
//            n = n.next;
//        }
//
//        System.out.println(list1.getJunctionNodeInCycle(list1.head));


//       CustomLinkedList ans = CustomLinkedList.merge2SortedLList(list1, list2);
//        ans.displayLinkedList();
    }

}
