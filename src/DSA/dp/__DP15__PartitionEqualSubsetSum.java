package DSA.dp;

import java.util.Arrays;

/**
 * Problem: Partition Equal Subset Sum
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/partition-equal-subset-sum/description/">
 *       Partition Equal Subset Sum</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Dynamic Programming, Subset Sum</li>
 * </ul>
 *
 * <p><b>Problem Statement:</b><br>
 * Given an integer array nums, return true if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.</p>
 *
 * <p><b>Intuition:</b><br>
 * - The problem reduces to checking if there exists a subset with sum = totalSum / 2.<br>
 * - If totalSum is odd → impossible to partition equally.<br>
 * - Use recursion, memoization, or tabulation (bottom-up DP) to solve efficiently.</p>
 *
 * <p><b>Approaches Covered:</b></p>
 * <ol>
 *   <li>Recursive (Exponential)</li>
 *   <li>Memoization (Top-Down DP)</li>
 *   <li>Tabulation (Bottom-Up DP)</li>
 * </ol>
 *
 * <p><b>Time Complexity:</b>
 * <ul>
 *   <li>Recursive → O(2^n)</li>
 *   <li>Memoized → O(n * target)</li>
 *   <li>Tabulated → O(n * target)</li>
 * </ul>
 * </p>
 *
 * <p><b>Space Complexity:</b>
 * <ul>
 *   <li>Recursive → O(n)</li>
 *   <li>Memoized → O(n * target)</li>
 *   <li>Tabulated → O(n * target)</li>
 * </ul>
 * </p>
 */
public class __DP15__PartitionEqualSubsetSum {

    /**
     * Recursive Approach
     * <p>
     * Checks all possible subsets to find one whose sum = totalSum/2.
     * Exponential time, but good for understanding recursion flow.
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false; // odd sum can't be split equally
        return solve(nums.length - 1, sum / 2, nums);
    }

    private boolean solve(int ind, int target, int[] nums) {
        if (target == 0) return true;
        if (ind == 0) return nums[0] == target;

        boolean notPick = solve(ind - 1, target, nums);
        boolean pick = false;
        if (nums[ind] <= target)
            pick = solve(ind - 1, target - nums[ind], nums);

        return pick || notPick;
    }

    /**
     * Memoization Approach (Top-Down DP)
     * <p>
     * Stores intermediate results in a dp table to avoid recomputation.
     * Converts exponential recursion into polynomial time.
     */
    public boolean canPartition_dp(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve_memo(n - 1, target, nums, dp);
    }

    private boolean solve_memo(int ind, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return nums[0] == target;

        if (dp[ind][target] != -1) return dp[ind][target] == 1;

        boolean notPick = solve_memo(ind - 1, target, nums, dp);
        boolean pick = false;
        if (nums[ind] <= target)
            pick = solve_memo(ind - 1, target - nums[ind], nums, dp);

        dp[ind][target] = (pick || notPick) ? 1 : 0;
        return dp[ind][target] == 1;
    }

    /**
     * Tabulation Approach (Bottom-Up DP)
     * <p>
     * Builds the dp table iteratively to find if subset sum = target exists.
     * Most intuitive for interviews and ideal for revision.
     */
    public boolean canPartition_tabulation(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        // Base Case: sum = 0 is always achievable
        for (int i = 0; i < n; i++) dp[i][0] = true;

        // Base Case: using only first element
        if (nums[0] <= target) dp[0][nums[0]] = true;

        // Build table
        for (int ind = 1; ind < n; ind++) {
            for (int t = 1; t <= target; t++) {
                boolean notPick = dp[ind - 1][t];
                boolean pick = false;
                if (nums[ind] <= t)
                    pick = dp[ind - 1][t - nums[ind]];
                dp[ind][t] = pick || notPick;
            }
        }

        return dp[n - 1][target];
    }

    /**
     * space optimized version
     */

    public boolean canPartition_spaceOptimized(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;

        if (nums[0] <= target)
            prev[nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int t = 1; t <= target; t++) {
                boolean notPick = prev[t];
                boolean pick = false;
                if (nums[i] <= t)
                    pick = prev[t - nums[i]];
                curr[t] = pick || notPick;
            }
            prev = curr;
        }

        return prev[target];
    }
}
