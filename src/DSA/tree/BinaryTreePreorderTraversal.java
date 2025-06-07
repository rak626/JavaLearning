package DSA.tree;

import DSA.utils.TreeNode;

import java.util.*;

/**
 * Problem: Binary Tree Preorder Traversal
 * Link: <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/description/">Click here</a>
 * Difficulty: Easy
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecursive(root, result);
        preorderTraversalIterative(root, result);
        preorderTraversalIterativeAnotherImpl(root, result);
        return result;
    }

    private void preorderTraversalIterative(TreeNode root, List<Integer> result) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            result.add(cur.val);
            if (cur.right != null) {
                st.push(cur.right);
            }
            if (cur.left != null) {
                st.push(cur.left);
            }
        }
    }

    private void preorderTraversalIterativeAnotherImpl(TreeNode root, List<Integer> result) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                result.add(cur.val);
                st.add(cur);
                cur = cur.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                cur = st.pop().right;
            }
        }
    }

    private void preorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorderTraversalRecursive(root.left, result);
        preorderTraversalRecursive(root.right, result);
    }

}
