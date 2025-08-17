package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Search In A Binary Search Tree
 * Link: <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/description/">Click here</a>
 * Difficulty: Easy
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O(logN)
 * Space: O(1)
 */
public class __40__SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            }
            if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }
}
