package DSA.binarysearch;

/**
 * Problem: Find Minimum in Rotated Sorted Array
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">
 *       Find Minimum in Rotated Sorted Array</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: binarysearch</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * You are given a rotated sorted array of unique integers.
 * Find and return the minimum element in the array.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>We know the array is sorted but rotated at some pivot.</li>
 *   <li>Use binary search to identify the sorted portion.</li>
 *   <li>At each step:
 *     <ul>
 *       <li>If <code>nums[l] &lt;= nums[mid]</code> → left half is sorted.</li>
 *       <li>→ minimum must be <code>nums[l]</code> or in the right half, so update answer and move <code>l = mid + 1</code>.</li>
 *       <li>Else → right half is sorted but pivot lies in left, so update answer with <code>nums[mid]</code> and move <code>h = mid - 1</code>.</li>
 *     </ul>
 *   </li>
 *   <li>Keep track of the global minimum.</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(log n) — binary search halves the array each iteration.</li>
 *   <li><b>Space:</b> O(1) — only variables used.</li>
 * </ul>
 */
public class __BS6__FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + ((h - l) >> 1);

            // If left half is sorted
            if (nums[l] <= nums[mid]) {
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            }
            // Right half is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                h = mid - 1;
            }
        }

        return ans;
    }
}
