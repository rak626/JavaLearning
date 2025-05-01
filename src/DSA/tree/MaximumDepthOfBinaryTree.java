package DSA.tree;

/**
 * Problem: Maximum Depth Of Binary Tree
 * Link: <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">Click here</a>
 * Difficulty: Easy
 * Tags: Tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
