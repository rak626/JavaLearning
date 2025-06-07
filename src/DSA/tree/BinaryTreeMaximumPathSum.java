package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Binary Tree Maximum Path Sum
 * Link: <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/description/">Click here</a>
 * Difficulty: Hard
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        dfs(root, maxSum);
        return maxSum[0];
    }

    private int dfs(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int maxL = dfs(root.left, maxSum);
        if (maxL <= 0) maxL = 0;
        int maxR = dfs(root.right, maxSum);
        if (maxR <= 0) maxR = 0;
        maxSum[0] = Math.max(maxSum[0], maxL + maxR + root.val);
        return root.val + Math.max(maxL, maxR);
    }
}
