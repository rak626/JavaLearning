package DSA.tree;

import DSA.utils.TreeNode;

import java.util.*;

/**
 * Problem: All Nodes Distance K In Binary Tree
 * Link: <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // track parent
        // track is visited or not
        // do bfs
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        trackParent(root, parent);
        Set<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(target);
        visited.add(target);
        int curLevel = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            if (curLevel == k) break;
            curLevel++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);
                }
                TreeNode parentNode = parent.get(node);
                if (parentNode != null && !visited.contains(parentNode)) {
                    q.offer(parentNode);
                    visited.add(parentNode);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }
        return result;

    }

    private void trackParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
    }

}
