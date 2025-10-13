package DSA.dp;

import java.util.Arrays;

/**
 * Problem: Unique Paths II (with obstacles)
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/unique-paths-ii/">Unique Paths II</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: dp, grid, obstacles</li>
 * </ul>
 *
 * <p>
 * You are given an m x n grid. A robot starts at the top-left corner and can only move
 * right or down. Some cells have obstacles (1 represents obstacle, 0 free space).
 * Return the number of unique paths from start to finish avoiding obstacles.
 * </p>
 *
 * <p>
 * <b>Intuition:</b>
 * <ol>
 *   <li>At each cell (i, j), robot can come from top (i-1, j) or left (i, j-1), unless blocked.</li>
 *   <li>Recurrence:
 *       <pre>
 * dp[i][j] = 0 if obstacleGrid[i][j] == 1
 * dp[i][j] = dp[i-1][j] + dp[i][j-1] if free
 *       </pre>
 *   </li>
 *   <li>Base case: dp[0][0] = 1 if free, 0 if blocked</li>
 *   <li>Answer: dp[m-1][n-1] = total unique paths avoiding obstacles</li>
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
public class __DP9__UniquePaths2 {

    /**
     * 1. Pure recursive solution
     * @param i Row index
     * @param j Column index
     * @param obstacleGrid Grid with obstacles
     * @return Number of unique paths to reach (i,j)
     * <p>
     * Time Complexity: O(2^(m+n))
     * Space Complexity: O(m+n) recursion stack
     * </p>
     */
    private int uniquePathsRecursive(int i, int j, int[][] obstacleGrid) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;

        return uniquePathsRecursive(i - 1, j, obstacleGrid) + uniquePathsRecursive(i, j - 1, obstacleGrid);
    }

    /**
     * 2. Recursion + Memoization (Top-down DP)
     * @param i Row index
     * @param j Column index
     * @param obstacleGrid Grid with obstacles
     * @param dp Memoization table
     * @return Number of unique paths to reach (i,j)
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n) dp + recursion stack
     * </p>
     */
    private int uniquePathsMemo(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = uniquePathsMemo(i - 1, j, obstacleGrid, dp) + uniquePathsMemo(i, j - 1, obstacleGrid, dp);
        return dp[i][j];
    }

    /**
     * 3. Iterative DP (Bottom-up)
     * @param obstacleGrid Grid with obstacles
     * @return Number of unique paths to reach bottom-right
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     * </p>
     */
    private int uniquePathsIterative(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 4. Space-Optimized Iterative DP
     * Only store previous row
     * @param obstacleGrid Grid with obstacles
     * @return Number of unique paths to reach bottom-right
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(n)
     * </p>
     */
    private int uniquePathsSpaceOptimized(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    curr[j] = 0;
                } else if (i == 0 && j == 0) {
                    curr[j] = 1;
                } else {
                    int up = i > 0 ? prev[j] : 0;
                    int left = j > 0 ? curr[j - 1] : 0;
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }

        return prev[n - 1];
    }

    /**
     * Helper for memoization call
     */
    public int uniquePathsMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return uniquePathsMemo(m - 1, n - 1, obstacleGrid, dp);
    }

    /**
     * Helper for space-optimized DP
     */
    public int uniquePaths(int[][] obstacleGrid) {
        return uniquePathsSpaceOptimized(obstacleGrid);
    }
}
