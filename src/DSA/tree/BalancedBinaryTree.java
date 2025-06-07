package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Balanced Binary Tree
 * Link: <a href="https://leetcode.com/problems/balanced-binary-tree/description/">Click here</a>
 * Difficulty: Easy
 * Tags: tree
 * <p>
 * Approach: find the height of binary tree, while doing the check any side is not balanced or not,
 * if yes return -1
 * if -1 found on return then return this -1 ( means we found tree is not balanced )
 * -
 * <p>
 * Time: O(N)
 * Space: O(N)
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
