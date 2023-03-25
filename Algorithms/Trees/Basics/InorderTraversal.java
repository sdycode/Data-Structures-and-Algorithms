package Trees.Basics;

import java.util.*;

public class InorderTraversal {

    public static void main(String[] args) {

        TreeNode root = DefaultTree.getDefaultTree();
        inOrderTraverse(root);
        inOrderTraverseIterativeusingStack(root);
    }

    private static void inOrderTraverseIterativeusingStack(TreeNode root) {
        // Approach is  .
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            // add node if node is not null and go to left node
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                list.add(node.value);
                System.out.println(list);
                node = node.right;
            }
        }

    }

    private static void inOrderTraverse(TreeNode root) {

        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        System.out.print(root.value + " ");
        inOrderTraverse(root.right);
    }
}
