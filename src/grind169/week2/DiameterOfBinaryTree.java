package grind169.week2;

public class DiameterOfBinaryTree {
    /*
     *  Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
     *  Solution Explanation:
     *     https://leetcode.com/problems/diameter-of-binary-tree/solutions/1039281/3-java-solutions-with-explanation-o-n-100-fast
     *  Test Cases:
     *     See the problem link
     */

    class Solution {
        private int ret;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            getHeight(root);
            return ret;
        }

        private int getHeight(TreeNode root) {
            if (root == null) return 0;
            int leftLen = getHeight(root.left);
            int rightLen = getHeight(root.right);
            int currDiameter = leftLen + rightLen;
            ret = Math.max(currDiameter, ret);
            return Math.max(leftLen, rightLen) + 1;
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

