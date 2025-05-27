package DSA.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: Binary Tree Inorder Preorder Postorder In One Traversal
 * Link: <a href="https://leetcode.com/problems/binary-tree-inorder-preorder-postorder-in-one-traversal/description/">Click here</a>
 * Difficulty: Easy
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */

class Pair {
    TreeNode node;
    int val;

    public Pair() {
    }

    public Pair(TreeNode node, int val) {
        this.node = node;
        this.val = val;
    }

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}


public class BinaryTreeInorderPreorderPostorderInOneTraversal {
    public void preInPostTraversal(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if (root == null) return;
        while (!st.isEmpty()) {
            Pair popped = st.pop();
            switch (popped.val) {
                case 1: {
                    preorder.add(popped.node.val);
                    popped.val = popped.val + 1;
                    st.push(popped);
                    if (popped.node.left != null) {
                        st.push(new Pair(popped.node.left, 1));
                    }
                    break;
                }
                case 2: {
                    inorder.add(popped.node.val);
                    popped.val = popped.val + 1;
                    st.push(popped);
                    if (popped.node.right != null) {
                        st.push(new Pair(popped.node.right, 1));
                    }
                    break;
                }
                case 3: {
                    postorder.add(popped.node.val);
                }
            }
        }
    }
}
