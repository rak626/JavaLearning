package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Symmetric Tree
 * Link: <a href="https://leetcode.com/problems/symmetric-tree/description/">Click here</a>
 * Difficulty: Easy
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTree(root.left, root.right);
    }

    private boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return (p.val == q.val) && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }

}
