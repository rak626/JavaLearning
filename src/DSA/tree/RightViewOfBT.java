package DSA.tree;

import DSA.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Problem: RightViewOfBT
 * Link: <a href="https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * -
 * Time: O(N)
 * Space: O(N)
 */


public class RightViewOfBT {
    public List<Integer> rightView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return result;
    }
}
