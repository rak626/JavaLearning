package DSA.binarysearch;

import java.util.Arrays;

/**
 * Problem: Minimum Number of Days to Make m Bouquets
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/">
 *       LeetCode - Minimum Number of Days to Make m Bouquets</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: binarysearch, greedy</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * You are given an array <code>bloomDay[]</code>, where bloomDay[i] is the day
 * the i-th flower will bloom. You are also given integers <code>m</code> (number of bouquets)
 * and <code>k</code> (number of adjacent flowers needed per bouquet).
 * </p>
 * <p>
 * Find the minimum number of days required to make at least <code>m</code> bouquets,
 * or return -1 if it's impossible.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>We need to minimize "days". → Binary Search on Answer.</li>
 *   <li>Search space = [min(bloomDay), max(bloomDay)].</li>
 *   <li>For a given day = mid:
 *     <ul>
 *       <li>Check if we can form ≥ m bouquets by greedily grouping
 *           <code>k</code> consecutive flowers with bloomDay ≤ mid.</li>
 *       <li>If yes → try earlier days (right = mid - 1).</li>
 *       <li>If no → need more days (left = mid + 1).</li>
 *     </ul>
 *   </li>
 *   <li>At the end, answer is the smallest feasible day.</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(n log(maxDay - minDay)), where n = bloomDay.length.</li>
 *   <li><b>Space:</b> O(1).</li>
 * </ul>
 */
public class __BS13__MinDaysToMakeBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // If not enough flowers at all
        if ((long) m * k > n) return -1;

        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                right = mid - 1; // try earlier day
            } else {
                left = mid + 1; // need more days
            }
        }

        return ans;
    }

    /**
     * Helper to check if we can make at least m bouquets
     * on or before the given day.
     */
    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int cnt = 0, bouquets = 0;
        for (int d : bloomDay) {
            if (d <= day) {
                cnt++;
                if (cnt == k) {
                    bouquets++;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return bouquets >= m;
    }
}
