package DSA.binarysearch;

import java.util.Arrays;

/**
 * Problem: Koko Eating Bananas
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/koko-eating-bananas/">
 *       LeetCode - Koko Eating Bananas</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: binarysearch, greedy</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Koko loves bananas and has <code>piles</code> of bananas. Each hour she chooses
 * some pile and eats at most <code>k</code> bananas from it. If the pile has less
 * than <code>k</code> bananas, she eats the whole pile and doesn't continue in that hour.
 * </p>
 * <p>
 * Given an integer <code>h</code> (the number of hours), find the minimum eating speed
 * <code>k</code> such that she can eat all bananas within <code>h</code> hours.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>Binary search on answer (eating speed).</li>
 *   <li>Search space = [1, maxPile].</li>
 *   <li>For a given speed <code>mid</code>, calculate total hours needed:
 *     <ul>
 *       <li>Each pile requires <code>(pile + mid - 1) / mid</code> hours
 *           (integer ceil without floating point).</li>
 *     </ul>
 *   </li>
 *   <li>If total hours ≤ h → valid speed, try slower speed (right = mid - 1).</li>
 *   <li>If total hours > h → too slow, need faster speed (left = mid + 1).</li>
 *   <li>At the end, <code>left</code> is the minimum valid speed.</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(n log(maxPile)), where n = number of piles.</li>
 *   <li><b>Space:</b> O(1).</li>
 * </ul>
 */
public class __BS12__KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (timeTaken(piles, mid) <= h) {
                right = mid - 1; // try slower speed
            } else {
                left = mid + 1;  // need faster speed
            }
        }

        return left; // minimum eating speed
    }

    /**
     * Helper function to compute hours taken at given speed.
     */
    private int timeTaken(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // integer ceil
        }
        return hours;
    }
}
