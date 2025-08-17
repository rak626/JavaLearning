package DSA.tree;

import DSA.utils.Pair;
import DSA.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class __4__BinaryTreeInorderPreorderPostorderInOneTraversal {
    public void preInPostTraversal(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        st.push(new Pair<>(root, 1));
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if (root == null) return;
        while (!st.isEmpty()) {
            Pair<TreeNode, Integer> popped = st.pop();
            switch (popped.second) {
                case 1: {
                    preorder.add(popped.first.val);
                    popped.second = popped.second + 1;
                    st.push(popped);
                    if (popped.first.left != null) {
                        st.push(new Pair<>(popped.first.left, 1));
                    }
                    break;
                }
                case 2: {
                    inorder.add(popped.first.val);
                    popped.second = popped.second + 1;
                    st.push(popped);
                    if (popped.first.right != null) {
                        st.push(new Pair<>(popped.first.right, 1));
                    }
                    break;
                }
                case 3: {
                    postorder.add(popped.first.val);
                }
            }
        }
    }
}
