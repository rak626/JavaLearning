package DSA.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Problem: Triangle Minimum Path Sum (Top-Down)
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/triangle/">Triangle</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: dp, triangle</li>
 * </ul>
 *
 * <p>
 * Given a triangle array, find the minimum path sum from the top (0,0) to the bottom row.
 * At each step, you may move to adjacent numbers in the row below: (i+1,j) or (i+1,j+1).
 * </p>
 *
 * <p>
 * <b>Intuition:</b>
 * <ol>
 *   <li>Start at the top cell (0,0).</li>
 *   <li>At each cell (i,j), you can move down-left (i+1,j) or down-right (i+1,j+1).</li>
 *   <li>The minimum path sum from cell (i,j) is:
 *       <pre>minPath(i,j) = triangle[i][j] + min(minPath(i+1,j), minPath(i+1,j+1))</pre>
 *   </li>
 *   <li>Base case: last row → minPath(lastRow,j) = triangle[lastRow][j]</li>
 *   <li>Answer: minPath(0,0) → minimum path sum from top to bottom.</li>
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
public class __DP11__Triangle {

    /**
     * 1. Pure recursive solution (Exponential)
     * <p>
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) recursion stack
     */
    private int triangleRecursive(int i, int j, List<List<Integer>> triangle) {
        int n = triangle.size();
        if (i == n - 1) return triangle.get(i).get(j); // last row

        int down = triangleRecursive(i + 1, j, triangle);
        int downRight = triangleRecursive(i + 1, j + 1, triangle);

        return triangle.get(i).get(j) + Math.min(down, downRight);
    }

    /**
     * 2. Recursion + Memoization (Top-down DP)
     * <p>
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2) for dp + recursion stack
     */
    private int triangleMemo(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        int n = triangle.size();
        if (i == n - 1) return triangle.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];

        int down = triangleMemo(i + 1, j, triangle, dp);
        int downRight = triangleMemo(i + 1, j + 1, triangle, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, downRight);
    }

    /**
     * 3. Iterative Bottom-up DP
     * <p>
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    private int triangleIterative(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Copy last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Fill rows from bottom-1 upwards
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0]; // top element → minimum path sum
    }

    /**
     * 4. Space-Optimized Iterative DP
     * <p>
     * Only stores previous row to save space
     * <p>
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    private int triangleSpaceOptimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Copy last row
        for (int j = 0; j < n; j++) dp[j] = triangle.get(n - 1).get(j);

        // Fill from bottom-1 row upwards
        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = 0; j <= i; j++) {
                curr[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
            dp = curr; // move one row up
        }

        return dp[0];
    }

    /**
     * Helper to call memoization solution
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return triangleMemo(0, 0, triangle, dp);
    }

    /**
     * Helper to call space-optimized solution
     */
    public int minimumTotalOptimized(List<List<Integer>> triangle) {
        return triangleSpaceOptimized(triangle);
    }
}
