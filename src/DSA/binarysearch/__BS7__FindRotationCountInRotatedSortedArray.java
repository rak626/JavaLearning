package DSA.binarysearch;

/**
 * Problem: Find Rotation Count in Rotated Sorted Array
 * <ul>
 *   <li>Link: <a href="https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/">
 *       Find Rotation Count in Rotated Sorted Array</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: binarysearch</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given a sorted array that has been rotated some number of times,
 * return the number of rotations.
 * (Rotation count = index of the minimum element.)
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>This is almost identical to "Find Minimum in Rotated Sorted Array".</li>
 *   <li>We want the <b>index</b> of the minimum element instead of its value.</li>
 *   <li>Binary search strategy:
 *     <ul>
 *       <li>If <code>nums[l] &lt;= nums[mid]</code> → left half is sorted.
 *         <ul>
 *           <li>Update <code>ansIdx = l</code> if <code>nums[l]</code> is smaller.</li>
 *           <li>Shift to right half → <code>l = mid + 1</code>.</li>
 *         </ul>
 *       </li>
 *       <li>Else → right half is sorted but pivot lies in left half.
 *         <ul>
 *           <li>Update <code>ansIdx = mid</code> if <code>nums[mid]</code> is smaller.</li>
 *           <li>Shift to left half → <code>h = mid - 1</code>.</li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 *   <li>At the end, <code>ansIdx</code> = index of minimum → rotation count.</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(log n) — binary search halves search space each time.</li>
 *   <li><b>Space:</b> O(1) — only a few pointers/variables used.</li>
 * </ul>
 */
public class __BS7__FindRotationCountInRotatedSortedArray {

    public int findRotationCount(int[] nums) {
        int l = 0, h = nums.length - 1;
        int ansIdx = -1;
        int minVal = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + ((h - l) >> 1);

            // If left half is sorted
            if (nums[l] <= nums[mid]) {
                // Update minimum from left boundary
                if (nums[l] < minVal) {
                    minVal = nums[l];
                    ansIdx = l;
                }
                l = mid + 1;
            } else {
                // Right half has pivot, update with mid
                if (nums[mid] < minVal) {
                    minVal = nums[mid];
                    ansIdx = mid;
                }
                h = mid - 1;
            }
        }

        return ansIdx; // rotation count
    }
}
