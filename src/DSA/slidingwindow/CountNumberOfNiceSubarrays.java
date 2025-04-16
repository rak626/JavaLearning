package DSA.slidingwindow;

/**
 * Problem: Count Number Of Nice Subarrays
 * Link: <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/description/">...</a>
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums, k) - func(nums, k - 1);

    }

    public int func(int[] nums, int k) {
        if (k < 0) return 0;
        int n = nums.length;
        int l = 0, cnt = 0, ans = 0;

        for (int r = 0; r < n; r++) {
            if ((nums[r] & 1) == 1) {
                cnt++;
            }
            while (cnt > k) {
                if ((nums[l] & 1) == 1) {
                    cnt--;
                }
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
