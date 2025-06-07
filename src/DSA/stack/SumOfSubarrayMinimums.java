package DSA.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Sum Of Subarray Minimums
 * Link: <a href="https://leetcode.com/problems/sum-of-subarray-minimums/description/">Click here</a>
 * Difficulty: Medium
 * Tags: stack
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class SumOfSubarrayMinimums {
    private static final int MOD = (int) 1e9 + 7;

    // Brute force approach - Generating all possible subarrays
    public int sumSubarrayMinsBruteForce(int[] arr) {
        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                result = (result + min) % MOD;
            }
        }
        return result;
    }

    // optimal approach 1.
    // by using monotonic stack + dp solution
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0L;
        long[] dp = new long[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                dp[i] = (dp[prev] + (long) (i - prev) * arr[i]) % MOD;
            } else {
                dp[i] = ((long) (i + 1) * arr[i]) % MOD;
            }

            sum = (sum + dp[i]) % MOD;
            stack.push(i);
        }
        return (int) sum;
    }

    // approach 2: by using PSE, NSE
    public int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Previous Smaller Element (strictly less: >)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element (greater than or equal: >=)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long count = (long)(i - prev[i]) * (next[i] - i) % MOD;
            result = (result + count * arr[i]) % MOD;
        }

        return (int) result;
    }
}
