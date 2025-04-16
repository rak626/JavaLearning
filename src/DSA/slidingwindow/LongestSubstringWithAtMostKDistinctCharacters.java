package DSA.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Longest Substring With At Most K Distinct Characters
 * Link: <a href="https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/">...</a>
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int kDistinctChars(int k, String str) {
        int n = str.length();
        int left = 0, maxLen = 0;
        Map<Character, Integer> cnt = new HashMap<>();

        for (int right = 0; right < n; right++) {
            cnt.merge(str.charAt(right), 1, Integer::sum);

            while (cnt.size() > k) {
                if (cnt.merge(str.charAt(left), -1, Integer::sum) == 0) {
                    cnt.remove(str.charAt(left));
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
