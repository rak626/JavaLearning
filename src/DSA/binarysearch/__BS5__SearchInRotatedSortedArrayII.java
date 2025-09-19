package DSA.binarysearch;

/**
 * Problem: Search in Rotated Sorted Array II
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/">
 *       Search in Rotated Sorted Array II</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: binarysearch</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given an integer array <code>nums</code> that is sorted in ascending order but rotated
 * at some unknown pivot, and may contain <b>duplicates</b>, return true if <code>target</code>
 * exists in the array, otherwise return false.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>This is an extension of the classic rotated array search.</li>
 *   <li>Challenge: Duplicates can make it hard to decide which half is sorted.</li>
 *   <li>Steps:</li>
 *   <ol>
 *     <li>Use binary search template with pointers <code>l</code> and <code>h</code>.</li>
 *     <li>If <code>nums[mid] == target</code> → return true.</li>
 *     <li>If <code>nums[l] == nums[mid] == nums[h]</code>, we cannot decide which side is sorted → shrink window (<code>l++</code> and <code>h--</code>).</li>
 *     <li>If left half (<code>nums[l]...nums[mid]</code>) is sorted:
 *       <ul>
 *         <li>If target lies in range → search left (<code>h = mid - 1</code>).</li>
 *         <li>Else → search right (<code>l = mid + 1</code>).</li>
 *       </ul>
 *     </li>
 *     <li>Otherwise, right half is sorted:
 *       <ul>
 *         <li>If target lies in range → search right (<code>l = mid + 1</code>).</li>
 *         <li>Else → search left (<code>h = mid - 1</code>).</li>
 *       </ul>
 *     </li>
 *   </ol>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(log n) on average, but in worst case (all duplicates) it degrades to O(n).</li>
 *   <li><b>Space:</b> O(1).</li>
 * </ul>
 */
public class __BS5__SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;

        while (l <= h) {
            int mid = l + ((h - l) >> 1);

            if (nums[mid] == target) return true;

            // If duplicates block decision, shrink window
            if (nums[l] == nums[mid] && nums[mid] == nums[h]) {
                l++;
                h--;
                continue;
            }

            // Left half is sorted
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] <= target && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }

        return false; // not found
    }
}
