package Trees.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = DefaultTree.getDefaultTree();


        preOrderTraversal(root);
        preOrderTraversalIterativeusingStack(root);
    }

    private static void preOrderTraversalIterativeusingStack(TreeNode root) {
        // Approach is add root in stack
        // Run while loop untill stack gets empty
        // remove top element (and add that top element to our list)
        // Add right and then left node of (Top element of stack) in stack
        // .
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.value);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            System.out.println(list);
        }
    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
