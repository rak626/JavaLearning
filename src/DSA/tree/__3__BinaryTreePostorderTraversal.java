package DSA.tree;

import DSA.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: Binary Tree Postorder Traversal
 * Link: <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/description/">Click here</a>
 * Difficulty: Easy
 * Tags: Tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class __3__BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
//        postorderTraversalRecursive(root, result);
        postorderTraversalIterative(root, result);
        return result;

    }

    private static void postorderTraversalIterative(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp != null) {
                    cur = temp;
                } else {
                    TreeNode popOut = st.pop();
                    result.add(popOut.val);
                    while (!st.isEmpty() && popOut == st.peek().right) {
                        popOut = st.pop();
                        result.add(popOut.val);
                    }
                }
            }

        }
    }

    private static void postorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursive(root.left, result);
        postorderTraversalRecursive(root.right, result);
        result.add(root.val);
    }
}
