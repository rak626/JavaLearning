package DSA.tree;

import DSA.utils.TreeNode;

import java.util.*;

/**
 * Problem: Vertical Order Traversal Of A Binary Tree
 * Link: <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/">Click here</a>
 * Difficulty: Hard
 * Tags: tree
 * <p>
 * Approach:
 * -
 * 1. BFS Traversal (while (!q.isEmpty()) loop)
 * Each node is visited exactly once → O(n)
 * <p>
 * 2. Map insertion per node
 * For each node, you:
 * Access or insert into an outer TreeMap (vertical) → O(log V)
 * Access or insert into an inner TreeMap (level) → O(log L)
 * Insert into a PriorityQueue → O(log k) where k is number of elements at that level and vertical
 * In worst-case, V and L can be O(n) (if all nodes are skewed)
 * So total cost per node ≈ O(log n) + O(log n) + O(log n) = O(log n)
 * Across n nodes: O(n log n)
 * <p>
 * 3. Building final result (for loop over map)
 * For each vertical → V verticals (≤ n)
 * For each level → L levels (≤ n)
 * For each priority queue → extract all values
 * Total extraction across all PQs: O(n log k)
 * But total work across all PQs is bounded by O(n log n) again
 * <p>
 * Time: O(n Log(n))
 * Space: O(n)
 */


class Tuple {
    TreeNode node;
    int vertical, level;

    Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            map
                    .computeIfAbsent(t.vertical, k -> new TreeMap<>())
                    .computeIfAbsent(t.level, k -> new PriorityQueue<>())
                    .offer(t.node.val);

            if (t.node.left != null)
                queue.offer(new Tuple(t.node.left, t.vertical - 1, t.level + 1));
            if (t.node.right != null)
                queue.offer(new Tuple(t.node.right, t.vertical + 1, t.level + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : levels.values()) {
                while (!nodes.isEmpty())
                    col.add(nodes.poll());
            }
            result.add(col);
        }
        return result;
    }
}

