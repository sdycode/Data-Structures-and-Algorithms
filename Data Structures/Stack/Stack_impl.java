import java.util.*;
import java.util.Scanner;

public class Stack_impl {

    int n;
    int a[];
    int top; // Here top is index of top element of stack

    Stack_impl(int n) {
        this.n = n;
        this.a = new int[n];
        this.top = -1; // Assumed empty stack has top = -1
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else
            return false;
    }

    public boolean isFull() {
        if (top == n - 1) {
            return true;
        } else
            return false;
    }

    public void push(int element) {
        if (!isFull()) {
            top++;
            a[top] = element;
        } else {
            System.out.println("stack is full");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            System.out.println(a[returnedTop]);
            return a[returnedTop];
        } else {
            System.out.println(" stack is empty -1");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return a[top];
        } else
            return -1;
    }

    public static void main(String[] args) {
        Stack_impl stack_obj = new Stack_impl(20);

        stack_obj.pop();

    }

}
