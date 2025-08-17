package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Kth Smallest Element In A Bst
 * Link: <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Finds the kth smallest element in a Binary Search Tree (BST).
 *
 * <p><b>Approach:</b>
 * <ol>
 *   <li><b>Brute-force:</b> Perform an in-order traversal, store all elements in a list,
 *       and return the k-1th element.
 *       <i>Time:</i> O(n), <i>Space:</i> O(n)</li>
 *
 *   <li><b>Better:</b> Perform in-order traversal with a counter, and stop once the kth node is reached.
 *       Avoid storing all elements.</li>
 *
 *   <li><b>Optimized (This version):</b>
 *       Recursive in-order traversal with early stopping using a counter (`cnt`).
 *       Stops traversal once the kth node is visited, reducing unnecessary work,
 *       especially when k is small.</li>
 * </ol>
 *
 * <p><b>Time Complexity:</b>
 * <ul>
 *   <li><b>Best case:</b> O(k), when the kth element is found early during traversal.</li>
 *   <li><b>Worst case:</b> O(n), for a completely unbalanced tree or when k = n.</li>
 * </ul>
 *
 * <p><b>Space Complexity:</b>
 * <ul>
 *   <li>O(h), where h is the height of the tree (due to recursion stack).</li>
 *   <li>O(log n) for balanced trees, O(n) for skewed trees.</li>
 * </ul>
 */
public class __45__KthSmallestElementInABst {
    private int cnt = 0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        inorder(root);
        return result;
    }


    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        cnt--;
        if (cnt == 0) {
            result = node.val;
            return;
        }
        if (cnt < 0) return;
        inorder((node.right));
    }
}
