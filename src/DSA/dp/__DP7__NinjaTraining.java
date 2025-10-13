package DSA.dp;


import java.util.Arrays;

/**
 * Problem: Ninja's Training
 * <ul>
 *   <li>Link: <a href="https://www.naukri.com/code360/problems/ninja-s-training_3621003">Ninja's Training</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: dp, top-down, bottom-up</li>
 * </ul>
 *
 * <p>
 * You are given N days and 3 activities per day (Running, Fighting, Sleeping).
 * Each activity gives certain points. The ninja cannot perform the same activity on two consecutive days.
 * Goal: Maximize total points over N days.
 * </p>
 *
 * <p>
 * <b>Intuition:</b>
 * <ol>
 *   <li>At day i, choose an activity j (0: Running, 1: Fighting, 2: Sleeping).</li>
 *   <li>Constraint: cannot repeat the same activity as day i-1.</li>
 *   <li>Recurrence:
 *       <pre>
 * dp[i][j] = points[i][j] + max(dp[i-1][x]) for all x != j
 *       </pre>
 *   </li>
 *   <li>Base case: dp[0][j] = points[0][j]</li>
 *   <li>Answer: max(dp[N-1][0], dp[N-1][1], dp[N-1][2])</li>
 * </ol>
 * </p>
 *
 * <p>
 * <b>Four approaches implemented:</b>
 * <ol>
 *   <li>Pure Recursion (Exponential)</li>
 *   <li>Recursion + Memoization (Top-down DP, O(N*3) time and space)</li>
 *   <li>Iterative DP (Bottom-up DP, O(N*3) time and space)</li>
 *   <li>Space-Optimized Iterative DP (O(N*3) time, O(3) space)</li>
 * </ol>
 * </p>
 */
public class __DP7__NinjaTraining {

    /**
     * 1. Pure recursive solution
     * @param day Current day index
     * @param last Last activity performed (-1 if no activity yet)
     * @param points Points matrix
     * @return Maximum points achievable
     * <p>
     * Time Complexity: O(3^N)
     * Space Complexity: O(N) recursion stack
     * </p>
     */
    private int maxPointsRecursive(int day, int last, int[][] points) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) max = Math.max(max, points[0][task]);
            }
            return max;
        }

        int maxPoints = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int pointsToday = points[day][task] + maxPointsRecursive(day - 1, task, points);
                maxPoints = Math.max(maxPoints, pointsToday);
            }
        }
        return maxPoints;
    }

    /**
     * 2. Recursion + Memoization (Top-down DP)
     * @param day Current day index
     * @param last Last activity performed
     * @param points Points matrix
     * @param dp Memoization table dp[day][last]
     * @return Maximum points achievable
     * <p>
     * Time Complexity: O(N*4)
     * Space Complexity: O(N*4) for dp + recursion stack
     * </p>
     */
    private int maxPointsMemo(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) max = Math.max(max, points[0][task]);
            }
            return max;
        }

        if (dp[day][last] != -1) return dp[day][last];

        int maxPoints = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int pointsToday = points[day][task] + maxPointsMemo(day - 1, task, points, dp);
                maxPoints = Math.max(maxPoints, pointsToday);
            }
        }
        return dp[day][last] = maxPoints;
    }

    /**
     * 3. Iterative DP (Bottom-up)
     * @param points Points matrix
     * @return Maximum points achievable
     * <p>
     * Time Complexity: O(N*3*2)
     * Space Complexity: O(N*4) → dp[day][last]
     * </p>
     */
    private int maxPointsIterative(int[][] points) {
        int N = points.length;
        int[][] dp = new int[N][4];

        // Base case: day 0
        for (int last = 0; last < 4; last++) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) max = Math.max(max, points[0][task]);
            }
            dp[0][last] = max;
        }

        // Fill dp table
        for (int day = 1; day < N; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day - 1][task]);
                    }
                }
            }
        }

        return dp[N - 1][3]; // last = 3 means “no restriction” for last day
    }

    /**
     * 4. Space-Optimized Iterative DP
     * Only store dp for previous day
     * @param points Points matrix
     * @return Maximum points achievable
     * <p>
     * Time Complexity: O(N*3*2)
     * Space Complexity: O(4)
     * </p>
     */
    private int maxPointsSpaceOptimized(int[][] points) {
        int N = points.length;
        int[] prev = new int[4];

        // Base case: day 0
        for (int last = 0; last < 4; last++) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) max = Math.max(max, points[0][task]);
            }
            prev[last] = max;
        }

        // DP iteration
        for (int day = 1; day < N; day++) {
            int[] curr = new int[4];
            for (int last = 0; last < 4; last++) {
                curr[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        curr[last] = Math.max(curr[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = curr;
        }

        return prev[3];
    }

    /**
     * Helper to call memoized solution easily
     */
    public int ninjaTrainingMemo(int[][] points) {
        int N = points.length;
        int[][] dp = new int[N][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        return maxPointsMemo(N - 1, 3, points, dp);
    }

    /**
     * Helper to call space-optimized DP
     */
    public int ninjaTraining(int[][] points) {
        return maxPointsSpaceOptimized(points);
    }
}
