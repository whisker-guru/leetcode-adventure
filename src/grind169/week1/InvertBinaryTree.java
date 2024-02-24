package grind169.week1;

import java.sql.Time;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    /*
     *  Problem: https://leetcode.com/problems/invert-binary-tree/description/
     *
     *  Test Cases:
     *    See the problem link
     */

    class RecursiveSolution {
        /*
         * Time Complexity:
         *   Each node is visited only once, so the time complexity of the recursive solution is O(n), where n is the number of nodes in the binary tree.
         * Space Complexity:
         *    As it involves recursive calls, it needs to maintain a recursive call stack.
         *    In the worst case, the height of the binary tree could be O(n), so the space complexity of the recursive solution is O(n).
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;
            TreeNode tmp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
            return root;
        }
    }

    class IterativeSolution {
        /*
         * Time Complexity:
         *   This iterative solution uses BFS (Breadth-First Search) to traverse all nodes of the binary tree.
         *   Therefore, the time complexity is also O(n), where n is the number of nodes in the binary tree.
         * Space Complexity:
         *    This iterative solution uses a queue to process nodes.
         *    In the worst case, the queue may contain all nodes of the binary tree, so the space complexity is also O(n).
         */
        public TreeNode invertTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
                TreeNode tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;
            }
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

