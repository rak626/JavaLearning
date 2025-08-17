package DSA.tree;

import DSA.utils.TreeNode;

import java.util.*;

/**
 * Problem: Amount Of Time For Binary Tree To Be Infected
 * Link: <a href="https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = trackParentAndFindNode(root, parent, start);
        Set<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(startNode);
        visited.add(startNode);
        int time = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            time++;
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
        return time - 1;
    }

    private TreeNode trackParentAndFindNode(TreeNode root, Map<TreeNode, TreeNode> parent, int start) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        TreeNode foundNode = null;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == start) {
                foundNode = node;
            }
            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
        return foundNode;
    }
}
