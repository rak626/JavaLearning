package DSA.stack;

import java.util.Stack;

/**
 * Problem: Previous Smallest Element
 * Link: <a href="https://leetcode.com/problems/previous-smallest-element/description/">Click here</a>
 * Difficulty: Medium
 * Tags: stack
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class PreviousSmallestElement {
    public int[] previousSmallestElement(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
