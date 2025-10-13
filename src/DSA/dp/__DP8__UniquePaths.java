package DSA.dp;

import java.util.Arrays;

/**
 * Problem: Unique Paths
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: dp, grid</li>
 * </ul>
 *
 * <p>
 * You are given a (m x n) grid. A robot starts at the top-left corner and can only move
 * right or down. The robot wants to reach the bottom-right corner.
 * Return the number of unique paths from start to finish.
 * </p>
 *
 * <p>
 * <b>Intuition:</b>
 * <ol>
 *   <li>At each cell (i, j), robot can come from top (i-1, j) or left (i, j-1).</li>
 *   <li>Recurrence: <code>dp[i][j] = dp[i-1][j] + dp[i][j-1]</code></li>
 *   <li>Base case: dp[0][0] = 1 (starting cell)</li>
 *   <li>Answer: dp[m-1][n-1] = total unique paths</li>
 * </ol>
 * </p>
 *
 * <p>
 * <b>Four approaches implemented:</b>
 * <ol>
 *   <li>Pure Recursion (Exponential)</li>
 *   <li>Recursion + Memoization (Top-down DP, O(m*n) time & space)</li>
 *   <li>Iterative DP (Bottom-up DP, O(m*n) time & space)</li>
 *   <li>Space-Optimized Iterative DP (O(m*n) time, O(n) space)</li>
 * </ol>
 * </p>
 */
public class __DP8__UniquePaths {

    /**
     * 1. Pure recursive solution
     * @param i Row index
     * @param j Column index
     * @return Number of unique paths to reach (i,j)
     * <p>
     * Time Complexity: O(2^(m+n))
     * Space Complexity: O(m+n) recursion stack
     * </p>
     */
    private int uniquePathsRecursive(int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        return uniquePathsRecursive(i - 1, j) + uniquePathsRecursive(i, j - 1);
    }

    /**
     * 2. Recursion + Memoization (Top-down DP)
     * @param i Row index
     * @param j Column index
     * @param dp Memoization table
     * @return Number of unique paths to reach (i,j)
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n) dp + recursion stack
     * </p>
     */
    private int uniquePathsMemo(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = uniquePathsMemo(i - 1, j, dp) + uniquePathsMemo(i, j - 1, dp);
        return dp[i][j];
    }

    /**
     * 3. Iterative DP (Bottom-up)
     * @param m Number of rows
     * @param n Number of columns
     * @return Number of unique paths
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     * </p>
     */
    private int uniquePathsIterative(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int up = i > 0 ? dp[i - 1][j] : 0;
                int left = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 4. Space-Optimized Iterative DP
     * Only store previous row to reduce space
     * @param m Number of rows
     * @param n Number of columns
     * @return Number of unique paths
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(n)
     * </p>
     */
    private int uniquePathsSpaceOptimized(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 0);
        prev[0] = 1;

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = 1;
                    continue;
                }
                int up = i > 0 ? prev[j] : 0;
                int left = j > 0 ? curr[j - 1] : 0;
                curr[j] = up + left;
            }
            prev = curr;
        }

        return prev[n - 1];
    }

    /**
     * Helper for memoization call
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return uniquePathsMemo(m - 1, n - 1, dp);
    }
}
