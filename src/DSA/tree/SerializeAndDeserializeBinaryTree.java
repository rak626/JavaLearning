package DSA.tree;

import DSA.utils.TreeNode;

import java.util.*;

/**
 * Problem: Serialize And Deserialize Binary Tree
 * Link: <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/">Click here</a>
 * Difficulty: Hard
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Deque<String> q = new ArrayDeque<>(Arrays.asList(values));
        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Deque<String> q) {
        String nodeValue = q.poll();
        if (nodeValue.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeValue));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        return node;
    }

    // BFS solution
    public String serializeBFS(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>(); // array deque does not take null values, it throws null pointer exception
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeBFS(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] values = data.split(",");
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);

        int ind = 1;

        while (!q.isEmpty() && ind < values.length) {
            TreeNode node = q.poll();

            // traverse left
            if (!values[ind].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[ind]));
                q.offer(node.left);
            }
            ind++;

            //traverse right
            if (ind < values.length && !values[ind].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[ind]));
                q.offer(node.right);
            }
            ind++;
        }
        return root;
    }


}
