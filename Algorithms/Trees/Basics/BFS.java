package Trees.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        TreeNode root = DefaultTree.getDefaultTree();
        bfsTraversalUsingQueue(root);
    }

    private static void bfsTraversalUsingQueue(TreeNode root) {
        // Approach is get root and it to queue
        // Start while loop until queue becomes empty.
        // Then for run for loop for queue size
        // For each value in queue add left and right value to existing queue (if not null)
        // After adding left and right remove front element from queue and add it to sublist
        // After for loop over, add sublist to main outer list
        // Each sublist represent 1 level in tree
        // .
        // and .
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
            System.out.println(sublist);
        }
    }
}
