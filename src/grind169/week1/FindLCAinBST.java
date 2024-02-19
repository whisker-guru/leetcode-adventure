package grind169.week1;

public class FindLCAinBST {
    /*
     *  Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
     *
     *  Test Cases:
     *    See the problem link
     *
     *  Time Complexity:
     *    In the worst-case scenario, it's O(n), where n is the number of nodes in the tree.
     *    In a balanced BST, the time complexity is O(log(n)), but in an unbalanced tree, it can be as high as O(n).
     *  Space Complexity:
     *    In the worst-case scenario, it's also O(n) due to recursive calls. In a balanced tree, it's O(log(n)).
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else
                return root;
        }
    }

    class CorrectButComplexSolution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int low = p.val < q.val ? p.val : q.val;
            int high = p.val > q.val ? p.val : q.val;
            return lowestCommonAncestorHelper(root, low, high);
        }

        public TreeNode lowestCommonAncestorHelper(TreeNode root, int low, int high) {
            if (root == null) return null;
            if (low <= root.val && root.val <= high) {
                return root;
            } else if (low < root.val && high < root.val) {
                return lowestCommonAncestorHelper(root.left, low, high);
            } else {
                return lowestCommonAncestorHelper(root.right, low, high);
            }
        }
    }

    class FailedSolution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            // Cannot assume p is necessarily less than q; the prompt only states p is not equal to q.
            if (p.val <= root.val && q.val >= root.val) {
                return root;
            } else if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

