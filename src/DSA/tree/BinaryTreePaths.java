package DSA.tree;

import DSA.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Binary Tree Paths
 * Link: <a href="https://leetcode.com/problems/binary-tree-paths/description/">Click here</a>
 * Difficulty: Easy
 * Tags: tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        // doing inorder traversal
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(root, path, result);
        return result;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) {
            return;
        }
        int len = path.length();
        path.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }


        // for backtracking
        path.setLength(len);
    }
}
