package DSA.tree;

import DSA.utils.TreeNode;

import java.util.*;

/**
 * Problem: Lowest Common Ancestor Of A Binary Tree
 * Link: <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O(N)
 * Space: O(H) height of recursion tree
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    // Bfs approach by parent tracking
    public TreeNode lowestCommonAncestorBFS(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        parent.put(root, null);
        queue.offer(root);

        // Step 1: BFS to build parent map until both p and q are found
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                parent.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right != null) {
                parent.put(current.right, current);
                queue.offer(current.right);
            }
        }

        // Step 2: Add all ancestors of p to a set
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // Step 3: Move up from q until you find a common ancestor
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}
