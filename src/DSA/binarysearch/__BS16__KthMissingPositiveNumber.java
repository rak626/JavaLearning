package DSA.binarysearch;

/**
 * Problem: Kth Missing Positive Number
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/kth-missing-positive-number/">
 *       LeetCode - Kth Missing Positive Number</a></li>
 *   <li>Difficulty: Easy</li>
 *   <li>Tags: binarysearch, array</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * You are given a sorted array of positive integers <code>arr</code> (no duplicates).
 * Return the <code>k</code>-th missing positive integer.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>At index <code>mid</code>, the number of missing elements is:
 *       <code>arr[mid] - (mid + 1)</code>.</li>
 *   <li>If <b>missing &lt; k</b> → the kth missing lies on the right → move left = mid + 1.</li>
 *   <li>If <b>missing ≥ k</b> → kth missing lies on the left → move right = mid - 1.</li>
 *   <li>After loop, <code>left</code> will be the position where the kth missing fits.</li>
 *   <li>Answer = <code>left + k</code>.</li>
 * </ul>
 *
 * <h2>Example:</h2>
 * <pre>
 * arr = [2,3,4,7,11], k = 5
 * Missing counts: [1,1,1,3,6]
 * kth missing = 9
 * </pre>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(log n) → binary search.</li>
 *   <li><b>Space:</b> O(1).</li>
 * </ul>
 */
public class __BS16__KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1; // go right
            } else {
                right = mid - 1; // go left
            }
        }

        return left + k;
    }
}
