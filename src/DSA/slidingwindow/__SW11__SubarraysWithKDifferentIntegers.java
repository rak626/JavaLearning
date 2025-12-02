package DSA.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Subarrays With K Different Integers
 *
 * <ul>
 *   <li>LeetCode: <a href="https://leetcode.com/problems/subarrays-with-k-different-integers/">
 *       Subarrays With K Different Integers</a></li>
 *   <li>Difficulty: Hard</li>
 *   <li>Tags: Sliding Window, HashMap, Two Pointers</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given an integer array <code>nums</code> and an integer <code>k</code>,
 * return the number of subarrays that contain exactly <code>k</code> distinct integers.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <p>
 * We use the classic sliding-window formula:
 * </p>
 * <pre>
 *   exactly(k) = atMost(k) − atMost(k − 1)
 * </pre>
 *
 * <p>
 * The key idea is to compute:
 * </p>
 * <ul>
 *   <li><b>atMost(k):</b> number of subarrays with at most <code>k</code> distinct integers.</li>
 *   <li><b>atMost(k - 1):</b> number of subarrays with at most <code>k - 1</code> distinct integers.</li>
 * </ul>
 *
 * <p>
 * The difference gives subarrays that contain exactly <code>k</code> distinct integers.
 * </p>
 *
 * <h3>How atMost(k) Works:</h3>
 * <ul>
 *   <li>Maintain a sliding window [left, right].</li>
 *   <li>Use a frequency map to track how many distinct integers are inside the window.</li>
 *   <li>If distinct count exceeds <code>k</code>, shrink the window from the left.</li>
 *   <li>For each position <code>right</code>, the number of valid subarrays ending at <code>right</code> is:
 *       <code>right - left + 1</code></li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(n) — each element is added and removed at most once.</li>
 *   <li><b>Space:</b> O(k) — extra space for the frequency map.</li>
 * </ul>
 */
public class __SW11__SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, total = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() > k) {
                int newCount = freq.get(nums[left]) - 1;
                if (newCount == 0) freq.remove(nums[left]);
                else freq.put(nums[left], newCount);
                left++;
            }

            total += right - left + 1;
        }

        return total;
    }
}
