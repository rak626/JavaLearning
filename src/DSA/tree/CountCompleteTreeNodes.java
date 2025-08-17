package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Count Complete Tree Nodes
 * Link: <a href="https://leetcode.com/problems/count-complete-tree-nodes/description/">Click here</a>
 * Difficulty: Easy
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class CountCompleteTreeNodes {
    // O(N) solution
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    /**
     * let's use property of Complete Binary Tree.
     * <p>
     * <b>Time</b>: O(Log N * Log N) solution
     * At each level of recursion, you calculate height in O(log N).
     * The number of levels you recurse is also O(log N).
     * <p>
     * <b>Space</b>: O(Log N)
     * Due to recursion stack (height of the tree).
     *
     * @param root root of the tree
     * @return integer
     */
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;

        int leftMostHeight = getHeight(root, true);
        int rightMostHeight = getHeight(root, false);

        if (leftMostHeight == rightMostHeight) {
            return (1 << leftMostHeight) - 1; // 2 ^ h - 1, total node of complete binary tree
        }
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

    private int getHeight(TreeNode node, boolean isLeft) {
        int height = 0;
        while (node != null) {
            height++;
            node = isLeft ? node.left : node.right;
        }
        return height;
    }
}
