package DSA.binarysearch;

/**
 * Problem: Minimize Maximum Distance to Gas Station
 * <ul>
 *   <li>LeetCode: <a href="https://leetcode.com/problems/minimize-max-distance-to-gas-station/">
 *       Minimize Max Distance to Gas Station</a></li>
 *   <li>Difficulty: Hard</li>
 *   <li>Tags: binarysearch, greedy</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given sorted positions of existing gas stations on a highway and an integer <code>k</code>,
 * add <code>k</code> new gas stations such that the <b>maximum distance</b> between adjacent
 * stations is minimized. Return this minimized maximum distance.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>We need to minimize the largest gap → use <b>Binary Search on Answer</b>.</li>
 *   <li>Search space:
 *     <ul>
 *       <li><b>Low</b> = 0</li>
 *       <li><b>High</b> = max gap between consecutive stations</li>
 *     </ul>
 *   </li>
 *   <li>Feasibility check (<code>mid</code> = candidate max gap):
 *     <ul>
 *       <li>For each original gap, calculate how many new stations are required
 *           so that no sub-gap exceeds <code>mid</code>.</li>
 *       <li>If total stations needed ≤ k → feasible.</li>
 *     </ul>
 *   </li>
 *   <li>Binary search continues until precision <code>1e-6</code> is achieved.</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(n log(maxGap / precision))</li>
 *   <li><b>Space:</b> O(1)</li>
 * </ul>
 */
public class __BS20__MinimizeMaxDistanceGasStation {

    public double minMaxDist(int[] stations, int k) {
        int n = stations.length;
        if (n == 1) return 0.0;

        // search space: [0, max gap between consecutive stations]
        double low = 0.0, high = 0.0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, stations[i + 1] - stations[i]);
        }

        double eps = 1e-6;
        while (high - low > eps) {
            double mid = (low + high) / 2.0;

            if (canPlace(stations, mid, k)) {
                high = mid; // try smaller max distance
            } else {
                low = mid;  // need larger distance
            }
        }
        return high;
    }

    /**
     * Greedy feasibility check:
     * Count how many stations are needed so that no gap exceeds maxDist.
     */
    private boolean canPlace(int[] stations, double maxDist, int k) {
        int required = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            if (gap > maxDist) {
                // Number of extra stations needed in this gap
                required += (int) (gap / maxDist);
            }
        }
        return required <= k;
    }
}
