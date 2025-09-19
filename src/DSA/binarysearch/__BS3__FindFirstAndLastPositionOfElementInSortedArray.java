package DSA.binarysearch;

/**
 * Problem: Find First and Last Position of Element in Sorted Array
 *
 * <p>
 * Given a sorted array of integers and a target value, return the indices of the
 * first and last occurrence of the target. If the target is not present, return [-1, -1].
 * </p>
 *
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/">
 *       LeetCode - Find First and Last Position of Element in Sorted Array</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: binarysearch</li>
 * </ul>
 *
 * <h2>Approach:</h2>
 * <ul>
 *   <li>Since the array is sorted, we use <b>binary search</b> to achieve O(log n) complexity.</li>
 *   <li>Perform binary search twice:
 *     <ul>
 *       <li>First pass → find the <b>first occurrence</b> of target by searching left.</li>
 *       <li>Second pass → find the <b>last occurrence</b> of target by searching right.</li>
 *     </ul>
 *   </li>
 *   <li>If target not found, return [-1, -1].</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(log n) — two binary searches.</li>
 *   <li><b>Space:</b> O(1) — constant extra space.</li>
 * </ul>
 */
public class __BS3__FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * Finds the first and last index of target in nums.
     */
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    /**
     * Binary search for the first occurrence.
     */
    private int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length - 1, idx = -1;

        while (l <= h) {
            int mid = l + ((h - l) >> 1);

            if (nums[mid] >= target) {
                h = mid - 1; // shrink to left
            } else {
                l = mid + 1;
            }

            if (nums[mid] == target) {
                idx = mid; // record index, continue left
            }
        }
        return idx;
    }

    /**
     * Binary search for the last occurrence.
     */
    private int findLast(int[] nums, int target) {
        int l = 0, h = nums.length - 1, idx = -1;

        while (l <= h) {
            int mid = l + ((h - l) >> 1);

            if (nums[mid] <= target) {
                l = mid + 1; // shrink to right
            } else {
                h = mid - 1;
            }

            if (nums[mid] == target) {
                idx = mid; // record index, continue right
            }
        }
        return idx;
    }

    /**
     * Optimized version: Combine first & last search into one helper by passing a flag.
     */
    public int[] searchRangeCombine(int[] nums, int target) {
        int first = find(true, nums, target);
        int last = find(false, nums, target);
        return new int[]{first, last};
    }

    /**
     * Generalized binary search.
     * @param isFirst whether to search for first occurrence (true) or last occurrence (false)
     */
    private int find(boolean isFirst, int[] nums, int target) {
        int l = 0, h = nums.length - 1, idx = -1;

        while (l <= h) {
            int mid = l + ((h - l) >> 1);

            if (nums[mid] > target || (isFirst && nums[mid] == target)) {
                h = mid - 1; // shrink left
            } else {
                l = mid + 1; // shrink right
            }

            if (nums[mid] == target) {
                idx = mid; // record index
            }
        }
        return idx;
    }
}
