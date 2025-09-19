package DSA.binarysearch;

/**
 * Problem: Sqrt(x)
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/sqrtx/description/">
 *       Sqrt(x)</a></li>
 *   <li>Difficulty: Easy</li>
 *   <li>Tags: binarysearch, math</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given a non-negative integer <code>x</code>, compute and return
 * the square root of <code>x</code> rounded down to the nearest integer.
 * You cannot use built-in functions like <code>sqrt()</code>.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>Use binary search in the range [2, x].</li>
 *   <li>Maintain an <code>ans</code> that tracks the floor value of sqrt.</li>
 *   <li>For each <code>mid</code>:
 *     <ul>
 *       <li>If <code>mid * mid &lt;= x</code> → valid candidate, move right.</li>
 *       <li>Else → move left.</li>
 *     </ul>
 *   </li>
 *   <li>At the end, <code>ans</code> is the floor(sqrt(x)).</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(log x) — binary search range reduces by half each step.</li>
 *   <li><b>Space:</b> O(1) — only a few variables used.</li>
 * </ul>
 */
public class __BS10__SqrtX {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int l = 2, h = x, ans = 1; // ans starts at 1 (important for x = 2)

        while (l <= h) {
            int mid = l + ((h - l) >> 1);

            long square = (long) mid * mid; // use long to avoid overflow

            if (square <= x) {
                ans = mid;   // record candidate
                l = mid + 1; // try bigger root
            } else {
                h = mid - 1; // try smaller root
            }
        }

        return ans;
    }
}
