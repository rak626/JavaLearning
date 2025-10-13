package DSA.slidingwindow;

/**
 * Problem: Count Number Of Nice Subarrays
 * <ul>
 *   <li>LeetCode: <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/description/">
 *       Count Number Of Nice Subarrays</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Sliding Window, Prefix Sum, Odd Numbers</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given an integer array <code>nums</code> and an integer <code>k</code>,
 * return the number of subarrays that contain exactly <code>k</code> odd numbers.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>Sliding Window / Prefix sum technique:
 *     <ol>
 *       <li>Count the number of subarrays with ≤ k odd numbers using a variable-size window.</li>
 *       <li>Use helper <code>func(nums, k)</code> to count subarrays with ≤ k odd numbers.</li>
 *       <li>Number of subarrays with exactly k odd numbers = <code>func(nums, k) - func(nums, k - 1)</code>.</li>
 *       <li>Inside <code>func</code>:
 *         <ul>
 *           <li>Maintain a window [l, r] where count of odd numbers ≤ k.</li>
 *           <li>For each right pointer r, add <code>r - l + 1</code> to the answer.</li>
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
public class __SW10__CountNumberOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums, k) - func(nums, k - 1);
    }

    private int func(int[] nums, int k) {
        if (k < 0) return 0;
        int n = nums.length;
        int l = 0, cntOdd = 0, ans = 0;

        for (int r = 0; r < n; r++) {
            if ((nums[r] & 1) == 1) cntOdd++;

            // shrink window if odd count > k
            while (cntOdd > k) {
                if ((nums[l] & 1) == 1) cntOdd--;
                l++;
            }

            ans += r - l + 1;
        }

        return ans;
    }
}
