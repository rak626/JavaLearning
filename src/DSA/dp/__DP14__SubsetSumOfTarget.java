package DSA.dp;

import java.util.Arrays;

/**
 * 🔴 Problem: Subset Sum Equals K
 * <ul>
 *   <li>LeetCode: <a href="https://leetcode.com/problems/partition-equal-subset-sum/">Link</a></li>
 *   <li>GFG: <a href="https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/">Link</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Dynamic Programming, Subset, Knapsack</li>
 * </ul>
 *
 * <p><b>Problem Statement:</b><br>
 * Given an array of size n and an integer k, determine if there exists
 * a subset of the array whose sum is exactly equal to k.
 * </p>
 *
 * <p><b>Example:</b><br>
 * Input: arr = [1,2,3], k = 5<br>
 * Output: true  // subset [2,3] sums to 5
 * </p>
 *
 * <p><b>Intuition:</b><br>
 * At each index, we can either:
 * <ul>
 *   <li>Pick the element (if ≤ target)</li>
 *   <li>Skip the element</li>
 * </ul>
 * If at any point target = 0, we found a valid subset.
 * Use DP to avoid recomputation.
 * </p>
 *
 * <p><b>Approaches Implemented:</b>
 * <ol>
 *   <li>Pure Recursion → Exponential time</li>
 *   <li>Recursion + Memoization → O(n * k) time, O(n * k) space</li>
 *   <li>Iterative Tabulation → O(n * k) time, O(n * k) space</li>
 *   <li>Space-Optimized DP → O(n * k) time, O(k) space</li>
 * </ol>
 * </p>
 */
public class __DP14__SubsetSumOfTarget {

    /**
     * 1. Pure Recursion
     * <p>
     * Explore both choices: pick or skip.
     * Base cases:
     * - target == 0 → true
     * - ind == 0 → true if arr[0] == target
     * <p>
     * Time: O(2^n)
     * Space: O(n) recursion depth
     */
    public boolean subsetSumToK(int n, int k, int[] arr) {
        return solve(n - 1, k, arr);
    }

    private boolean solve(int ind, int target, int[] arr) {
        if (target == 0) return true;
        if (ind == 0) return arr[0] == target;

        boolean pick = arr[ind] <= target && solve(ind - 1, target - arr[ind], arr);
        boolean notPick = solve(ind - 1, target, arr);
        return pick || notPick;
    }

    /**
     * 2. Recursion + Memoization (Top-down DP)
     * <p>
     * dp[ind][target]:
     * -1 → unvisited
     *  0 → false
     *  1 → true
     * <p>
     * Time: O(n * k)
     * Space: O(n * k) + O(n) recursion stack
     */
    private boolean solve_memo(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return arr[0] == target;
        if (dp[ind][target] != -1) return dp[ind][target] == 1;

        boolean pick = arr[ind] <= target && solve_memo(ind - 1, target - arr[ind], arr, dp);
        boolean notPick = solve_memo(ind - 1, target, arr, dp);
        boolean ans = pick || notPick;

        dp[ind][target] = ans ? 1 : 0;
        return ans;
    }

    public boolean subsetSumToK_memo(int n, int k, int[] arr) {
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return solve_memo(n - 1, k, arr, dp);
    }

    /**
     * 3. Iterative Tabulation (Bottom-up DP)
     * <p>
     * dp[i][target] = true if subset exists using first i elements.
     * <p>
     * Base:
     * - dp[i][0] = true (sum 0 always possible)
     * - dp[0][arr[0]] = true if arr[0] ≤ k
     * <p>
     * Time: O(n * k)
     * Space: O(n * k)
     */
    public boolean subsetSumToK_tabulation(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (arr[0] <= k) dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[ind - 1][target];
                boolean pick = arr[ind] <= target && dp[ind - 1][target - arr[ind]];
                dp[ind][target] = pick || notPick;
            }
        }
        return dp[n - 1][k];
    }

    /**
     * 4. Space Optimized Iterative DP
     * <p>
     * Use only two 1D arrays (prev & curr).
     * <p>
     * Time: O(n * k)
     * Space: O(k)
     */
    public boolean subsetSumToK_space_optimized(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        if (arr[0] <= k) prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notPick = prev[target];
                boolean pick = arr[ind] <= target && prev[target - arr[ind]];
                curr[target] = pick || notPick;
            }
            prev = curr;
        }
        return prev[k];
    }
}
