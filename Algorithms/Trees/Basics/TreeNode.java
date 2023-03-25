package Trees.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

/*
 Traversal 2 types
    1. BFS : Breadth First Search
    2. DFS : Depth First Search
 */
class DefaultTree {
    public static void main(String[] args) {
        TreeNode root = getBiggerDefaultTree();
        showTreeUsingBFS(root);
    }

    public static TreeNode getDefaultTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static TreeNode getBiggerDefaultTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        return root;
    }



    public static void showTreeUsingBFS(TreeNode root) {
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> sublist = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {

                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                // Now remove front element and add to subllist

                sublist.add(queue.poll().value);
            }

            list.add(sublist);
            max = Math.max(max, sublist.size());
            System.out.println(sublist);
        }
        System.out.println("size " + max);
        for (int i = 0; i < list.size(); i++) {
            String repeated = new String(new char[max/2 - list.get(i).size()/2]).replace("\0", "   ");

            System.out.print(repeated);
            for (int j = 0; j < list.get(i).size(); j++) {
                if(list.get(i).get(j)>9){
                    System.out.print(list.get(i).get(j)+" "  );
                }else{
                    System.out.print(list.get(i).get(j)+"  ");
                }

                if (j + 1 == list.get(i).size() / 2) {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }
}
