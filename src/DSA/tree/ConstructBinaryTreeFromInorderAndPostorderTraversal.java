package DSA.tree;

import DSA.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Construct Binary Tree From Inorder And Postorder Traversal
 * Link: <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 *
 * Approach:
 * <ol>
 *   <li>Use a global index (postIndex) starting from the end of the postorder array.</li>
 *   <li>Take postorder[postIndex] as root and decrement postIndex.</li>
 *   <li>Find the root's index in the inorder array using a HashMap.</li>
 *   <li>Recurse on the right subtree first, then the left subtree.</li>
 * </ol>
 *
 * Time: O(N) – Each node is visited once, and map lookups are O(1).<br>
 * Space: O(N) – For the HashMap and recursion stack (tree depth in worst case).
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int postIndex;
    private final Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        // Build a map of value -> index from inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Step 1: Pick current root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Step 2: Find index of root in inorder to split subtrees
        int inIndex = inorderMap.get(rootVal);

        // Step 3: Recurse right subtree first, then left
        /*
         * Why Recurse Right First?
         * <p>
         * In postorder traversal: <strong>[left, right, root]</strong><br>
         * When traversing backward (from end to start), the order becomes: <strong>root, right, left</strong><br>
         * Therefore, when building the tree from postorder and inorder traversals,
         * we must construct the <strong>right subtree first</strong>, then the left subtree.
         */
        root.right = build(postorder, inIndex + 1, inEnd);
        root.left = build(postorder, inStart, inIndex - 1);

        return root;
    }
}



