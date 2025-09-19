package DSA.binarysearch;

/**
 * Problem: Search Insert Position
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/search-insert-position/description/">Search Insert Position</a></li>
 *   <li>Difficulty: Easy</li>
 *   <li>Tags: binarysearch</li>
 * </ul>
 *
 * <p><b>Approach:</b></p>
 * <ol>
 *   <li>The array is sorted, so we can apply binary search for efficient lookup.</li>
 *   <li>Initialize two pointers: <code>l</code> (low) = 0 and <code>h</code> (high) = nums.length - 1.</li>
 *   <li>While <code>l <= h</code>:</li>
 *   <ul>
 *       <li>Compute <code>mid = l + (h - l) / 2</code> to avoid integer overflow.</li>
 *       <li>If <code>nums[mid] == target</code>, return <code>mid</code>.</li>
 *       <li>If <code>nums[mid] &lt; target</code>, move <code>l = mid + 1</code>.</li>
 *       <li>If <code>nums[mid] &gt; target</code>, move <code>h = mid - 1</code>.</li>
 *   </ul>
 *   <li>If the target is not found, <code>l</code> will point to the index where the target should be inserted.</li>
 * </ol>
 *
 * <p><b>Time Complexity:</b> O(log n) — binary search over n elements.</p>
 * <p><b>Space Complexity:</b> O(1) — only constant extra space used.</p>
 */
public class __BS2_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1; // high should be nums.length - 1

        while (l <= h) {
            int mid = l + ((h - l) >> 1); // Avoid overflow

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l; // Insertion index
    }

}
