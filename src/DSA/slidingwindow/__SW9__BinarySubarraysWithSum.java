package DSA.slidingwindow;

/**
 * Problem: Binary Subarrays With Sum
 * <ul>
 *   <li>LeetCode: <a href="https://leetcode.com/problems/binary-subarrays-with-sum/description/">
 *       Binary Subarrays With Sum</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Sliding Window, Prefix Sum, Binary Array</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given a binary array <code>nums</code> and an integer <code>goal</code>,
 * return the number of non-empty subarrays whose sum equals <code>goal</code>.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>Sliding Window / Prefix sum technique:
 *     <ol>
 *       <li>Count the number of subarrays with sum ≤ goal using a variable-size window.</li>
 *       <li>Use the helper <code>func(nums, goal)</code> to count subarrays with sum ≤ goal.</li>
 *       <li>Use the formula: <code>number of subarrays with sum = goal</code> =
 *           <code>func(nums, goal) - func(nums, goal - 1)</code>.</li>
 *       <li>Inside <code>func</code>:
 *         <ul>
 *           <li>Maintain a window [l, r] with sum ≤ goal.</li>
 *           <li>For each right pointer r, add <code>r - l + 1</code> to the count.</li>
 *         </ul>
 *       </li>
 *     </ol>
 *   </li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(n) → each element enters/exits window at most once</li>
 *   <li><b>Space:</b> O(1) → constant extra space</li>
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
            while (sum > goal && l < n) {
                sum -= nums[l];
                l++;
            }
            cnt += r - l + 1;
        }

        return cnt;
    }
}
