package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Insert Into A Binary Search Tree
 * Link: <a href="https://leetcode.com/problems/insert-into-a-binary-search-tree/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O(H), Height of the tree
 * Space: O(1)
 */
public class __43__InsertIntoABinarySearchTree {

    // iterative solution
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
        TreeNode node = new TreeNode(val);
        while (cur != null) {
            if (cur.val > val) {
                if (cur.left != null){
                    cur = cur.left;
                } else {
                    cur.left = node;
                }
            } else {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = node;
                }
            }
        }
        return root;
    }

    // recursive solution
    public TreeNode insertIntoBSTRec(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}



