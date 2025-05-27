package DSA.stack;

/**
 * Problem: Trapping Rain Water
 * Link: <a href="https://leetcode.com/problems/trapping-rain-water/description/">Click here</a>
 * Difficulty: Hard
 * Tags: stack
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class TrappingRainWater {
    // Note:  approach 1 - extra space required, O(2N)
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int preMax = Integer.MIN_VALUE, postMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            preMax = Math.max(preMax, height[i]);
            leftMax[i] = preMax;
            postMax = Math.max(postMax, height[n - 1 - i]);
            rightMax[n - 1 - i] = postMax;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }


    // Note: approach 2 - with no extra space - O(1)
    public int trap2(int[] height) {
        int n = height.length;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int left = 0, right = n - 1, result = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
