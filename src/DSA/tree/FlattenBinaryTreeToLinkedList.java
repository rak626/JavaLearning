package DSA.tree;

import DSA.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Flatten Binary Tree To Linked List
 * Link: <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class FlattenBinaryTreeToLinkedList {
    private TreeNode prev = null;

    /**
     * recursive solution
     * tc -> O(N)
     * sc -> O(N), recursive stack space for skewed tree
     * @param node
     */
    public void flatten(TreeNode node) {
        if (node == null) {
            return;
        }
        flatten(node.right);
        flatten(node.left);

        node.right = prev;
        node.left = null;

        prev = node;
    }

    /**
     * stack implementation of that recursive solution
     * tc -> O(N)
     * sc -> O(N)
     */
    public void flatten2(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            if (cur.right != null) {
                st.push(cur.right);
            }
            if (cur.left != null) {
                st.push(cur.left);
            }
            if (!st.isEmpty()) {
                cur.right = st.peek();
            }
            cur.left = null;
        }
    }

    /**
     * morris traversal
     * tc -> O(N)
     * sc -> O(1)
     * @param root
     */
    public void flatten3(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode prev = cur.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = cur.right; // create connection thread
                // fix links of cur
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
