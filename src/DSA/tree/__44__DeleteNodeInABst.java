package DSA.tree;

import DSA.utils.TreeNode;

/**
 * Problem: Delete Node In A Bst
 * Link: <a href="https://leetcode.com/problems/delete-node-in-a-bst/description/">Click here</a>
 * Difficulty: Medium
 * Tags: tree
 * <p>
 * Approach:
 * Deletes a node with the given key from a Binary Search Tree (BST).
 * Maintains the BST property after deletion.
 * <p>
 * If the node to delete has:
 * - No children: it is simply removed.
 * - One child: it is replaced by its child.
 * - Two children: its left and right subtrees are merged,
 *   where the rightmost node of the left subtree takes its place.
 *
 *
 * <p><b>Time Complexity:</b>
 * <ul>
 *   <li>Average case: O(log n) for balanced BSTs</li>
 *   <li>Worst case: O(n) for skewed BSTs</li>
 *   <li>Explanation:
 *     <ul>
 *       <li>O(h) to find the node, where h is the height of the tree</li>
 *       <li>O(h) to find the rightmost node in the left subtree (during merge)</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Space Complexity:</b>
 * <ul>
 *   <li>O(1) – Constant extra space is used (iterative approach, no recursion stack)</li>
 * </ul>
 */
public class __44__DeleteNodeInABst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) return merge(root.left, root.right);

        TreeNode cur = root;
        while (cur != null) {
            if (key < cur.val) {
                if (cur.left != null && cur.left.val == key) {
                    cur.left = merge(cur.left.left, cur.left.right);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right != null && cur.right.val == key) {
                    cur.right = merge(cur.right.left, cur.right.right);
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }

    private TreeNode merge(TreeNode left, TreeNode right) {
        if (left == null) return right;
        if (right == null) return left;

        TreeNode temp = left;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
        return left;
    }
}
