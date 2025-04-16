package DSA.slidingwindow;

/**
 * Problem: Max Consecutive Ones Iii
 * Link: <a href="https://leetcode.com/problems/max-consecutive-ones-iii/description/">...</a>
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O(2N)
 * Space: O(1)
 */
public class MaxConsecutiveOnesIii {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int maxLength = 0;
        int zeroCount = 0;

        while (right < n) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
