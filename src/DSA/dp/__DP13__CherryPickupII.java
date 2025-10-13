package DSA.dp;

/**
 * Problem: Cherry Pickup II
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/cherry-pickup-ii/">LeetCode 1463</a></li>
 *   <li>Difficulty: Hard</li>
 *   <li>Tags: Dynamic Programming, 3D DP, Grid, Matrix</li>
 * </ul>
 *
 * <p>
 * <b>Problem Statement:</b><br>
 * You are given an n x m grid representing a field of cherries.<br>
 * - Two robots start from row 0: one at column 0, another at column m - 1.<br>
 * - They move downwards row by row, and at each step, they can move to col - 1, col, or col + 1.<br>
 * - If both robots land on the same cell, they only pick cherries once.<br>
 * Return the maximum number of cherries they can collect.
 * </p>
 *
 * <p>
 * <b>Example:</b><br>
 * Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]<br>
 * Output: 24
 * </p>
 *
 * <p>
 * <b>Intuition:</b>
 * <ol>
 *   <li>State definition: dp[r][c1][c2] = maximum cherries collected from row r to bottom,
 *       when robot1 is at column c1 and robot2 at column c2.</li>
 *   <li>At each step, both robots move downwards and can shift -1, 0, or +1 columns.</li>
 *   <li>From each state (r, c1, c2), explore all 9 combinations (dc1, dc2).</li>
 *   <li>Transition:
 *       <code>dp[r][c1][c2] = cherries(r, c1, c2) + max(dp[r+1][c1+dc1][c2+dc2])</code></li>
 *   <li>Base case: when r = n-1 (last row), directly return cherries collected.</li>
 *   <li>Answer: dp[0][0][m-1], starting with robot1 at col 0 and robot2 at col m-1.</li>
 * </ol>
 * </p>
 *
 * <p>
 * <b>Four approaches implemented:</b>
 * <ol>
 *   <li>Pure Recursion (Exponential Time)</li>
 *   <li>Recursion + Memoization (Top-down DP, O(n * m^2) time, O(n * m^2) space)</li>
 *   <li>Iterative DP (Bottom-up Tabulation, O(n * m^2) time, O(n * m^2) space)</li>
 *   <li>Space-Optimized Iterative DP (O(n * m^2) time, O(m^2) space)</li>
 * </ol>
 * </p>
 */
public class __DP13__CherryPickupII {
    private static final int INF = (int) 1e8;

    /**
     * 1. Pure Recursion (Exponential).
     * <p>
     * Intuition:
     * - At row r, robot1 at column c1, robot2 at column c2.
     * - Both move simultaneously to next row → explore all 9 (3x3) move combinations.
     * - Base: if out of bounds → invalid. If last row → take cherries.
     * - Transition: cherries at (r, c1, c2) + best of recursive calls.
     * <p>
     * Complexity:
     * - Time: O(3^n) (explores all possibilities)
     * - Space: O(n) recursion depth
     */
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        return solve(0, 0, m - 1, n, m, grid);
    }

    private int solve(int r, int c1, int c2, int n, int m, int[][] grid) {
        if (c1 < 0 || c1 >= m || c2 < 0 || c2 >= m) return -INF;

        if (r == n - 1) {
            if (c1 == c2) return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }

        int maxi = 0;
        for (int dc1 = -1; dc1 <= 1; dc1++) {
            for (int dc2 = -1; dc2 <= 1; dc2++) {
                int val = (c1 == c2) ? grid[r][c1] : grid[r][c1] + grid[r][c2];
                val += solve(r + 1, c1 + dc1, c2 + dc2, n, m, grid);
                maxi = Math.max(maxi, val);
            }
        }
        return maxi;
    }

    /**
     * 2. Recursion + Memoization (Top-Down DP).
     * <p>
     * State:
     * dp[r][c1][c2] = max cherries from row r to bottom,
     *                 when robot1 at col c1, robot2 at col c2.
     * <p>
     * Transition:
     * - Try all 9 combinations (dc1, dc2).
     * - Take cherries at (r, c1, c2) + best of next states.
     * <p>
     * Complexity:
     * - Time: O(n * m^2 * 9) ≈ O(n * m^2)
     * - Space: O(n * m^2) + O(n) recursion
     */
    private int solve_memo(int r, int c1, int c2, int n, int m, int[][] grid, int[][][] dp) {
        if (c1 < 0 || c1 >= m || c2 < 0 || c2 >= m) return -INF;

        if (r == n - 1) {
            if (c1 == c2) return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }

        if (dp[r][c1][c2] != -1) return dp[r][c1][c2];

        int maxi = 0;
        for (int dc1 = -1; dc1 <= 1; dc1++) {
            for (int dc2 = -1; dc2 <= 1; dc2++) {
                int val = (c1 == c2) ? grid[r][c1] : grid[r][c1] + grid[r][c2];
                val += solve_memo(r + 1, c1 + dc1, c2 + dc2, n, m, grid, dp);
                maxi = Math.max(maxi, val);
            }
        }
        return dp[r][c1][c2] = maxi;
    }

    public int cherryPickup_memo(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        var dp = new int[n + 1][m + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve_memo(0, 0, m - 1, n, m, grid, dp);
    }

    /**
     * 3. Tabulation (Bottom-Up DP).
     * <p>
     * Build dp from last row upwards.
     * dp[r][c1][c2] = max cherries starting from (r, c1, c2).
     * <p>
     * Initialization:
     * - Last row: direct cherries picked.
     * <p>
     * Transition:
     * - For each (r, c1, c2) take cherries + max of 9 possible moves to next row.
     * <p>
     * Complexity:
     * - Time: O(n * m^2 * 9) ≈ O(n * m^2)
     * - Space: O(n * m^2)
     */
    public int cherryPickup_tabulation(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        var dp = new int[n + 1][m + 1][m + 1];

        // Base case: last row
        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = 0; c2 < m; c2++) {
                if (c1 == c2) dp[n - 1][c1][c2] = grid[n - 1][c1];
                else dp[n - 1][c1][c2] = grid[n - 1][c1] + grid[n - 1][c2];
            }
        }

        // Bottom-up fill
        for (int r = n - 2; r >= 0; r--) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    int maxi = -INF;
                    for (int dc1 = -1; dc1 <= 1; dc1++) {
                        for (int dc2 = -1; dc2 <= 1; dc2++) {
                            int val = (c1 == c2) ? grid[r][c1] : grid[r][c1] + grid[r][c2];
                            if (c1 + dc1 >= 0 && c1 + dc1 < m && c2 + dc2 >= 0 && c2 + dc2 < m) {
                                val += dp[r + 1][c1 + dc1][c2 + dc2];
                            }
                            maxi = Math.max(maxi, val);
                        }
                    }
                    dp[r][c1][c2] = maxi;
                }
            }
        }
        return dp[0][0][m - 1];
    }

    /**
     * 4. Space Optimized Tabulation.
     * <p>
     * Optimization:
     * - dp[r] only depends on dp[r+1].
     * - Reduce 3D dp to two 2D arrays (prev, cur).
     * <p>
     * Complexity:
     * - Time: O(n * m^2 * 9) ≈ O(n * m^2)
     * - Space: O(m^2)
     */
    public int cherryPickup_space_optimized(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        var prev = new int[m + 1][m + 1];

        // Base case
        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = 0; c2 < m; c2++) {
                if (c1 == c2) prev[c1][c2] = grid[n - 1][c1];
                else prev[c1][c2] = grid[n - 1][c1] + grid[n - 1][c2];
            }
        }

        // Bottom-up fill
        for (int r = n - 2; r >= 0; r--) {
            var cur = new int[m + 1][m + 1];
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    int maxi = -INF;
                    for (int dc1 = -1; dc1 <= 1; dc1++) {
                        for (int dc2 = -1; dc2 <= 1; dc2++) {
                            int val = (c1 == c2) ? grid[r][c1] : grid[r][c1] + grid[r][c2];
                            if (c1 + dc1 >= 0 && c1 + dc1 < m && c2 + dc2 >= 0 && c2 + dc2 < m) {
                                val += prev[c1 + dc1][c2 + dc2];
                            }
                            maxi = Math.max(maxi, val);
                        }
                    }
                    cur[c1][c2] = maxi;
                }
            }
            prev = cur;
        }
        return prev[0][m - 1];
    }
}
