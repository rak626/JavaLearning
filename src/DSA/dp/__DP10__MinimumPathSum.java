package DSA.dp;

import java.util.Arrays;

/**
 * Problem: Minimum Path Sum
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/minimum-path-sum/">Minimum Path Sum</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: dp, grid</li>
 * </ul>
 *
 * <p>
 * Given an m x n grid filled with non-negative numbers, find a path from the top-left
 * to the bottom-right corner which minimizes the sum of all numbers along its path.
 * You can only move down or right at any point in time.
 * </p>
 *
 * <p>
 * <b>Intuition:</b>
 * <ol>
 *   <li>At each cell (i, j), robot can come from top (i-1, j) or left (i, j-1).</li>
 *   <li>Recurrence: <code>dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])</code></li>
 *   <li>Base case: dp[0][0] = grid[0][0]</li>
 *   <li>Answer: dp[m-1][n-1] = minimum sum along a path</li>
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
public class __DP10__MinimumPathSum {

    /**
     * 1. Pure recursive solution
     * @param i Row index
     * @param j Column index
     * @param grid Grid of values
     * @return Minimum path sum to reach (i,j)
     * <p>
     * Time Complexity: O(2^(m+n))
     * Space Complexity: O(m+n) recursion stack
     * </p>
     */
    private int minPathSumRecursive(int i, int j, int[][] grid) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[0][0];

        int up = minPathSumRecursive(i - 1, j, grid);
        int left = minPathSumRecursive(i, j - 1, grid);
        return grid[i][j] + Math.min(up, left);
    }

    /**
     * 2. Recursion + Memoization (Top-down DP)
     * @param i Row index
     * @param j Column index
     * @param grid Grid of values
     * @param dp Memoization table
     * @return Minimum path sum to reach (i,j)
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n) dp + recursion stack
     * </p>
     */
    private int minPathSumMemo(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[0][0];
        if (dp[i][j] != -1) return dp[i][j];

        int up = minPathSumMemo(i - 1, j, grid, dp);
        int left = minPathSumMemo(i, j - 1, grid, dp);
        dp[i][j] = grid[i][j] + Math.min(up, left);
        return dp[i][j];
    }

    /**
     * 3. Iterative DP (Bottom-up)
     * @param grid Grid of values
     * @return Minimum path sum to reach bottom-right
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     * </p>
     */
    private int minPathSumIterative(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[0][0];
                else {
                    int up = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 4. Space-Optimized Iterative DP
     * Only store previous row
     * @param grid Grid of values
     * @return Minimum path sum to reach bottom-right
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(n)
     * </p>
     */
    private int minPathSumSpaceOptimized(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) curr[j] = grid[0][0];
                else {
                    int up = i > 0 ? prev[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? curr[j - 1] : Integer.MAX_VALUE;
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[n - 1];
    }

    /**
     * Helper for memoization call
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minPathSumMemo(m - 1, n - 1, grid, dp);
    }
}
