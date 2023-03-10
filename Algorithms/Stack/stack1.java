import java.util.*;

public class stack1 {
    public static void main(String[] args) throws Exception {
        CustomStack customStack = new CustomStack();
        customStack.push(50);
        customStack.push(40);System.out.println(Arrays.toString(customStack.data));
        customStack.push(25);System.out.println(Arrays.toString(customStack.data));


        DynamicStack dynamicStack = new DynamicStack();
        dynamicStack.push(50);
        dynamicStack.push(40);System.out.println(Arrays.toString(dynamicStack.data));
        dynamicStack.push(25);System.out.println(Arrays.toString(dynamicStack.data));
        dynamicStack.push(80);System.out.println(Arrays.toString(dynamicStack.data));
        dynamicStack.push(65);System.out.println(Arrays.toString(dynamicStack.data));
        dynamicStack.push(40);System.out.println(Arrays.toString(dynamicStack.data));
        dynamicStack.push(25);System.out.println(Arrays.toString(dynamicStack.data));

//        Stack<Integer> stack = new Stack();
//        stack.push(5);
//        stack.push(6);
//
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(8);
//        queue.add(5);
//
//        System.out.println(queue.peek());
//        System.out.println(queue.element().toString());
//        queue.add(12);
//        System.out.println(queue.peek());
//        System.out.println(queue.remove());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());


        Deque<Integer> deque = new ArrayDeque<>();
//
//        deque.add(50);
//        System.out.println(deque);
//        deque.addFirst(10);
//        System.out.println(deque);
//        deque.add(40);
//        System.out.println(deque);
//        deque.addLast(60);
//        System.out.println(deque);
//        deque.push(70);
//        System.out.println(deque);
//        deque.addFirst(25);
//        System.out.println(deque);
//
//        System.out.println(deque.pop());
//        System.out.println(deque);
//        System.out.println(deque.remove());
//        System.out.println(deque);
//        System.out.println(deque.removeLast());
//        System.out.println(deque);

    }
}
