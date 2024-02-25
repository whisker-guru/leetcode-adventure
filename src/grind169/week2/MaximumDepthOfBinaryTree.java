package grind169.week2;

import java.sql.Time;

public class MaximumDepthOfBinaryTree {
    /*
     *  Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
     *
     *  Test Cases:
     *    See the problem link
     */

    class Solution {
     /*
      * Time Complexity:
      *   The time complexity of this solution is O(n), where n is the number of nodes in the binary tree. This is because
      *   the function recursively visits each node exactly once, and for each node, it performs constant-time operations
      *   (checking if the node is null and performing the Math.max() operation).
      * Space Complexity:
      *   The space complexity of this solution is O(h), where h is the height of the binary tree. This is because the
      *   recursion depth can go as deep as the height of the binary tree. In the worst-case scenario, when the binary tree
      *   is skewed (i.e., it resembles a linked list), the height of the tree becomes equal to the number of nodes,
      *   resulting in O(n) space complexity. However, in a balanced binary tree, the height is logarithmic in terms of the
      *   number of nodes, resulting in O(log n) space complexity.
      *
      */
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

