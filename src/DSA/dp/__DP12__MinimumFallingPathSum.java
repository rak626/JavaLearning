package DSA.dp;

import java.util.Arrays;

/**
 * Problem: Minimum Falling Path Sum
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/minimum-falling-path-sum/">LeetCode 931</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: dp, matrix, path sum</li>
 * </ul>
 *
 * <p>
 * <b>Problem Statement:</b><br>
 * Given an n x n integer matrix, return the minimum sum of any falling path through the matrix.
 * A falling path starts at any element in the first row and chooses one element from each row.
 * The next row's choice must be in a column that is at most one step away from the previous column.
 * </p>
 *
 * <p>
 * <b>Intuition:</b>
 * <ol>
 *   <li>Define dp[i][j] = minimum sum of a falling path ending at cell (i,j).</li>
 *   <li>From each cell (i,j), the previous row can contribute from three positions:
 *       <ul>
 *           <li>dp[i-1][j-1] (diagonal left)</li>
 *           <li>dp[i-1][j]   (straight above)</li>
 *           <li>dp[i-1][j+1] (diagonal right)</li>
 *       </ul>
 *   </li>
 *   <li>Recurrence: <code>dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])</code></li>
 *   <li>Base case: first row → dp[0][j] = matrix[0][j]</li>
 *   <li>Answer: minimum value in the last row → min(dp[n-1][j])</li>
 * </ol>
 * </p>
 *
 * <p>
 * <b>Four approaches implemented:</b>
 * <ol>
 *   <li>Pure Recursion (Exponential time)</li>
 *   <li>Recursion + Memoization (Top-down DP, O(n^2) time & space)</li>
 *   <li>Iterative DP (Bottom-up DP, O(n^2) time & space)</li>
 *   <li>Space-Optimized Iterative DP (O(n^2) time, O(n) space)</li>
 * </ol>
 * </p>
 */
public class __DP12__MinimumFallingPathSum {

    /**
     * 1. Pure Recursive Solution
     * <p>
     * Explore all possible paths recursively.
     * Time Complexity: O(3^n) → each cell has 3 options, n rows
     * Space Complexity: O(n) recursion stack
     */
    private int minFallingPathRecursive(int[][] matrix, int i, int j) {
        int n = matrix.length;
        if (j < 0 || j >= n) return Integer.MAX_VALUE; // out of bounds
        if (i == 0) return matrix[0][j]; // first row

        int up = minFallingPathRecursive(matrix, i - 1, j);
        int upLeft = minFallingPathRecursive(matrix, i - 1, j - 1);
        int upRight = minFallingPathRecursive(matrix, i - 1, j + 1);

        return matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
    }

    /**
     * 2. Recursion + Memoization (Top-down DP)
     * <p>
     * Store subproblem results in dp to avoid recomputation.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2) for dp + O(n) recursion stack
     */
    private int minFallingPathMemo(int[][] matrix, int i, int j, int[][] dp) {
        int n = matrix.length;
        if (j < 0 || j >= n) return Integer.MAX_VALUE;
        if (i == 0) return matrix[0][j];
        if (dp[i][j] != -1) return dp[i][j];

        int up = minFallingPathMemo(matrix, i - 1, j, dp);
        int upLeft = minFallingPathMemo(matrix, i - 1, j - 1, dp);
        int upRight = minFallingPathMemo(matrix, i - 1, j + 1, dp);

        return dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
    }

    /**
     * 3. Iterative Bottom-up DP
     * <p>
     * Fill dp table row by row from top to bottom.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    private int minFallingPathIterative(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Initialize first row
        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int upLeft = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int upRight = j < n - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
            }
        }

        // Minimum value in last row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) minSum = Math.min(minSum, dp[n - 1][j]);

        return minSum;
    }

    /**
     * 4. Space-Optimized Iterative DP
     * <p>
     * Only store previous row to reduce space usage.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    private int minFallingPathSpaceOptimized(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];
        System.arraycopy(matrix[0], 0, prev, 0, n);

        for (int i = 1; i < n; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int up = prev[j];
                int upLeft = j > 0 ? prev[j - 1] : Integer.MAX_VALUE;
                int upRight = j < n - 1 ? prev[j + 1] : Integer.MAX_VALUE;
                curr[j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
            }
            prev = curr;
        }

        int minSum = Integer.MAX_VALUE;
        for (int val : prev) minSum = Math.min(minSum, val);
        return minSum;
    }

    /**
     * Helper method to call memoization solution
     * Start from last row and check all columns.
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, minFallingPathMemo(matrix, n - 1, j, dp));
        }

        return minSum;
    }

    /**
     * Helper method to call space-optimized solution
     */
    public int minFallingPathSumOptimized(int[][] matrix) {
        return minFallingPathSpaceOptimized(matrix);
    }
}
