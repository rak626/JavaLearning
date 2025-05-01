package DSA.slidingwindow;

/**
 * Problem: Binary Subarrays With Sum
 * Link: <a href="https://leetcode.com/problems/binary-subarrays-with-sum/description/">Click here</a>
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * - 1.
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums, goal) - func(nums, goal - 1);
    }

    public int func(int[] nums, int goal) {
        if (goal < 0) return 0;
        int n = nums.length;
        int l = 0, sum = 0, cnt = 0;

        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum > goal && l < n) {
                sum -= nums[l];
                l++;
            }
            cnt += r - l + 1;
        }
        return cnt;
    }
}
