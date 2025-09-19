package DSA.binarysearch;

import java.util.Arrays;

/**
 * Problem: Smallest Divisor Given a Threshold
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/">
 *       LeetCode - Smallest Divisor Given a Threshold</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: binarysearch, greedy</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * You are given an integer array <code>nums</code> and an integer <code>threshold</code>.
 * You must choose a divisor <code>d</code> such that:
 * <ul>
 *   <li>Compute sum = Σ ceil(nums[i] / d).</li>
 *   <li>sum ≤ threshold.</li>
 * </ul>
 * Return the smallest possible divisor <code>d</code>.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>We are minimizing divisor → Binary Search on Answer.</li>
 *   <li>Search space = [1, max(nums)].</li>
 *   <li>For a candidate divisor = mid:
 *     <ul>
 *       <li>Compute sum = Σ ceil(nums[i] / mid).</li>
 *       <li>If sum ≤ threshold → mid is feasible → try smaller divisor (right = mid - 1).</li>
 *       <li>If sum > threshold → divisor too small → increase divisor (left = mid + 1).</li>
 *     </ul>
 *   </li>
 *   <li>Keep track of the smallest feasible divisor.</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(n log(max(nums)))
 *       → Each binary search step takes O(n) to compute sum.</li>
 *   <li><b>Space:</b> O(1).</li>
 * </ul>
 */
public class __BS14__SmallestDivisorGivenThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDivide(nums, mid, threshold)) {
                ans = mid;       // valid divisor
                right = mid - 1; // try smaller
            } else {
                left = mid + 1;  // need larger divisor
            }
        }

        return ans;
    }

    /**
     * Helper function to check if dividing by 'divisor' keeps
     * the sum <= threshold.
     */
    private boolean canDivide(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            // Equivalent to ceil(num / divisor)
            sum += (num + divisor - 1) / divisor;
            if (sum > threshold) return false; // prune early
        }
        return sum <= threshold;
    }
}
