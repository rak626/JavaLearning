package DSA.tree;

import DSA.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Diameter Of Binary Tree
 * Link: <a href="https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1">Click here</a>
 * Difficulty: Easy
 * Tags: Tree
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O(N)
 * Space: O(N)
 */
public class BoundaryLevelTraversal {
    List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverseLeftBoundary(root, result);
        traverseLeafNodes(root, result);
        traverseRightBoundary(root, result);
        return result;
    }

    private void traverseRightBoundary(TreeNode root, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        TreeNode cur = root.right;
        while (cur != null) {
            if (!isLeaf(cur)) {
                temp.addFirst(cur.val);
            }
            if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        result.addAll(temp);
    }

    private void traverseLeafNodes(TreeNode root, List<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        if (root.left != null) {
            traverseLeafNodes(root.left, result);
        }
        if (root.right != null) {
            traverseLeafNodes(root.right, result);
        }
    }

    private void traverseLeftBoundary(TreeNode root, List<Integer> result) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur)) {
                result.add(cur.val);
            }
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    private boolean isLeaf(TreeNode cur) {
        return cur.left == null && cur.right == null;
    }
}
