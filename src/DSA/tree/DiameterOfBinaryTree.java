package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Diameter Of Binary Tree
 * Link: <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">Click here</a>
 * Difficulty: Easy
 * Tags: Tree
 * <p>
 * Approach:
 * 1. used to found height of BT (dfs)
 * 2. pass the maxLen to track all over the height,
 * -
 * <p>
 * Time: O(N)
 * Space: O(N)
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxLen = new int[1];
        dfs(root, maxLen);
        return maxLen[0];
    }

    private int dfs(TreeNode root, int[] maxLen) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, maxLen);
        int right = dfs(root.right, maxLen);
        maxLen[0] = Math.max(maxLen[0], left + right);
        return 1 + Math.max(left, right);
    }
}
