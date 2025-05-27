package DSA.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: Binary Tree Inorder Traversal
 * Link: <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/">Click here</a>
 * Difficulty: Easy
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalIterative(root, result);
        inorderTraversalRecursive(root, result);
        return result;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversalRecursive(root.left, result);
        result.add(root.val);
        inorderTraversalRecursive(root.right, result);
    }

    private void inorderTraversalIterative(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                cur = st.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
    }
}
