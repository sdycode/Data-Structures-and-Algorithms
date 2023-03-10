package Problems;

import java.util.Stack;

// implement queue using stack
// approach : use 2 stacks ,
// 2 approaches 1 will removal (O(n)) and other is inserting will be O(n)
// 1st : 2 stacks A & B :  we will insert items in stack A, when we want to remove we need to remove
// first element so, we will take elements from stack and will move to stack B and [first element in A]
// will come to top element in B then we will remove that element as it is on top of stack
class QueueUsingStackRemovalInEfficient {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public QueueUsingStackRemovalInEfficient() {
        stackA = new Stack();
        stackB = new Stack();
    }

    public void add(int item) {
        stackA.add(item);

    }

    public int peek() {
        while (!stackA.isEmpty()) {
            stackB.add(stackA.pop());
        }
        int peekded = stackB.peek();
        while (!stackB.isEmpty()) {
            stackA.add(stackB.pop());
        }
        return peekded;
    }

    public int remove() {
        while (!stackA.isEmpty()) {
            stackB.add(stackA.pop());
        }
        int removed = stackB.pop();
        while (!stackB.isEmpty()) {
            stackA.add(stackB.pop());
        }
        return removed;
    }

}


// Approach 2

class QueueUsingStackAddingInEfficient {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public QueueUsingStackAddingInEfficient() {
        stackA = new Stack();
        stackB = new Stack();
    }

    public void add(int item) {

//        First we wll move elements from stackA to B
        while (!stackA.isEmpty()) {
            stackB.add(stackA.pop());
        }

        stackA.add(item);
// move elements from stackB on top of stackA

        while (!stackB.isEmpty()) {
            stackA.add(stackB.pop());
        }



    }

    public int peek() {
        return stackA.peek();
    }

    public int remove() {

        return stackA.pop();
    }

}
