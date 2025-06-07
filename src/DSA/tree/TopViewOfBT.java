package DSA.tree;

import DSA.utils.Pair;
import DSA.utils.TreeNode;

import java.util.*;

/**
 * Problem: TopViewOfBT
 * Link: <a href="https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * -
 * Time: O(N Log(N))
 * Space: O(N)
 */

public class TopViewOfBT {
    public List<Integer> topView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> polled = q.poll();
            TreeNode node = polled.first;
            int vertical = polled.second;

            map.compute(vertical, (k, v) -> v == null ? node.val : v);

            if (node.left != null) {
                q.offer(new Pair<>(node.left, vertical - 1));
            }
            if (node.right != null) {
                q.offer(new Pair<>(node.right, vertical + 1));
            }
        }

        return new ArrayList<>(map.values());
    }

}
