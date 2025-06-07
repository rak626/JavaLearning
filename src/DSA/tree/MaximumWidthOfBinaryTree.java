package DSA.tree;

import DSA.utils.Pair;
import DSA.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Maximum Width Of Binary Tree
 * Link: <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O(N)
 * Space: O(N)
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;

        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int firstIndex = q.peek().second;
            int lastIndex = firstIndex;

            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> cur = q.poll();
                TreeNode node = cur.first;
                int index = cur.second - firstIndex;
                if (node.left != null) {
                    q.offer(new Pair<>(node.left, 2 * index));
                }
                if (node.right != null) {
                    q.offer(new Pair<>(node.right, 2 * index + 1));
                }

                if (i == levelSize - 1) {
                    lastIndex = index;
                }
            }
            maxWidth = Math.max(maxWidth, lastIndex + 1);
        }
        return maxWidth;
    }
}
