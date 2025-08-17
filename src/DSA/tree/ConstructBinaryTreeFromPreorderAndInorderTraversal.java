package DSA.tree;

import DSA.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Construct Binary Tree From Preorder And Inorder Traversal
 * Link: <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * <ol>
 *   <li>Use a global index or pointer (preIndex) to track where we are in the preorder array.</li>
 *   <li>Take preorder[preIndex] as root.</li>
 *   <li>Find that value in the inorder array to split left/right subtree.</li>
 *   <li>Recurse on the left and right subtrees.</li>
 * </ol>
 *
 * Time: O(N) Each node is visited once, and map lookup is O(1).<br>
 * Space: O(N) For hashmap & recursion stack (up to depth N in worst case)
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preIndex = 0;
    private final Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a map of value -> index for quick lookup in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Start recursive construction
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        // Base case: no elements to construct
        if (inStart > inEnd) return null;

        // Step 1: Pick root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Step 2: Find the index of root in inorder array
        int inIndex = inorderMap.get(rootVal);

        // Step 3: Recursively build left and right subtree
        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);

        return root;
    }

}
