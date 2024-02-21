package grind169.week1;

import java.sql.Time;

public class BalancedBinaryTree {
    /*
     *  Problem: https://leetcode.com/problems/balanced-binary-tree/description/
     *  Solution Explanation:
     *    https://leetcode.com/problems/balanced-binary-tree/solutions/2428871/very-easy-100-fully-explained-c-java-python-javascript-python3
     *  Test Cases:
     *    See the problem link.
     */
    class Solution {
        /*
         *  Time Complexity:
         *    In the best case scenario where the tree is balanced, each node is visited once, and each call to getHeight takes constant time O(1).
         *    Therefore, the time complexity in the best case is O(n).
         *    In the worst case scenario where the tree is highly unbalanced, the recursion will still visit each node once,
         *    resulting in a time complexity of O(n).
         *
         *  Space Complexity:
         *    In the best case scenario of a balanced tree, the maximum recursion depth is O(log n) since the tree's height is logarithmic.
         *    Therefore, the space complexity in the best case is O(log n).
         *    In the worst case scenario of a highly unbalanced tree, the recursion depth could be as deep as the number of nodes in the tree,
         *    leading to a space complexity of O(n).
         */
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != Integer.MIN_VALUE;
        }

        int getHeight(TreeNode root) {
            if (root == null) return -1;
            int leftHeight = getHeight(root.left);
            if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            int rightHeight = getHeight(root.right);
            if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return Integer.MIN_VALUE;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }

    class CorrectButSlowSolution {
        /*
         *  Time Complexity:
         *    Best Case (Balanced Tree): In a balanced binary tree, the height of the tree is O(log n).
         *      Therefore, for each of the n nodes, the isBalanced function takes O(log n) time to compute the height difference,
         *      resulting in a total time complexity of O(n * log n).
         *    Worst Case (Highly Unbalanced Tree):
         *      In the worst-case scenario where the binary tree is highly unbalanced， the height of the tree is O(n).
         *      In this case, for each of the n nodes, the isBalanced function takes O(n) time to compute the height difference,
         *      resulting in a total time complexity of O(n^2).
         *  Space Complexity:
         *    Best Case (Balanced Tree):
         *      In a balanced binary tree, the maximum recursion depth of the isBalanced function is determined by the height of the tree,
         *      which is O(log n). This results in a space complexity of O(log n) because the space used on the system stack is proportional
         *      to the height of the tree.
         *    Worst Case (Highly Unbalanced Tree):
         *      In the worst-case scenario where the binary tree is highly unbalanced, the maximum recursion depth of the isBalanced
         *      function can be O(n). This occurs when the tree resembles a linked list. In such a case, the space complexity would be O(n)
         *      because the height of the system stack would grow linearly with the number of nodes in the tree.
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int heightDiff = getHeight(root.left) - getHeight(root.right);
            if (Math.abs(heightDiff) > 1) {
                return false;
            } else {
                return isBalanced(root.left) && isBalanced(root.right);
            }
        }

        int getHeight(TreeNode root) {
            if (root == null) return 0;
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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

