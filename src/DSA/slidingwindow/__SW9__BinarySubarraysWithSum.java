package DSA.slidingwindow;

/**
 * Problem: Binary Subarrays With Sum
 * <ul>
 *   <li>LeetCode: <a href="https://leetcode.com/problems/binary-subarrays-with-sum/">
 *       Binary Subarrays With Sum</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Sliding Window, Prefix Sum, Binary Array</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given a binary array <code>nums</code> (containing only 0s and 1s) and an integer
 * <code>goal</code>, return the number of non-empty subarrays whose sum is exactly
 * <code>goal</code>.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <p>
 * Because the array contains only non-negative numbers (0s and 1s), the sliding window
 * technique can be used to count the number of subarrays with sum &le; X in O(n) time.</p>
 *
 * <p>
 * Let <code>func(nums, x)</code> be the number of subarrays with sum &le; <code>x</code>.
 * For any non-negative integer array, the following identity holds:
 * </p>
 *
 * <pre>
 * # of subarrays with sum = goal
 *   = # of subarrays with sum ≤ goal
 *   - # of subarrays with sum ≤ goal - 1
 * </pre>
 *
 * <p>
 * This works because all subarrays with sum &lt; goal are included in both counts and cancel out,
 * leaving exactly those with sum = goal.
 * </p>
 *
 * <h2>Helper Function (<code>func</code>):</h2>
 * <ul>
 *   <li>Maintains a sliding window [l, r] whose sum never exceeds <code>goal</code>.</li>
 *   <li>For each right index <code>r</code>, once the window is valid:
 *       <ul>
 *         <li>All subarrays ending at <code>r</code> and starting from <code>l</code> to <code>r</code>
 *             are valid.</li>
 *         <li>The count increases by <code>r - l + 1</code>.</li>
 *       </ul>
 *   </li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(n) — each pointer (left/right) moves at most once.</li>
 *   <li><b>Space:</b> O(1) — constant extra space.</li>
 * </ul>
 */
public class __SW9__BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums, goal) - func(nums, goal - 1);
    }

    private int func(int[] nums, int goal) {
        if (goal < 0) return 0;
        int n = nums.length;
        int l = 0, sum = 0, cnt = 0;

        for (int r = 0; r < n; r++) {
            sum += nums[r];
//            We can do sum == goal , because after that all the trailing 0's , sum will be same as goal
            while (sum > goal && l < n) {
                sum -= nums[l];
                l++;
            }
            cnt += r - l + 1;
        }

        return cnt;
    }
}
