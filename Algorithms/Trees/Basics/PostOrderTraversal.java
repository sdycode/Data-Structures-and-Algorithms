package Trees.Basics;

import java.util.*;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = DefaultTree.getBiggerDefaultTree();

//        postOrderTraversal(root);
        postOrderTraversalIterative2Stacks(root);
        postOrderTraversalIterative1Stack(root);
        DefaultTree.showTreeUsingBFS(root);


    }

    private static void postOrderTraversalIterative1Stack(TreeNode root) {
    }

    private static void postOrderTraversalIterative2Stacks(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return;
        // Fill s2 in reverse order of our required ans
        s1.add(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.add(root);
            if (root.left != null) s1.push(root.left);
            if (root.right != null) s1.push(root.right);
            System.out.print("s1 ");
            ShowStack.showStack(s1);
            System.out.println();
        }
        System.out.println();
        while (!s2.isEmpty()) {
            list.add(s2.pop().value);
//            System.out.println(list);
        }
        System.out.println(list);

    }

    private static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }
}
