package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Validate Binary Search Tree
 * Link: <a href="https://leetcode.com/problems/validate-binary-search-tree/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * Validates whether a given binary tree is a Binary Search Tree (BST).
 * A valid BST must satisfy the property:
 * for every node, all values in the left subtree are less than the node's value,
 * and all values in the right subtree are greater.
 *
 * <p><b>Approach & Intuition:</b></p>
 * <ol>
 *   <li><b>Brute-force:</b> For every node, check the max value in the left subtree
 *       and min value in the right subtree recursively.
 *       <br>Time: O(n²) because each node may traverse subtrees repeatedly.</li>
 *
 *   <li><b>Better:</b> Perform an in-order traversal, store all node values in a list,
 *       then verify that the list is strictly increasing.
 *       <br>Time: O(n), Space: O(n)</li>
 *
 *   <li><b>Optimized (This solution):</b> Use a top-down recursive approach with min and max bounds.
 *       For each node, ensure its value lies within valid limits.
 *       Pass updated limits down to left and right subtrees.
 *       <br>Time: O(n), Space: O(h)</li>
 * </ol>
 *
 *
 * <p><b>Time Complexity:</b> O(n)
 * <br>Each node is visited exactly once.</p>
 *
 * <p><b>Space Complexity:</b> O(h)
 * <br>Due to recursion stack where h is the height of the tree.
 * O(log n) for balanced trees, O(n) for skewed trees.</p>
 */
public class __46__ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;
        return (node.val > minValue && node.val < maxValue) && isValidBSTHelper(node.left, minValue, node.val) && isValidBSTHelper(node.right, node.val, maxValue);
    }
}
